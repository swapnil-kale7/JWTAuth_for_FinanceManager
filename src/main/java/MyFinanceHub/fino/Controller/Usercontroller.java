package MyFinanceHub.fino.Controller;

import MyFinanceHub.fino.Entity.User;
import MyFinanceHub.fino.Service.UserService;
import MyFinanceHub.fino.Utisl.JWTutil;
import MyFinanceHub.fino.config.UserDetail;
import MyFinanceHub.fino.config.customUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usercontroller {
    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    customUserDetailService userDetailService;

    @Autowired
    JWTutil jwTutil;

//    @PostMapping("/register")
//    public ResponseEntity<User> registerUser(@RequestBody User user) {
//        User registeredUser = userService.registerUser(user);
//        return ResponseEntity.ok(registeredUser); }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        System.out.println("In /register");
        return  userService.registerUser(user);
      }

//    @PostMapping("/register")
//    public String registerUser(@RequestBody User user) {
//        userService.registerUser(user);
//        return "saved";
//    }

//        @PostMapping("/login")
//    public User loginUser(@RequestBody User user) {
//        return userService.loginUser(user.getUsername()); }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        //below internally calls our custom userdetailImplement
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        UserDetails userDetail=userDetailService.loadUserByUsername(user.getUsername());
        String Jwt=jwTutil.generateToken(userDetail.getUsername());
        return Jwt; }
}
