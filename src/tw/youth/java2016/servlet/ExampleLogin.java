package tw.youth.java2016.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.youth.java2016.Server;

/**
 * Servlet implementation class ExampleLogin
 */
@WebServlet("/ExampleLogin")
public class ExampleLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Server server = null;

	/**
	 * Default constructor.
	 */
	public ExampleLogin() {
		// TODO Auto-generated constructor stub
		server = new Server();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// doGet 會在網址上顯示輸入的資料 所以傳遞重要資料時 不建議使用
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 直接讀取Servlet時會秀這段
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// get的中文編碼問題要使用下列方法處理
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// 隱藏網址傳遞的參數
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		// 設定擷取的網頁編碼為UTF-8，與網頁端編碼一致就不會有亂碼問題
		request.setCharacterEncoding("UTF-8");

		// 取得路徑
		String path = request.getContextPath();
		System.out.println(path);

		// 取得表頭參數
		Enumeration<String> names = request.getHeaderNames();
		String name;
		while ((name = names.nextElement()) != null) {
			System.out.println(name);
		}

		// 擷取網頁傳遞來的user跟pass參數
		String[] user = { request.getParameter("user"), request.getParameter("pass") };

		// 設定轉傳遞給其他網頁的參數，這裡設定屬性值含有user跟pass參數
		request.setAttribute("user", user[0]);
		request.setAttribute("pass", user[1]);

		// 使用驗證使用者功能，確認帳號密碼是否正確?
		// 若正確就傳遞給success.jsp網頁並跳轉，若不正確就傳遞給failure.jsp網頁並跳轉
		if (server.chkLogin(user)) {
			ArrayList<String> arr = server.query("o");
			for (String string : arr) {
				System.out.println(string);
			}
			request.setAttribute("query", server.query("o")); // 模糊搜尋含有o字眼的資料
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/failure.jsp").forward(request, response);
		}

	}

}
