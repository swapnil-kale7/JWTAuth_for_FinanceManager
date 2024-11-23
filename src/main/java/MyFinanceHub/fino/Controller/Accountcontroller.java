package MyFinanceHub.fino.Controller;

import MyFinanceHub.fino.Entity.Account;
import MyFinanceHub.fino.Entity.User;
import MyFinanceHub.fino.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Accountcontroller {
    @Autowired
    private AccountService accountService;

    @PostMapping("/createAccount")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
};
    @GetMapping("/user/{userId}")
    public List<Account> getAccountsByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return accountService.getAccountsByUser(user); }
}
