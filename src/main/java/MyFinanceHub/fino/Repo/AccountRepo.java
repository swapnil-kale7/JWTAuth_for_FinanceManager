package MyFinanceHub.fino.Repo;

import MyFinanceHub.fino.Entity.Account;
import MyFinanceHub.fino.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
    List<Account> findByUser(User user);
}
