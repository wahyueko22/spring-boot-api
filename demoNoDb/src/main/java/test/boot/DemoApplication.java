package test.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import test.boot.common.controller.StringController;
import test.boot.common.object.HalloOne;

@SpringBootApplication(scanBasePackages={"test.boot"})
public class DemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	@Value("${prop.env.data}")
	private String envData;
	
	public String getEnvData() {
		return envData;
	}

	public void setEnvData(String envData) {
		this.envData = envData;
	}

	public static void main(String[] args) {
		logger.info("okeeeeeee");
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.warn("This is a warn message");
		logger.error("This is an error message");
		SpringApplication.run(DemoApplication.class, args);
		DemoApplication dmoApp = new DemoApplication();
		System.out.println("envku =" + dmoApp.getEnvData());
	}
	
	@Bean
	HalloOne halloOne(){
		return new HalloOne();
	}

}

