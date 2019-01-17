package com.zyz.empSys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zyz.empSys.dao.IEmpDao;
import com.zyz.empSys.pojo.Emp;
import com.zyz.empSys.utils.C3P0DBUtils;

/**
 * 实现IEmpDao接口
 * @author XHY
 */
public class EmpDaoImpl implements IEmpDao{
	
	// 获取到数据库当中的元数据
	private static DataSource source = C3P0DBUtils.getDataSource();
	private static QueryRunner runner=new QueryRunner(source);
	@Override
	public Emp findEmpByNameAndPassword(String name, String password) {
		try {
			//将查询到的结果封装到Emp实体类中后同时封装到list集合中
			List<Emp> empList = runner.query("select * from emp where name=? and password=?", new BeanListHandler<Emp>(Emp.class), name,password);
			if(empList.size()!=0) {
				return  empList.get(0);
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	@Override
	public List<Emp> findAllEmps() {
		try {
			//获取到所有的员工信息，封装到list集合当中
			List<Emp> list = runner.query("select * from emp", new BeanListHandler<Emp>(Emp.class));
			if(list!=null) {
				return list;
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int addOneEmp(Emp emp) {
		try {
			int line = runner.update("insert into emp values(null,?,?,?,?,?,?,?,?)",
					emp.getName(),emp.getPassword(),emp.getGender(),emp.getAge(),
					emp.getHiredate(),emp.getSalary(),emp.getPhone(),emp.getEmail());
			return line;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public Emp findEmpById(int id) {
		try {
			Emp emp = runner.query("select * from emp where id=?", new BeanHandler<Emp>(Emp.class), id);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int updateEmp(Emp emp) {
		try {
			int line = runner.update("update emp set name=?,password=?,gender=?,age=?,hiredate=?,salary=?,phone=?,email=? where id=?",
					emp.getName(),emp.getPassword(),emp.getGender(),emp.getAge(),emp.getHiredate(),emp.getSalary(),emp.getPhone(),
					emp.getEmail(),emp.getId()
					 );
			return line;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int deleteEmpById(int id) {
		try {
			int line = runner.update("delete from emp where id=?", id);
			if(line!=0) {
				return line;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public List<Emp> findEmpsByQC(String sql, String... params) {
		try {
			runner.query(sql, new BeanListHandler<Emp>(Emp.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
