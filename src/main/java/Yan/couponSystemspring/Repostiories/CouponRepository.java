package Yan.couponSystemspring.Repostiories;

import Yan.couponSystemspring.EntityBeans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon,Integer> {

    //those are custom queries
    // TODO: 11/12/2022 make sure al queris exsist in the repositories
    List<Coupon> findById (int CouponId);

    List<Coupon> findByCompanyId(int companyID);

    List<Coupon> findByExpirationDate(LocalDate expirationDate);
}
