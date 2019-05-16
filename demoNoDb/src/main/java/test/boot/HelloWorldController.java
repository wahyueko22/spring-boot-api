package test.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.boot.common.advice.BusinessException;
import test.boot.common.advice.TestException;
import test.boot.common.object.HalloOne;
import test.boot.common.object.HelloWorld;

@RestController
@RequestMapping("/api")
public class HelloWorldController {
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
	
}