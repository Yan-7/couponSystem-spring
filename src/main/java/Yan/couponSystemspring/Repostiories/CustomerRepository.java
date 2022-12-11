package Yan.couponSystemspring.Repostiories;

import Yan.couponSystemspring.EntityBeans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    //those are custom queries
    Optional<Customer> findByEmailAndPassword(String email,String password);

    List<Customer> findByEmail(String email);

    List<Customer> findByPassword(String password);

}
