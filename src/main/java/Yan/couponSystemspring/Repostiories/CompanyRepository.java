package Yan.couponSystemspring.Repostiories;

import Yan.couponSystemspring.EntityBeans.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

    //those are custom queries
    Optional<Company> loginWithEmailPassword(String email,String password);

    List<Company> findCompanyWithEmail(String email);

    List<Company> findCompanyWithName(String name);

}
