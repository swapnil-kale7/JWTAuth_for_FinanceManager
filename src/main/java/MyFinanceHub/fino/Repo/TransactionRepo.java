package MyFinanceHub.fino.Repo;


import MyFinanceHub.fino.Entity.Account;
import MyFinanceHub.fino.Entity.Transaction;
import MyFinanceHub.fino.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {


List<Transaction> findByAccount(Account account);
}
