package TRaMis8khae.starbucks.auth.entity;

import TRaMis8khae.starbucks.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@ToString
@NoArgsConstructor
public class AuthUserDetail implements UserDetails {

    private String memberUUID;
    private String password;
    private String loginId;

    public AuthUserDetail(Member member) {
        this.memberUUID = member.getMemberUUID();
        this.password = member.getPassword();
        this.loginId = member.getLoginId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.memberUUID;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
