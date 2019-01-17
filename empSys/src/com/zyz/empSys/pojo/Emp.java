package com.zyz.empSys.pojo;

import java.io.Serializable;
import java.sql.Date;

/**
 * 员工实体类
 */
@SuppressWarnings("serial")
public class Emp implements Serializable {
	private Integer id;// 员工id
	private String name;// 员工姓名
	private String password;// 登录密码
	private String gender;// 员工性别
	private Integer age;// 年龄
	private Date hiredate;// 入职日期
	private Double salary;// 薪资
	private String phone;// 电话号码
	private String email;// 电子邮箱

	/**
	 * 空参构造
	 */
	public Emp() {
	}

	/**
	 * 有参构造
	 * 
	 * @param id
	 * @param name
	 * @param password
	 * @param gender
	 * @param age
	 * @param hiredate
	 * @param salary
	 * @param phone
	 * @param email
	 */
	public Emp(Integer id, String name, String password, String gender, Integer age, Date hiredate, Double salary,
			String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.hiredate = hiredate;
		this.salary = salary;
		this.phone = phone;
		this.email = email;
	}
	/**
	 * 有参构造
	 * @param name
	 * @param password
	 * @param gender
	 * @param age
	 * @param phone
	 * @param email
	 */
	public Emp(String name, String password, String gender, Integer age,
			String phone, String email) {
		super();
		
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", password=" + password + ", gender=" + gender + ", age=" + age
				+ ", hiredate=" + hiredate + ", salary=" + salary + ", phone=" + phone + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
