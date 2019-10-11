package lab.nice.quartz;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuartzApp  {

    public static void main(String[] args) {
        final SpringApplication application = new SpringApplication(QuartzApp.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
