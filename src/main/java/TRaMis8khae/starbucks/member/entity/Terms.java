package TRaMis8khae.starbucks.member.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Terms { //네이밍

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String termName; // 길이 설정 필요

    @Column(length = 500)
    private String termContent;

    @Builder
    public Terms(String termName, String termContent) {
        this.termName = termName;
        this.termContent = termContent;
    }

}
