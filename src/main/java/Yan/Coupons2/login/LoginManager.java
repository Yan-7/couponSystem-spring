package Yan.Coupons2.login;


import Yan.Coupons2.services.AdminService;
import Yan.Coupons2.services.ClientService;
import Yan.Coupons2.services.CompanyService;
import Yan.Coupons2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;


@Service
public class LoginManager {

    @Autowired
    private AdminService adminService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CustomerService customerService;

    public ClientService login(String email, String password, ClientType clientType) {
        ClientService login;
        switch(clientType) {
            case Admin:
                login = getAdminService();
                if(login.login(email, password)) {
                    return login;
                }else {
                    return null;
                }
            case Company:
                login = getCompanyService();
                if(login.login(email, password)) {
                    return login;
                }else {
                    return null;
                }
            case Customer:
                login = getCustomerService();
                if(login.login(email, password)) {
                    return login;
                }else {
                    return null;
                }
            default:
                return null;
        }
    }
    public AdminService getAdminService() {
        return adminService;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public enum ClientType {

        Admin,
        Company,
        Customer
    }



}
