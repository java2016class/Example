package tw.youth.java2016;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Server {
	Connection conn;

	public Server() {
		try {
			// �M��Mysql�X��
			// �o�̪�mysql-connector-java-5.1.39.jar�X�ʭn
			// �ۦ��ʩ�J WebContent��Ƨ� >> WEB-INF��Ƨ� >> lib��Ƨ���
			Class.forName("com.mysql.jdbc.Driver");

			// �s�uMysql�A�e���O���}�A�᭱�̧ǬO�b���B�K�X
			conn = DriverManager.getConnection("jdbc:mysql://localhost", "odise", "116025");

			// �إ߸�Ʈw�A�o�y�k�]�w��"�p�G��Ʈw���s�b�N�إ�"
			conn.createStatement().executeUpdate("CREATE SCHEMA IF NOT EXISTS example");

			//�إ߸�ƪ�A�o�y�k�]�w��"�p�G��ƪ��s�b�N�إ�"
			conn.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS example.login ("
					+ "  USERNAME VARCHAR(20) NULL," + "  PASSWORD VARCHAR(20) NULL)");

			//�o�̹w���b��ƪ��إߤ@�ӨϥΪ̡Aif�ԭz���@�ˬO�ˬd�ϥΪ̦s���s�b�A���s�b�~�|�إ�
			String[] user = { "root", "123456" };
			if (!chkUser(user[0]))
				createUser(user);

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	//�ˬdconn�s�u�O�_���\�إߡA�s�u���ѫh�|�o��null
	public boolean chkServer() throws SQLException {
		return conn != null;
	}

	//�ˬd�ϥΪ̬O�_�s�b?
	public boolean chkUser(String user) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from example.login where username=?");
			ps.setString(1, user);
			
			ResultSet rs = ps.executeQuery();
			System.out.println("chkUser");
			while (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return false;
		}
	}

	//�ˬd�b���K�X�O�_���T?
	public boolean chkLogin(String[] user) {

		PreparedStatement ps;
		boolean chk = false;
		try {
			ps = conn.prepareStatement("select * from example.login where username=?");
			ps.setString(1, user[0]);
			ResultSet rs = ps.executeQuery();
			System.out.println("chkLogin");
			//���ϥΪ̨��ˬd�K�X�A�o�Ӱj��쥻�]�p�Ӽ��h�Ӹ��
			while (rs.next()) {
				if (rs.getString(1).equals(user[0]) && rs.getString(2).equals(user[1])) {
					chk = true;
				}
			}
			return chk;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return chk;
		}
	}

	//�إߨϥΪ�
	public boolean createUser(String[] user) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("insert into example.login (USERNAME,PASSWORD) values(?,?)");
			ps.setString(1, user[0]);
			ps.setString(2, user[1]);
			ps.executeUpdate();
			System.out.println("createUser");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return true;
	}

}
