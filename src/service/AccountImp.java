package service;

import model.Account;
import model.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountImp implements AccountService {
    public static final String FIND_ACCOUNT_BY_LOGIN_NAME = "select * from atagvn.account where LoginName=?;";
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
}
