package com.employee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value = "select * from employee", nativeQuery = true)
	public List<Employee> getallemp();

	@Query(value = "select * from employee where age>?", nativeQuery = true)
	public List<Employee> getage(int age);

	@Query(value = "select a from Employee a where a.age>=:x")
	public List<Employee> getallbyage(@Param("x") int a);

	@Query(value = "select a from Employee a where a.salary>=:x")
	public List<Employee> getallsalary(@Param("x") int a);

	@Query(value = "select * from employee where name like ?",nativeQuery = true)
	public List<Employee> getname(String name);
}
