package com.employee.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.Entity.Employee;
import com.employee.Repository.EmployeeRepository;

@Repository
public class EmployeeDao {
@Autowired
EmployeeRepository er;
public String add(Employee s) {
	er.save(s);
	return "posted";
}
public String all(List<Employee>ea) {
	er.saveAll(ea);
	return "POSTED";
}
public Employee get(int g) {
	return er.findById(g).get();
	// findbyid is a optional class so we need to put get
}
public String update(int id,Employee e ) {
	er.save(e);
	return "UPDATED";
}
public String delete(int id) {
	er.deleteById(id);
	return "DELETED";
}
public List<Employee>getall(){
	return er.findAll();
}
public List<Employee> getallemp() {
	return er.getallemp();
}
public List<Employee> getage(int age) {
	return er.getage(age);
}
public List<Employee> getallbyage(int x){
	return er.getallbyage(x);}

public List<Employee> getallsalary(int a){
	return er.getallsalary(a);
}
public Employee getexc(int g) {
	return er.findById(g).get();
}
public List<Employee> getname(String a) {
	return er.getname(a);
}


}