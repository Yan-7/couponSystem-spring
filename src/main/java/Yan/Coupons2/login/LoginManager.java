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
        ClientService clientService;
        switch (clientType) {
            case Admin:
                clientService = getAdminService();
                if (clientService.login(email, password)) { //this part makes the "login" in the service true/false
                    return clientService;
                } else {
                    System.out.println("could not connect as admin");
                    return null;
                }
            case Company:
                clientService = getCompanyService();
                if (clientService.login(email, password)) {
                    return clientService;
                } else {
                    System.out.println("could not connect as company");
                    return null;
                }
            case Customer:
                clientService = getCustomerService();
                if (clientService.login(email, password)) {
                    return clientService;
                } else {
                    System.out.println("could not connect as customer");
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
