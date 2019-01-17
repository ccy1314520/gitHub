package com.zyz.empSys.dao;
/**
 * emp的dao接口
 * @author XHY
 */

import java.util.List;

import com.zyz.empSys.pojo.Emp;

public interface IEmpDao {
	/**
	 * 通过名字和姓名在数据库中查找对应的员工信息
	 * @param name
	 * @param password
	 * @return
	 */
	Emp findEmpByNameAndPassword(String name,String password);
	/**
	 * 获得所有的员工信息
	 * @return
	 */
	List<Emp> findAllEmps();
	/**
	 * 增加一条员工信息，返回数据库中添加信息返回的受影响的行数
	 * @return
	 */
	int addOneEmp(Emp emp);
	/**
	 * 根据id查询到对应的员工信息
	 * @param id
	 * @return
	 */
	Emp findEmpById(int id);
	/**
	 * 修改员工信息返回受影响的行数
	 * @param emp
	 * @return
	 */
	int updateEmp(Emp emp);
	/**
	 * 通过id对员工进行删除，返回删除的员工对象
	 * @param id
	 * @return
	 */
	int deleteEmpById(int id);
	/**
	 * 根据sql语句进行查询,sql的参数封装到一个条件数组当中
	 * @param sql
	 * @param criteria
	 * @return
	 */
	List<Emp> findEmpsByQC(String sql,String...params);
}
