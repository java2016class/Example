package tw.youth.java2016;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Server2 {
	public static Connection conn;

	public Server2() {

		try {
			// 尋找Mysql驅動
			// 這裡的mysql-connector-java-5.1.39.jar驅動要
			// 自行手動放入 WebContent資料夾 >> WEB-INF資料夾 >> lib資料夾內
			Class.forName("com.mysql.jdbc.Driver");

			// 連線Mysql，前面是網址，後面依序是帳號、密碼
			conn = DriverManager.getConnection("jdbc:mysql://localhost", "odise", "116025");

			// 建立資料庫，這語法設定為"如果資料庫不存在就建立"
			conn.createStatement().executeUpdate("CREATE SCHEMA IF NOT EXISTS example");

			// 建立資料表，這語法設定為"如果資料表不存在就建立"
			conn.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS example.login ("
					+ "  USERNAME VARCHAR(20) NULL," + "  PASSWORD VARCHAR(20) NULL)");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		// 這裡預先在資料表內建立使用者，if敘述內一樣是檢查使用者存不存在，不存在才會建立
		String[] user = { "root", "123456" };
		String[] user2 = { "odise", "116025" };
		String[] user3 = { "oxygen", "987654" };
		if (!chkUser(user[0]))
			createUser(user);
		if (!chkUser(user[1]))
			createUser(user2);
		if (!chkUser(user[2]))
			createUser(user3);

	}

	// 檢查conn連線是否成功建立，連線失敗則會得到null
	public boolean chkServer() throws SQLException {
		return conn != null;
	}

	// 檢查使用者是否存在?
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

	// 檢查帳號密碼是否正確?
	public boolean chkLogin(String[] user) {

		PreparedStatement ps;
		boolean chk = false;
		try {
			ps = conn.prepareStatement("select * from example.login where username=?");
			ps.setString(1, user[0]);
			ResultSet rs = ps.executeQuery();
			System.out.println("chkLogin");
			// 撈使用者並檢查密碼，這個迴圈原本設計來撈多個資料
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

	// 建立使用者
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

	public ArrayList<String> query(String value) {//模糊搜尋

		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM example.login WHERE USERNAME LIKE ?");
			ps.setObject(1, "%" + value + "%");
			ResultSet rs = ps.executeQuery();
			ArrayList<String> arr = new ArrayList<>();
			while (rs.next()) {
				arr.add(rs.getString(1));
			}
			return arr;
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return null;
		}

	}

}
