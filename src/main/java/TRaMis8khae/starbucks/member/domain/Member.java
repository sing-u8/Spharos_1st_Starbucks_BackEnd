package TRaMis8khae.starbucks.member.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column(columnDefinition = "binary(16)")
    private UUID memberUuid;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String loginId;
    @Column(nullable = false, length = 255)
    private String password;
    @Column(nullable = false, length = 50)
    private Date birth;
    @Column(nullable = false, length = 50)
    private String phoneNumber;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 50)
    private String nickname;
    @Column(nullable = false, length = 100)
    private String address;
    @Column(nullable = false, length = 6)
    private String paymentPassword;
    private Boolean memberStatus;

    @Builder
    public Member(
            Long member_id,
            UUID member_uuid,
            String name,
            String login_id,
            String password,
            Date birth,
            String phone_number,
            String email,
            String nickname,
            String address,
            String payment_password,
            Boolean member_status
    ) {
        this.memberId = member_id;
        this.memberUuid = member_uuid;
        this.name = name;
        this.loginId = login_id;
        this.password = password;
        this.birth = birth;
        this.phoneNumber = phone_number;
        this.email = email;
        this.nickname = nickname;
        this.address = address;
        this.paymentPassword = payment_password;
        this.memberStatus = member_status;
    }

    public void hashPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //        List<GrantedAuthority> authorities = new ArrayList<>();
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

//    @Override
//    public boolean isEnable() {
//        return true;
//    }

}

