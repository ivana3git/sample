package com.employee.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Dao.EmployeeDao;
import com.employee.Entity.Employee;
import com.employee.exceptions.AgeException;
import com.employee.exceptions.NameException;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao ed;

	public String add(Employee e) {
		return ed.add(e);
	}

	public String all(List<Employee> ea) {
		return ed.all(ea);
	}

	public Employee get(int g) {
		return ed.get(g);
	}

	public String update(int id, Employee e) {
		return ed.update(id, e);
	}

	public String delete(int id) {
		return ed.delete(id);
	}

	public List<Employee> getall() {
		return ed.getall();
	}

	public List<Employee> getbyage() {
		List<Employee> emp = ed.getall();
		List<Employee> empage = new ArrayList<>();
		emp.forEach(x -> {
			if (x.getAge() > 25) {
				empage.add(x);
			}
		});
		return empage;
	}

	public Employee getmax() {
		List<Employee> emp = ed.getall();
		Employee max = emp.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst().get();
		return max;
	}

	/*
	 * public Employee getsecmax() { List<Employee>emp=ed.getall(); Employee secmax=
	 * emp.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).
	 * skip(1).findFirst().get(); return secmax; }
	 */
	public Employee getsecmax() {
		List<Employee> emp = ed.getall();

		for (int i = 0; i < emp.size(); i++) {
			for (int j = i + 1; j < emp.size(); j++) {
				if (emp.get(i).getSalary() > emp.get(j).getSalary()) {
					Employee temp = emp.get(i);
					emp.set(i, emp.get(j));
					emp.set(j, temp);
				}
			}
		}
		return emp.get(1);
	}

	public List<String> getname() {
		List<Employee> emp = ed.getall();
		List<String> name = emp.stream().map(x -> x.getName()).filter(x -> x.length() > 4).collect(Collectors.toList());
		return name;
	}

	public String agename() {
		List<Employee> emp = ed.getall();
		Employee agename = emp.stream().sorted(Comparator.comparing(Employee::getAge)).findFirst().get();
		return agename.getName() + " " + agename.getAge();
	}

	public List<Integer> age() {
		List<Employee> emp = ed.getall();
		List<Integer> age = emp.stream().map(x -> x.getAge()).distinct().collect(Collectors.toList());
		return age;
	}

	public Set<Employee> count() {
		List<Employee> emp = ed.getall();
		Set<Employee> a = emp.stream().filter(x -> Collections.frequency(emp, x) > 1).collect(Collectors.toSet());
		return a;
	}

	public List<Employee> getallemp() {
		return ed.getallemp();
	}

	public List<Employee> getage(int age) {
		return ed.getage(age);
	}

	public List<Employee> getallbyage(int x) {
		return ed.getallbyage(x);
	}

	public List<Employee> getallsalary(int a) {
		return ed.getallsalary(a);
	}

	public String getexc(int g) throws AgeException {

		if (ed.get(g).getAge() > 30) {
			return ed.get(g) + "";
		} else {
			throw new AgeException("Age Exception");
		}
	}

	public List<Employee> getname(String a) throws AgeException {
		if (ed.getname(a).isEmpty()) {
			throw new AgeException("value is Empty");
		}
		return ed.getname(a);
	}

	public String getnamebyid( int a) throws NameException {
		String name=ed.get(a).getName();
			if(name.startsWith("r")) {
				return name;}
		else {
			throw new NameException("INVALID");
		}	
	}
	public String getbad(int a) throws Exception {
		if(ed.get(a).getExperience()>5) {
			ed.get(a).setSalary(ed.get(a).getSalary()+500) ;
			 return "salary added";
		}
		else {
			throw new Exception (" not possible");
		}
		
	}
}