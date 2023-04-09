package disburse;

import config.HouseDisburseConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HouseDisburseDetailApp
{

	public static void main(String[] args) {
		SpringApplication.run(HouseDisburseConfig.class, args);
		System.out.println("HELLO WORLD");
	}

}
