//package Yan.Coupons2;
//
//import Yan.Coupons2.EntityBeans.Category;
//import Yan.Coupons2.EntityBeans.Company;
//import Yan.Coupons2.EntityBeans.Coupon;
//import Yan.Coupons2.EntityBeans.Customer;
//import Yan.Coupons2.login.LoginManager;
//import Yan.Coupons2.services.AdminService;
//import Yan.Coupons2.services.CompanyService;
//import Yan.Coupons2.services.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class CustomerServiceTest implements CommandLineRunner {
//
////    @Autowired
//    private CustomerService customerService;
//
//    @Autowired
//    private AdminService adminService1;
//    @Autowired
//    private CompanyService companyService;
//    @Autowired
//    private LoginManager loginManager;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        List<Coupon> couponList1 = new ArrayList<>();
//        Company company1 = new Company(0, "company1", "@a", "1234", couponList1);
//        Company company2 = new Company(0, "Beta", "@b", "1234", couponList1);
//        Customer customer1 = new Customer(0, "firstname1", "lastname1", "@email", "1234", couponList1);
//        Customer customer2 = new Customer(0, "firstname2", "lastname2", "@email2", "1234", couponList1);
//        Coupon coupon1 = new Coupon(100, Category.Electricity, "TV", "vIDEO", LocalDate.of(2022, 10, 10), LocalDate.of(2024, 10, 10), 500, 100, "pic", null, company1);
//        Coupon coupon2 = new Coupon(101, Category.Food, "Hamburger", "meat product", LocalDate.of(2022, 10, 10), LocalDate.of(2024, 10, 10), 500, 200, "pic", null, company1);
//
//
//
//
//        customerService = (CustomerService) loginManager.login("@email","1234", LoginManager.ClientType.Customer);
//
//        customerService.purchaseCoupon(100);
//        customerService.purchaseCoupon(101);
//        System.out.println("getCustomerDetails:");
//        System.out.println(customerService.getCustomerDetails());
//        System.out.println("---------");
//
////        System.out.println("CustomerCouponsByCategory:");
////        System.out.println(customerService.getCustomerCouponsByCategory(Category.Electricity));
////        Caused by: java.util.ConcurrentModificationException: null
//
////        System.out.println("getCustomerCouponsByMaxPrice:");
////        System.out.println(customerService.getCustomerCouponsByMaxPrice(150));
//        //Caused by: java.util.ConcurrentModificationException: null
//
////        System.out.println("getCustomerDetails:");
////        System.out.println(customerService.getCustomerDetails());
//
//
//
//
//
//
//    }
//}
