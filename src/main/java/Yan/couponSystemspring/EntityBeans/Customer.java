package Yan.couponSystemspring.EntityBeans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id" )
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //key strategy
    private int id;

    private String firstName;
    private String LastName;
    private String email;
    private String password;

    private ArrayList<Coupon> coupons;



}
