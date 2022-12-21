//package Yan.Coupons2;
//
//import Yan.Coupons2.EntityBeans.Category;
//import Yan.Coupons2.EntityBeans.Company;
//import Yan.Coupons2.EntityBeans.Coupon;
//import Yan.Coupons2.EntityBeans.Customer;
//import Yan.Coupons2.login.LoginManager;
//import Yan.Coupons2.services.AdminService;
//import Yan.Coupons2.services.CompanyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class AdminTest implements CommandLineRunner {
//
//    private AdminService testAdminService;
//    private CompanyService companyService;
//
//    @Autowired
//    private LoginManager loginManagerTest;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        List<Coupon> couponList1 = new ArrayList<>();
//        Company company1 = new Company(1, "Alpha", "@a", "1234", couponList1);
//        Company company2 = new Company(2, "Beta", "@b", "1234", couponList1);
//        Customer customer1 = new Customer(13, "one", "lastname", "@email", "1234", couponList1);
//        Customer customer2 = new Customer(12, "two", "lastname2", "@email2", "1234", couponList1);
//        Coupon coupon1 = new Coupon(100, Category.Electricity, "TV", "vIDEO", LocalDate.of(2022, 10, 10), LocalDate.of(2024, 10, 10), 500, 99, "pic", null, company1);
//
//        testAdminService = (AdminService) loginManagerTest.login("admin@admin.com", "admin", LoginManager.ClientType.Admin);
//
//
//        testAdminService.addCompany(company1);
//        testAdminService.addCompany(company2);
//        testAdminService.updateCompany(company1);
//        testAdminService.getAllCompanies();
//        System.out.println("------------");
//        testAdminService.getOneCompany(2);
//        testAdminService.deleteCompany(1);
//
//        testAdminService.addOneCustomer(customer1);
//        testAdminService.addOneCustomer(customer2);
//        testAdminService.updateCustomer(customer1);
//        System.out.println(testAdminService.getAllCustomers());
//        System.out.println(testAdminService.getOneCustomer(customer1.getId()));
//          testAdminService.deleteCustomer(customer1.getId());
//    }
//}