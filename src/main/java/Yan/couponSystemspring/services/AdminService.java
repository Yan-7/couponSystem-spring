package Yan.couponSystemspring.services;

import Yan.couponSystemspring.EntityBeans.Company;
import Yan.couponSystemspring.Repostiories.CompanyRepository;
import Yan.couponSystemspring.Repostiories.CouponRepository;
import Yan.couponSystemspring.Repostiories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AdminService extends ClientService{

    private final static String email = "admin@admin.com";
    private final static String password = "admin";

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CouponRepository couponRepository;

    @Override
    public boolean login(String email, String password) throws SQLException, InterruptedException {
        if (email == "admin@admin.com" && password == "admin") {
            return true;
        }
        System.out.println("cannot login, password or email incorrect");
        return false;
    }

    public void addCompany(Company company) throws SQLException,InterruptedException {
        String email = company.getEmail();
        String password = company.getPassword();
        if (companyRepository.findCompanyWithEmail(company.getEmail()).isEmpty()) {
            companyRepository.save(company);
            System.out.println("company added to database");
        } else {
            System.out.println("cannot add this company, it's already exist in the system");
        }
    }



}
