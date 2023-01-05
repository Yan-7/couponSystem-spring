package Yan.Coupons2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // for the thread, but make it every 24hrs
public class CouponSystemSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponSystemSpringApplication.class, args);



    }


}
