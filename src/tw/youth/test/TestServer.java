package tw.youth.test;

import java.sql.SQLException;

import org.junit.Test;

import tw.youth.java2016.Server;

public class TestServer {

	//專門使用來測試class是否正常的Testcase(測試案例)
	//但在這裡測試Servlet會失效，尤其是有導入jar的時候
	@Test
	public void test() throws SQLException {
		// fail("Not yet implemented");
		System.out.println(new Server().chkServer());
	}

}
