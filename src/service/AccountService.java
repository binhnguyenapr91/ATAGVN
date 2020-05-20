package service;

import model.Account;

import java.util.List;

public interface AccountService {
    Account findByLoginName(String loginName);
    void addNewAccount(Account account);
    String getMaxAccountID();
    public List<Account> viewAllAccount();
    Account findById(String accountId);
    public boolean updateAccountById(Account account);
}
