package com.example.autoRent.Model.DAO;

import com.example.autoRent.Model.Entity.Bill;
import com.example.autoRent.Model.Entity.User;

import java.util.List;

public interface BillDAO {
    List<Bill> allBillsWithStatusInRent();
    boolean editBillStatus(int idBill, String status);
    boolean editReturnStatus(int idBill, String status);
    List<Bill> allUserBills(User user);
    boolean createBill(Bill bill);
    boolean changeBillPaymentStatus(int idbill);
}
