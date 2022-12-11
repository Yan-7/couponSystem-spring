package Yan.couponSystemspring.services;

import Yan.couponSystemspring.Repostiories.CompanyRepository;
import Yan.couponSystemspring.Repostiories.CouponRepository;
import Yan.couponSystemspring.Repostiories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;


public abstract class ClientService {

    @Autowired
    public CompanyRepository companyRepository;

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public CouponRepository couponRepository;

    public boolean login(String email, String password) throws SQLException,InterruptedException {
        return true;
    }
}
