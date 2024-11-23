package MyFinanceHub.fino.config;

import MyFinanceHub.fino.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class UserDetail implements UserDetails {

    User userr;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_"+userr.getRole()));
    }

    public UserDetail(User userr) {
        this.userr = userr;
    }

    @Override
    public String getPassword() {
        return userr.getPassword();
    }

    @Override
    public String getUsername() {
        return userr.getUsername();
    }
}