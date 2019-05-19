package test.boot.common.service;

import java.util.List;

import test.boot.common.object.*;

public interface EmployeeService {
	public List<Employee> findAllEmployee();
	public Employee findEmployeeById(int id);
	public void saveEmployee(Employee emp);
}
