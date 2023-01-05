package Yan.Coupons2;

import Yan.Coupons2.EntityBeans.Category;
import Yan.Coupons2.EntityBeans.Company;
import Yan.Coupons2.EntityBeans.Coupon;
import Yan.Coupons2.EntityBeans.Customer;
import Yan.Coupons2.login.LoginManager;
import Yan.Coupons2.services.AdminService;
import Yan.Coupons2.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Component
public class CompanyServiceTest implements CommandLineRunner {

    @Autowired
    private LoginManager loginManagerTest;
    @Autowired
    private AdminService testAdminService;

    @Autowired
    private CompanyService companyService;


    @Override
    public void run(String... args) throws Exception {

        List<Coupon> couponList1 = new ArrayList<>();
        Company company1 = new Company(0, "company1", "@a", "1234", couponList1);
        Company company2 = new Company(0, "Beta", "@b", "1234", couponList1);
        Customer customer1 = new Customer(0, "firstname1", "lastname1", "@email", "1234", couponList1);
        Customer customer2 = new Customer(0, "firstname2", "lastname2", "@email2", "1234", couponList1);
        Coupon coupon1 = new Coupon(0, Category.Electricity, "TV", "vIDEO", LocalDate.of(2022, 10, 10), LocalDate.of(2024, 10, 10), 500, 100, "pic", null, company1);
        Coupon coupon2 = new Coupon(0, Category.Food, "Hamburger", "meat product", LocalDate.of(2022, 10, 10), LocalDate.of(2024, 10, 10), 500, 200, "pic", null, company1);//

        testAdminService.addCompany(company1);


        CompanyService companyServiceTEST = (CompanyService) loginManagerTest.login("@a", "1234", LoginManager.ClientType.Company);
        System.out.println("----------");

        companyServiceTEST.addCoupon(coupon1);
//        companyServiceTEST.addCoupon(coupon2);
//
//        System.out.println("updateCoupon:");
//        companyServiceTEST.updateCoupon(coupon2);
////        companyServiceTEST.deleteCoupon(1);
//
//        System.out.println("getCompanyCoupons:");
//        companyServiceTEST.getCompanyCoupons();
//
//        System.out.println("getCompanyCouponsByCategory:");
//        System.out.println(companyServiceTEST.getCompanyCouponsByCategory(Category.Electricity));
//
//        System.out.println("getCompanyCouponsByMaxPrice:");
//        System.out.println(companyServiceTEST.getCompanyCouponsByMaxPrice(150));
//
//
//        System.out.println("getCompanyDetails:");
//        System.out.println(companyServiceTEST.getCompanyDetails());
////        failed to lazily initialize a collection of role: Yan.Coupons2.EntityBeans.Company.coupons: could not initialize proxy - no Session


    }
}
