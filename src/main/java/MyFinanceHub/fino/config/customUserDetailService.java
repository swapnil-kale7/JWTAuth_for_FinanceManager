package MyFinanceHub.fino.config;

import MyFinanceHub.fino.Entity.User;
import MyFinanceHub.fino.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class customUserDetailService  implements UserDetailsService {

    @Autowired
    UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User Userr = userRepo.findByUsername(username);

        if (Userr == null) {
            throw new UsernameNotFoundException("user " + username + " not found");
        }
        return new UserDetail(Userr);


    }
}
