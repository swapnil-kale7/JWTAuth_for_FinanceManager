package MyFinanceHub.fino.Service;

import MyFinanceHub.fino.Entity.User;
import MyFinanceHub.fino.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepository;


    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }  ;

//    @Transactional
//    public String registerUser(User user)
//    {
//        System.out.println("In /register service");
//        user.setPassword(passwordEncoder().encode(user.getPassword()));
//        userRepository.save(user);
//        return "User:"+user; }

    @Transactional
    public User registerUser(User user) {
        System.out.println("In /register service");
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user); // You can try userRepository.merge(user); if you are dealing with detached entities
     }


    @Transactional
    public User loginUser(String username )
    {
         return userRepository.findByUsername(username); }
}
