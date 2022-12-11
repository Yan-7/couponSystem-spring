package Yan.couponSystemspring.login;


import Yan.couponSystemspring.services.AdminService;
import Yan.couponSystemspring.services.ClientService;
import Yan.couponSystemspring.services.CompanyService;
import Yan.couponSystemspring.services.CustomerService;
import org.hibernate.query.criteria.JpaCriteriaUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//this is like the controller?
@Service
public class LoginManager {

    @Autowired
    private AdminService adminService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CustomerService customerService;

    public AdminService getAdminService() {
        return adminService;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public ClientService login(String email, String password, ClientType clientType) {
        ClientService clientServiceLogin;
        switch (clientType) {
            case Admin:
                clientServiceLogin = getAdminService();
                return clientServiceLogin;
        }
        return null;
    }


}
