package Yan.Coupons2.Repostiories;

import Yan.Coupons2.EntityBeans.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

    //those are custom queries
    Optional<Company> findByEmailAndPassword(String email, String password);
    List<Company> findByEmail(String email);

    List<Company> findByName(String name);

}
