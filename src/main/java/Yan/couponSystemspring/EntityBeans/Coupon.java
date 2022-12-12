package Yan.couponSystemspring.EntityBeans;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

//@Table
@Entity //creates a table
@EqualsAndHashCode(of = "id")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated  //(EnumType.ORDINAL)
    private Category category;
    private String title;
    private String description;
    @Column(nullable = false)
    private LocalDate startDate;
    @Column(nullable = false)
    private LocalDate endDate;
    private int amount;
    private double price;
    private String image;  //photo

    //list of customers


}
