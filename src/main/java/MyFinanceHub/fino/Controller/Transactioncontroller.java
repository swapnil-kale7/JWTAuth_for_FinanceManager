package MyFinanceHub.fino.Controller;

import MyFinanceHub.fino.Entity.Account;
import MyFinanceHub.fino.Entity.Transaction;
import MyFinanceHub.fino.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Transactioncontroller {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/createTransaction")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @GetMapping("/account/{accountId}")
    public List<Transaction> getTransactionsByAccount(@PathVariable Long accountId) {
        Account account = new Account(); account.setId(accountId);
        return transactionService.getTransactionsByAccount(account); }
}
