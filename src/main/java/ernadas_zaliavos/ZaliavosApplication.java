package ernadas_zaliavos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"ernadas_zaliavos","saltiniai"})
public class ZaliavosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZaliavosApplication.class, args);
	}

}
