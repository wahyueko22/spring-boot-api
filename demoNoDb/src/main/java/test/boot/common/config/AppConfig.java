package test.boot.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import test.boot.common.object.HelloWorld;

@Configuration
public class AppConfig {
	   @Bean 
	   public HelloWorld helloWorld(){
	      return new HelloWorld();
	   }
}
