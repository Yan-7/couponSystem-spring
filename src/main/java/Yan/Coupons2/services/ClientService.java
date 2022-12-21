package Yan.Coupons2.services;

import Yan.Coupons2.Repostiories.CompanyRepository;
import Yan.Coupons2.Repostiories.CouponRepository;
import Yan.Coupons2.Repostiories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;


public abstract class ClientService {

    @Autowired
    public CompanyRepository companyRepository;

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public CouponRepository couponRepository;

    public boolean login(String email, String password){
        return true;
    }
}
