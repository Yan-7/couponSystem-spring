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
    //problematic - perhaps cancel

//    @GeneratedValue(strategy = GenerationType.IDENTITY) - creating auto keys is not good
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

    private List<Coupon> coupons;

    public void addCouponToCustomer(Coupon coupon) {
        if (this.coupons == null) {
            this.coupons = new ArrayList<>();
        }
        coupons.add(coupon);

    }
}
