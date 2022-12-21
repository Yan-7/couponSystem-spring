package Yan.Coupons2;

import Yan.Coupons2.EntityBeans.Category;
import Yan.Coupons2.EntityBeans.Company;
import Yan.Coupons2.EntityBeans.Coupon;
import Yan.Coupons2.EntityBeans.Customer;
import Yan.Coupons2.login.LoginManager;
import Yan.Coupons2.services.AdminService;
import Yan.Coupons2.services.CompanyService;
import Yan.Coupons2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerServiceTest implements CommandLineRunner {

//    @Autowired
    private CustomerService customerService;

    @Autowired
    private AdminService adminService1;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private LoginManager loginManager;

    @Override
    public void run(String... args) throws Exception {

        List<Coupon> couponList1 = new ArrayList<>();
        Company company1 = new Company(1, "Alpha", "@a", "1234", couponList1);
        Company company2 = new Company(2, "Beta", "@b", "1234", couponList1);
        Customer customer1 = new Customer(100, "one", "lastname", "@email", "1234", couponList1);
        Customer customer2 = new Customer(101, "two", "lastname2", "@email2", "1234", couponList1);
        Coupon coupon1 = new Coupon(100, Category.Electricity, "TV", "vIDEO", LocalDate.of(2022, 10, 10), LocalDate.of(2024, 10, 10), 500, 100, "pic", null, company1);
        Coupon coupon2 = new Coupon(101, Category.Electricity, "Radio", "Audio", LocalDate.of(2022, 10, 10), LocalDate.of(2024, 10, 10), 500, 200, "pic", null, company1);

        adminService1.addOneCustomer(customer1);

        // TODO: 21/12/2022  Cannot invoke "Yan.Coupons2.EntityBeans.Company.getId()" because "this.company" is null
//        companyService.addCoupon(coupon1);

        customerService = (CustomerService) loginManager.login("@email","1234", LoginManager.ClientType.Customer);

        // TODO: 21/12/2022 coupons are not added to the customer "coupons"
//        customerService.purchaseCoupon(100);
//        //coupons list is empty:
//        System.out.println(customer1.getCoupons());





    }
}
