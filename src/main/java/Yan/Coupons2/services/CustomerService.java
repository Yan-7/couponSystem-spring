package Yan.Coupons2.services;

import Yan.Coupons2.EntityBeans.Category;
import Yan.Coupons2.EntityBeans.Coupon;
import Yan.Coupons2.EntityBeans.Customer;
import Yan.Coupons2.Repostiories.CompanyRepository;
import Yan.Coupons2.Repostiories.CouponRepository;
import Yan.Coupons2.Repostiories.CustomerRepository;
import Yan.Coupons2.exceptions.CouponsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService extends ClientService {

    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    CustomerRepository customerRepository;
    private Customer customer;

    @Override
    public boolean login(String email, String password)  {
        Optional<Customer> customerOptional = customerRepository.findByEmailAndPassword(email, password);
        if (customerOptional.isPresent()) {
            customer = customerOptional.get();

            System.out.println( customer+ " is logged in the system    ------------------------------>");
            return true;
        }
        System.out.println("login failed, customer was not found");
        return false;
    }

    public void purchaseCoupon(int couponID) throws CouponsException {
        Optional<Coupon> optCoupon = this.couponRepository.findById(couponID);
        if (optCoupon.isPresent()) {
            Coupon coupon = optCoupon.get();
            if (coupon.getEndDate().isAfter(LocalDate.now())) {
                this.customer = this.customerRepository.save(customer);
                customer.addCouponToCustomer(coupon);
                coupon.setAmount(coupon.getAmount()-1);
                System.out.println("coupon purchased by customer");
            }
        } else throw new CouponsException("coupon was not sold to customer");
    }

    // TODO: 14/12/2022 need this this.customer?
    public List<Coupon> getCustomerCouponsByCategory(Category category) {
        List<Coupon> customerCoupons = customer.getCoupons();
        for (Coupon c : customerCoupons) {
            if (!c.getCategory().equals(category)) {
                customerCoupons.remove(c);
            }
        }
        return customerCoupons;
    }

    public List<Coupon> getCustomerCouponsByMaxPrice(double maxPrice) {
        List<Coupon> customerCoupons = this.customer.getCoupons();
        for (Coupon c : customerCoupons) {
            if (c.getPrice() > maxPrice) {
                customerCoupons.remove(c);
            }
        }
        return customerCoupons;
    }

    public Customer getCustomerDetails() {
        return this.customer;
    }


}
