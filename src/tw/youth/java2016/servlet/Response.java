package tw.youth.java2016.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Response
 */
@WebServlet("/Response")
public class Response extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("<html>").append("\n").append("<head>").append("\n").append("Set").append("\n")
				.append("</head>").append("\n").append("<title>").append("Byte").append("</title>").append("\n")
				.append("<br>").append("<body>").append("Hello").append("\n").append("<br>");

		int num = Integer.parseInt(request.getParameter("num"));
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < i + 1; j++) {
				response.getWriter().append("☆");
			}
			response.getWriter().append("<br>");
		}

		response.getWriter().append("</body>").append("</html>");
	}

}
