package MyFinanceHub.fino.Service;

import MyFinanceHub.fino.Entity.Account;
import MyFinanceHub.fino.Entity.User;
import MyFinanceHub.fino.Repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepository;

    public Account createAccount(Account account)
    { return accountRepository.save(account);
    }

    public List<Account> getAccountsByUser(User user)
    { return accountRepository.findByUser(user);
    }
}
