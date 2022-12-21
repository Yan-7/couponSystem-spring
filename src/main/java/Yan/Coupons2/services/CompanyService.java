package Yan.Coupons2.services;

import Yan.Coupons2.EntityBeans.Category;
import Yan.Coupons2.EntityBeans.Company;
import Yan.Coupons2.EntityBeans.Coupon;
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
public class CompanyService extends ClientService {

    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    CustomerRepository customerRepository;

    private Company company;

    @Override
    public boolean login(String email, String password) {
        Optional<Company> opt = companyRepository.findByEmailAndPassword(email, password);
        System.out.println("company details:");
        if (opt.isPresent()) {
            this.company = opt.get();

            System.out.println("logged as company: " + company);

            return true;
        } else {
            System.out.println("login failed");
        }
        return false;
    }

    public void addCoupon(Coupon coupon) {
        if(couponRepository.findByDescriptionAndCompany_Id(coupon.getDescription(), this.company.getId()).isEmpty()){
            company = this.companyRepository.findById(company.getId()).orElseThrow();
            if(coupon.getStartDate().isBefore(coupon.getEndDate()) && coupon.getEndDate().isAfter(LocalDate.now())) {
                company.addCouponToCompany(coupon);
                companyRepository.save(company);
                System.out.println("Coupon " + coupon.getId()+ " added");
            }else {
                System.out.println("addCoupon failed - can't add coupon with these dates");
            }
        }else {
            System.out.println("addCoupon failed - coupon is already in the company DB");
        }
    }

    public void updateCoupon(Coupon coupon) throws CouponsException {
        if (!couponRepository.findByIdAndCompany_id(coupon.getId(), company.getId()).isEmpty()) {
            couponRepository.save(coupon);
            System.out.println("coupon "+ coupon.getId() + " updated");
        } else {
            throw new CouponsException("coupon was not found, cannot update");
        }
    }

    public void deleteCoupon(int couponID) throws CouponsException {
        if (couponRepository.existsById(couponID)) {
            couponRepository.deleteById(couponID);
            System.out.println("coupon " + couponID+ " deleted");
        } else {
            throw new CouponsException("coupon was not found, cannot delete");
        }
    }

    public List<Coupon> getCompanyCoupons() {
        List<Coupon> companyCoupons = company.getCoupons();
        for (Coupon c:companyCoupons) {
            System.out.println(c);
        }
        System.out.println("---------");
        return companyCoupons;
    }

    public List<Coupon> getCompanyCouponsByCategory(Category category) {
        List<Coupon> allCompanyCoupons = company.getCoupons();
        for (Coupon c : allCompanyCoupons) {
            if (c.getCategory() != category) {
                allCompanyCoupons.remove(c);
            }
            //company coupons that only belong to the category:\
        }
        System.out.println("--------");
        return allCompanyCoupons;
    }

    public List<Coupon> getCompanyCouponsByMaxPrice(int maxPrice) {
        List<Coupon> companyCoupons = company.getCoupons();
        for (Coupon c : companyCoupons) {
            if (c.getPrice() > maxPrice) {
                companyCoupons.remove(c);
            }
        }
        System.out.println("coupons by price:");
        return companyCoupons;
    }

    // TODO: 14/12/2022 good?
    public String getCompanyDetails() {
        System.out.println("company details:");
        return company.toString();

    }


}
