package com.zyz.empSys.service;

import java.util.List;

import com.zyz.empSys.pojo.Emp;

/**
 * 为emp提供服务的接口
 * @author XHY
 */
public interface IEmpService {
	/**
	 * 员工通过名称和密码进行登录
	 * @param name
	 * @param passsword
	 * @return
	 */
	Emp empLoginByNameAndPassword(String name,String password);
	/**
	 * 展示所有的员工信息
	 * @return
	 */
	List<Emp> displayAllEmps();
	/**
	 * 注册员工
	 * @param emp
	 * @return
	 */
	boolean registerEmp(Emp emp);
	/**
	 * 根据id查询到对应的员工信息
	 * @param id
	 * @return
	 */
	Emp findEmpById(int id);
	/**
	 * 判断是否修改成功
	 * @param emp
	 * @return
	 */
	boolean editSuccess(Emp emp);
	/**
	 * 通过id进行删除
	 * @param id
	 * @return
	 */
	boolean deleteByIdSuccess(int id);
	
}
