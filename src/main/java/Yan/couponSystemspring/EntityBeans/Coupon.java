package Yan.couponSystemspring.EntityBeans;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component  // needed?
//@Table
@Entity //creates a table
@EqualsAndHashCode(of = "id")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int CompanyId;
    @Enumerated  //(EnumType.ORDINAL)
    private Category category;
    private String title;
    private String description;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;
    private int amount;
    private double price;
    private String image;  //photo

    //list of customers


}
