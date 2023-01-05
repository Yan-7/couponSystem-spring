package Yan.Coupons2.EntityBeans;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity

@ToString(exclude = "coupons")


public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String LastName;
    @Column(unique = true)
    private String email;
    private String password;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.PERSIST})
    @JoinTable(
            name = "customer_vs_coupon",
            joinColumns = @JoinColumn(name="customer_id"),
            inverseJoinColumns = @JoinColumn(name="coupon_id")
    )

    //admin service test:
//    failed to lazily initialize a collection of role: Yan.Coupons2.EntityBeans.Customer.coupons: could not initialize proxy - no Session
    private List<Coupon> coupons;

    public void addCouponToCustomer(Coupon coupon) {
        if (this.coupons == null) {
            this.coupons = new ArrayList<>();
        }
        coupons.add(coupon);
//        System.out.println(coupons); //for testing only
    }
}
