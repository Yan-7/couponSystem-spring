package Yan.Coupons2.EntityBeans;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;


import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "coupons")
@Entity
public class Company {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(unique = true)
    private String name;

    //    @Column(unique = true)
    private String email;
    //    @Column(nullable = false)
    private String password;


    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)

    private List<Coupon> coupons;


    public void addCouponToCompany(Coupon coupon) {
        coupon.setCompany(this);
        this.coupons.add(coupon);
    }

    // TODO: 19/12/2022  does it works?
    public void deleteCouponsList() {
        coupons.clear();
    }

}



