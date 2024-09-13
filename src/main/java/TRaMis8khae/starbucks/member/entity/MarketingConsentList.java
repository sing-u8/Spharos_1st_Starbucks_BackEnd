package TRaMis8khae.starbucks.member.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class MarketingConsentList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean EmailConsentChecked;

    private Boolean SMSConsentChecked;

    @ManyToOne
    private Marketing marketing;

    @ManyToOne
    private Member member;

    @Builder
    public MarketingConsentList(Boolean emailConsentChecked, Boolean smsConsentChecked, Marketing marketing, Member member) {
        this.EmailConsentChecked = emailConsentChecked;
        this.SMSConsentChecked = smsConsentChecked;
        this.marketing = marketing;
        this.member = member;
    }

}