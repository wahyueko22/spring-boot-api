package test.boot.common.service;

import java.util.ArrayList;
import java.util.List;

import test.boot.common.object.*;

import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	private static List<Employee> lsEmp;
	static{
		lsEmp = new ArrayList<Employee>();
		lsEmp.add(new Employee("adi","jakarta",16));
		lsEmp.add(new Employee("adi2","jakarta",16));
		lsEmp.add(new Employee("adi3","jakarta",16));
		lsEmp.add(new Employee("adi4","jakarta",16));
		lsEmp.add(new Employee("adi","jakarta",16));
	}

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return lsEmp;
	}

	@Override
	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		return lsEmp.get(id);
	}

	@Override
	public void saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		lsEmp.add(emp);
	}

}
