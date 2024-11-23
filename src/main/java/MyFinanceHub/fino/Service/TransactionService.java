package MyFinanceHub.fino.Service;

import MyFinanceHub.fino.Entity.Account;
import MyFinanceHub.fino.Entity.Transaction;
import MyFinanceHub.fino.Entity.User;
import MyFinanceHub.fino.Repo.AccountRepo;
import MyFinanceHub.fino.Repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired private TransactionRepo transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByAccount(Account account) {
        return transactionRepository.findByAccount(account); }

}
