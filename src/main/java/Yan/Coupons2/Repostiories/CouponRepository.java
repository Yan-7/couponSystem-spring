package Yan.Coupons2.Repostiories;

import Yan.Coupons2.EntityBeans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon,Integer> {

    List<Coupon> findByDescriptionAndCompany_Id(String description, int companyId);

    List<Coupon> findByIdAndCompany_id(int id, int id2);

    List<Coupon> findByCompany_id(int id);

    List<Coupon> findByCustomers_id(int id);

    //program crashes because of this list
//    List<Coupon> findByExpirationAfter(Date date);



}
