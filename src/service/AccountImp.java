package service;

import model.Account;
import model.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountImp implements AccountService {
    public static final String FIND_ACCOUNT_BY_LOGIN_NAME = "select * from atagvn.account where LoginName=?;";
    public static final String FIND_MAX_ACCOUNT_ID = "select * from atagvn.account where AccountID like 'CT%' order by AccountID desc limit 1;";
    public static final String ADD_NEW_ACCOUNT = "insert into atagvn.account values (?,?,?,?,?,?,?,?,?)";

    @Override
    public Account findByLoginName(String loginName) {
        Connection connection = DBConnect.getConnection();
        Account account = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ACCOUNT_BY_LOGIN_NAME);
            preparedStatement.setString(1,loginName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String accountId = resultSet.getString("AccountID");
                String accountName = resultSet.getString("AccountName");
                String password = resultSet.getString("Password");
                String accountAccess = resultSet.getString("AccountAccess");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                boolean gender = Boolean.parseBoolean(resultSet.getString("gender"));
                boolean status = Boolean.parseBoolean(resultSet.getString("status"));

                account = new Account(accountId,accountName,loginName,accountAccess,password,address,phoneNumber,gender,status);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return account;
    }

    @Override
    public void addNewAccount(Account account) {
        Connection connection = DBConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_ACCOUNT);
            preparedStatement.setString(1,account.getAccountId());
            preparedStatement.setString(2,account.getAccountName());
            preparedStatement.setString(3,account.getLoginName());
            preparedStatement.setString(4,account.getPassword());
            preparedStatement.setString(5,account.getAccountAccess());
            preparedStatement.setString(6,account.getAddress());
            preparedStatement.setString(7,account.getPhoneNumber());
            preparedStatement.setBoolean(8,account.isGender());
            preparedStatement.setBoolean(9,account.isStatus());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String getMaxAccountID() {
        Connection connection = DBConnect.getConnection();
        String maxId = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_MAX_ACCOUNT_ID);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                maxId = resultSet.getString("AccountID");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return maxId;
    }
}
