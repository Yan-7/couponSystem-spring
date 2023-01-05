package Yan.Coupons2.jobDaily;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CouponExpireDaily  {

    @Scheduled(timeUnit = TimeUnit.SECONDS,fixedRate = 3)  //every 3 seconds
    public void myRun() {
        System.out.println("starting to check expired coupons");

    }
}
