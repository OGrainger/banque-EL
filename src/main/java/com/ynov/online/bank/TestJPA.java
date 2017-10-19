package com.ynov.online.bank;


import com.ynov.online.bank.controller.ClientCtrl;
import com.ynov.online.bank.model.Account;
import com.ynov.online.bank.model.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestJPA {

    private static Logger logger = LogManager.getLogger(TestJPA.class);

    public static void main(String[] args) {

        try {
            /*
            Client client = new Client();
            client.setLogin("dummy");
            client.setPassword("pass");
            client.setFirstName("fn");
            client.setLastName("ln");

            List<Account> accounts = new ArrayList<>();
            Account a = new Account();
            a.setDescription("dummy account a");
            a.setMoney(42);
            a.setClient(client);
            accounts.add(a);

            Account b = new Account();
            b.setMoney(10);
            b.setDescription("dummy account b");
            b.setClient(client);

            Transaction transaction = new Transaction();
            transaction.setDescription("transaction test");
            transaction.setCreditorAccount(a);
            transaction.setDebtorAccount(b);
            transaction.setAmount(10);

            List<Transaction> transactions = new ArrayList<>();
            transactions.add(transaction);
            b.setDebtorTransactions(transactions);
            accounts.add(b);
            client.setAccounts(accounts);*/

            ClientCtrl clientCtrl = new ClientCtrl();
            Client result = clientCtrl.getWithId(138);
            logger.info("GET CLIENT : " + result.getLogin());
            for (Account account : result.getAccounts()) {
                logger.info("GET ACCOUNT : " + account.getIban());
            }

        } catch (Exception e) {
            logger.throwing(e);
        }
    }
}
