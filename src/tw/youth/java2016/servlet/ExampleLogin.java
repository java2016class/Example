package tw.youth.java2016.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	// doGet �|�b���}�W��ܿ�J����� �ҥH�ǻ����n��Ʈ� ����ĳ�ϥ�
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����Ū��Servlet�ɷ|�q�o�q
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// ���ú��}�ǻ����Ѽ�
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		// �]�w�^���������s�X��UTF-8�A�P�����ݽs�X�@�P�N���|���ýX���D
		request.setCharacterEncoding("UTF-8");

		// �^�������ǻ��Ӫ�user��pass�Ѽ�
		String[] user = { request.getParameter("user"), request.getParameter("pass") };

		// �]�w��ǻ�����L�������ѼơA�o�̳]�w�ݩʭȧt��user��pass�Ѽ�
		request.setAttribute("user", user[0]);
		request.setAttribute("pass", user[1]);

		// �ϥ����ҨϥΪ̥\��A�T�{�b���K�X�O�_���T?
		// �Y���T�N�ǻ���success.jsp�����ø���A�Y�����T�N�ǻ���failure.jsp�����ø���
		if (server.chkLogin(user)) {
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/failure.jsp").forward(request, response);
		}

	}

}
