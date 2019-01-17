package com.zyz.empSys.service.impl;

import java.util.List;

import com.zyz.empSys.dao.IEmpDao;
import com.zyz.empSys.dao.impl.EmpDaoImpl;
import com.zyz.empSys.pojo.Emp;
import com.zyz.empSys.service.IEmpService;

public class EmpServiceImpl implements IEmpService {
	IEmpDao empd=new EmpDaoImpl();
	@Override
	public Emp empLoginByNameAndPassword(String name, String password) {
		
		return empd.findEmpByNameAndPassword(name, password);
	}
	@Override
	public List<Emp> displayAllEmps() {
		return empd.findAllEmps();
	}
	@Override
	public boolean registerEmp(Emp emp) {
		int line = empd.addOneEmp(emp);
		if(line!=0){
			return true;
		}
		return false;
	}
	@Override
	public Emp findEmpById(int id) {
		Emp emp = empd.findEmpById(id);
		if(emp!=null) {
			return emp;
		}
		return null;
	}
	@Override
	public boolean editSuccess(Emp emp) {
		int line = empd.updateEmp(emp);
		if(line!=0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteByIdSuccess(int id) {
		int line = empd.deleteEmpById(id);
		if(line!=0) {
			return true;
		}
		return false;
	}

}
