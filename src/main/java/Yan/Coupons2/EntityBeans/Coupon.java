package Yan.Coupons2.EntityBeans;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(of = "id")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated (EnumType.ORDINAL)
    private Category category;
    private String title;
    private String description;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;
    private int amount;
    private double price;
    private String image;

    @ManyToMany(mappedBy = "coupons",cascade = CascadeType.DETACH)
    @ToString.Exclude
    private List<Customer> customers;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @ToString.Exclude
    private Company company;


}
