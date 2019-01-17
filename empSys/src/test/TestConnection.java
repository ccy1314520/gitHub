package test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.zyz.empSys.pojo.Emp;
import com.zyz.empSys.service.IEmpService;
import com.zyz.empSys.service.impl.EmpServiceImpl;
import com.zyz.empSys.utils.C3P0DBUtils;

/**
 * 测试与数据库的连接
 * @author XHY
 */
public class TestConnection {
	private static DataSource source = C3P0DBUtils.getDataSource();
	private static QueryRunner runner=new QueryRunner(source);
	private static IEmpService ies =new EmpServiceImpl();
	/**
	 * 测试与与数据库连接的连接对象是否存在
	 * @throws SQLException
	 */
	@Test
	public void testConnection() throws SQLException{
		/*Connection connection = C3P0DBUtils.getConnection();
		System.out.println(connection);*/
	}
	@Test
	public void testLogin() {
		Emp emp = ies.empLoginByNameAndPassword("zdy", "123");
		System.out.println(emp);
	}
	
	

}
