package TRaMis8khae.starbucks.admin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

//    private String description;

    private Integer sequence;

    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    private MainCategory mainCategory;

}