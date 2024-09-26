package TRaMis8khae.starbucks.auth.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Terms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String termName;

    @Column(length = 500)
    private String termContent;

    @Builder
    public Terms(String termName, String termContent) {
        this.termName = termName;
        this.termContent = termContent;
    }

}