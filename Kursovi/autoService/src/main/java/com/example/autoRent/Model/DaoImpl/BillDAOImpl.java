package com.example.autoRent.Model.DaoImpl;

import com.example.autoRent.Model.DAO.BillDAO;
import com.example.autoRent.Model.DataBaseConnectionPool.ConnectionPool;
import com.example.autoRent.Model.Entity.Bill;
import com.example.autoRent.Model.Entity.Car;
import com.example.autoRent.Model.Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDAOImpl implements BillDAO {
    private String CREATE_BILL = "INSERT INTO `autorent`.`bills` (`iduser`, `idcar`, `frontPassport`, `backPassport`, `driver`, `rentTime`, `cost`) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private String CHANGE_BILL_PAYMENT_STATUS = "UPDATE `autorent`.`bills` SET paymentStatus=TRUE where idbill=?;";
    private String ALL_USER_BILLS = "SELECT * FROM autorent.bills where iduser=?;";
    private String ALL_BILLS_WITH_STATUS_IN_RENT = "SELECT * FROM autorent.bills where paymentStatus = true and rentStatus IS NULL";
    private String EDIT_BILL_STATUS = "UPDATE autorent.bills SET rentStatus = ? where idbill=?;";
    private String EDIT_BILL_RETURN_STATUS = "UPDATE autorent.bills SET returnStatus = ? where idbill=?;";

    @Override
    public List<Bill> allBillsWithStatusInRent() {
        List<Bill> billsList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ALL_BILLS_WITH_STATUS_IN_RENT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idbill = resultSet.getInt("idbill");
                int iduser = resultSet.getInt("iduser");
                int idcar = resultSet.getInt("idcar");
                String frontPassport = resultSet.getString("frontPassport");
                String backPassport = resultSet.getString("backPassport");
                boolean driver = resultSet.getBoolean("driver");
                int rentTime = resultSet.getInt("rentTime");
                double cost = resultSet.getDouble("cost");
                boolean paymentStatus = resultSet.getBoolean("paymentStatus");
                String rentStatus = resultSet.getString("rentStatus");
                String returnStatus = resultSet.getString("returnStatus");
                Bill bill = new Bill(idbill, iduser, idcar, frontPassport, backPassport, driver, rentTime, cost, paymentStatus, rentStatus, returnStatus);
                billsList.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billsList;
    }

    @Override
    public boolean editBillStatus(int idBill, String status) {
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EDIT_BILL_STATUS)) {
            preparedStatement.setInt(2, idBill);
            preparedStatement.setString(1, status);
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editReturnStatus(int idBill, String status) {
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EDIT_BILL_RETURN_STATUS)) {
            preparedStatement.setInt(2, idBill);
            preparedStatement.setString(1, status);
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Bill> allUserBills(User user) {
        List<Bill> billsList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ALL_USER_BILLS)) {
            preparedStatement.setInt(1, user.getIduser());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idbill = resultSet.getInt("idbill");
                int iduser = resultSet.getInt("iduser");
                int idcar = resultSet.getInt("idcar");
                String frontPassport = resultSet.getString("frontPassport");
                String backPassport = resultSet.getString("backPassport");
                boolean driver = resultSet.getBoolean("driver");
                int rentTime = resultSet.getInt("rentTime");
                double cost = resultSet.getDouble("cost");
                boolean paymentStatus = resultSet.getBoolean("paymentStatus");
                String rentStatus = resultSet.getString("rentStatus");
                String returnStatus = resultSet.getString("returnStatus");
                Bill bill = new Bill(idbill, iduser, idcar, frontPassport, backPassport, driver, rentTime, cost, paymentStatus, rentStatus, returnStatus);
                billsList.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billsList;
    }

    @Override
    public boolean createBill(Bill bill) {
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_BILL)) {
            preparedStatement.setInt(1, bill.getIduser());
            preparedStatement.setInt(2, bill.getIdcar());
            preparedStatement.setString(3, bill.getFrontPassport());
            preparedStatement.setString(4, bill.getBackPassport());
            preparedStatement.setBoolean(5, bill.isDriver());
            preparedStatement.setInt(6, bill.getRentTime());
            preparedStatement.setDouble(7, bill.getCost());
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean changeBillPaymentStatus(int idbill) {
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_BILL_PAYMENT_STATUS)) {
            preparedStatement.setInt(1, idbill);
            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
