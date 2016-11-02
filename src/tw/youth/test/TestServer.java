package tw.youth.test;

import java.sql.SQLException;

import org.junit.Test;

import tw.youth.java2016.Server;
import tw.youth.java2016.Server2;

public class TestServer {

	// 專門使用來測試class是否正常的Testcase(測試案例)
	// 但在這裡測試Servlet會失效，尤其是有導入jar的時候
	@Test
	public void test() throws SQLException {
		// fail("Not yet implemented");
		{ // static{}第一次啟動，觸發static class
			System.out.println(new Server().chkServer());
			System.out.println(Server.conn);
		}
		{ // 檢查指向記憶體位置是否相同? 這裡是相同
			System.out.println(new Server().chkServer());
			System.out.println(Server.conn);
		}

		// 未設定static的指向
		{
			System.out.println(new Server2().chkServer());
			System.out.println(Server2.conn);
		}
		{ // 檢查指向記憶體位置是否相同? 這裡是不相同
			System.out.println(new Server2().chkServer());
			System.out.println(Server2.conn);
		}
	}

}
