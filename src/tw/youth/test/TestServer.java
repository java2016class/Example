package tw.youth.test;

import java.sql.SQLException;

import org.junit.Test;

import tw.youth.java2016.Server;

public class TestServer {

	//�M���ϥΨӴ���class�O�_���`��Testcase(���ծר�)
	//���b�o�̴���Servlet�|���ġA�ר�O���ɤJjar���ɭ�
	@Test
	public void test() throws SQLException {
		// fail("Not yet implemented");
		System.out.println(new Server().chkServer());
	}

}
