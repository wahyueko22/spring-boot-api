package test.boot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import test.boot.common.service.EmployeeService;
import test.boot.common.service.UserService;

import test.boot.common.object.*;

import test.boot.common.advice.BusinessException;
import test.boot.common.advice.TestException;
import test.boot.common.object.HalloOne;
import test.boot.common.object.HelloWorld;

@RestController
@RequestMapping("/api")
public class HelloWorldController {
	@Autowired
	UserService userService;  //Service which will do all data retrieval/manipulation work
	@Autowired
	EmployeeService employeeService;
	@Autowired
	private HelloWorld hallo;
	@Autowired
	private HalloOne hlOne;
	@RequestMapping(value = "/getHello/", method = RequestMethod.GET)
   public String sayHello() throws Exception  {
		hallo.setMessage("coba");
		hallo.getMessage();
		hlOne.getHelloOne();
		if (true){
			throw new TestException("test exception");
		}
      return "Hello Spring Boot!!";
   }
	
	@RequestMapping(value = "/getHello1/", method = RequestMethod.GET)
	   public String sayHello1() throws TestException,Exception  {
			hallo.setMessage("coba");
			hallo.getMessage();
			hlOne.getHelloOne();
			if (true){
				throw new Exception("Exception");
			}
	      return "Hello Spring Boot1!!";
	   }
	
	@RequestMapping(value = "/getHello2/", method = RequestMethod.GET)
	   public String sayHello2() throws BusinessException,Exception  {
			hallo.setMessage("coba");
			hallo.getMessage();
			hlOne.getHelloOne();
			Integer.parseInt("aaa");
			if (true){
				throw new BusinessException("AUTHERR_0000|BusinessException");
			}
	      return "Hello Spring Boot1!!";
	   }
	
	
	  @RequestMapping(value = "/employee/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<Employee>> listAllEmployee() {
	        List<Employee> empList = employeeService.findAllEmployee();
	        return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	    }
	  
	  
	    @RequestMapping(value = "/getEmployeeById/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Employee> getEmployeeById(@RequestParam Map<String, String> reqParams) {
	    	String strId = reqParams.get("idEmployee");
	    	int id = Integer.valueOf(strId);
	        Employee emp = employeeService.findEmployeeById(id);
	        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	    }
	    
	    @RequestMapping(value = "/getEmployeeByIdServlet/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Employee> getEmployeeByIdServlet(HttpServletRequest servletRequest) {
	    	String strId = servletRequest.getParameter("idEmployee");
	    	int id = Integer.valueOf(strId);
	        Employee emp = employeeService.findEmployeeById(id);
	        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	    }
	    
	    
	    @RequestMapping(value = "/createEmployee/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Void> createEmployee(@RequestBody Employee emp, UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Employee " + emp.getName());
	 
	   
	        employeeService.saveEmployee(emp);
	 
	        HttpHeaders headers = new HttpHeaders();
	        Map<String,String> paramMap = new HashMap<String,String>();
	        paramMap.put("idEmployee", "1");
	        headers.setLocation(ucBuilder.path("/getEmployeeById/").buildAndExpand(paramMap).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
}