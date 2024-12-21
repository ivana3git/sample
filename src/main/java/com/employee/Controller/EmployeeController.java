package com.employee.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Entity.Employee;
import com.employee.Service.EmployeeService;
import com.employee.exceptions.AgeException;
import com.employee.exceptions.NameException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;






@RestController
public class EmployeeController {
@Autowired
EmployeeService es;

@PostMapping(value="/add")
public String add(@RequestBody Employee e) { 
    return es.add(e);
}
@PostMapping(value="/all")
public String all(@RequestBody List<Employee> ea) {
	return es.all(ea);
}
@GetMapping(value="/get/{g}")
public Employee get(@PathVariable int g) {
	return es.get(g); 
}
@PutMapping(value="/update/{id}")
public String update(@PathVariable int id, @RequestBody Employee e) {
    return es.update(id,e);
}
@GetMapping(value="/delete/{id}")
public String delete(@PathVariable int id) {
	return es.delete(id);
}
@GetMapping(value="/getall")
public List<Employee> getall() {
    return es.getall();
}
@GetMapping(value="/getbyage")
public List<Employee> getbyage(){
	return es.getbyage();
}
@GetMapping(value="/getmax")
public Employee getmax() {
	return es.getmax();
}
@GetMapping(value="/getsecmax")
public Employee getsecmax() {
	return es.getsecmax();
}
@GetMapping(value="/getname")
public List<String> getname() {
	return es.getname();
}
@GetMapping(value="/agename")
public String agename() {
	return es.agename();
}
@GetMapping(value="/age")
public List<Integer> age() {
	return es.age();
}
@GetMapping(value="/count")
public Set<Employee> count() {
	return es.count();
}
@GetMapping(value="/getallemp")
public List<Employee> getallemp(){
	return es.getallemp();
}
@GetMapping(value="/getage/{age}")
public List<Employee> getage(@PathVariable int age){
	return es.getage(age);
}
@GetMapping (value="/getallbyage/{x}")
public List<Employee> getallbyage(@PathVariable int x){
	return es.getallbyage(x);
}
@GetMapping(value="/getallsalary/{x}")
public List<Employee> getallsalary(@PathVariable int x){
	return es.getallsalary(x);
}
@GetMapping(value="/getexc/{g}")
public String getexc(@PathVariable int g) throws AgeException {
	return es.getexc(g); 
}
@GetMapping(value="/getname/{a}")
public List<Employee> getname(@PathVariable String a) throws AgeException{
	return es.getname(a);
}
@GetMapping(value="/getnamebyid/{a}")
public String getnamebyid(@PathVariable int a) throws NameException {
    return es.getnamebyid(a);
}
@GetMapping(value="/bad/{a}")
public String getbad(@PathVariable int a) throws Exception {
    return es.getbad(a);
}

}
