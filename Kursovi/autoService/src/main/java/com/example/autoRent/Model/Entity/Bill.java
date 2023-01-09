package com.example.autoRent.Model.Entity;

public class Bill {
    int idbill;
    int iduser;
    int idcar;
    String frontPassport;
    String backPassport;
    boolean driver;
    int rentTime;
    double cost;
    boolean paymentStatus;
    String rentStatus;
    String returnStatus;

    public Bill() {
    }

    public Bill(int idbill, int iduser, int idcar, String frontPassport, String backPassport, boolean driver, int rentTime, double cost, boolean paymentStatus, String rentStatus, String returnStatus) {
        this.idbill = idbill;
        this.iduser = iduser;
        this.idcar = idcar;
        this.frontPassport = frontPassport;
        this.backPassport = backPassport;
        this.driver = driver;
        this.rentTime = rentTime;
        this.cost = cost;
        this.paymentStatus = paymentStatus;
        this.rentStatus = rentStatus;
        this.returnStatus = returnStatus;
    }

    public Bill(int iduser, int idcar, String frontPassport, String backPassport, boolean driver, int rentTime, double cost) {
        this.iduser = iduser;
        this.idcar = idcar;
        this.frontPassport = frontPassport;
        this.backPassport = backPassport;
        this.driver = driver;
        this.rentTime = rentTime;
        this.cost = cost;
    }

    public int getIdbill() {
        return idbill;
    }

    public void setIdbill(int idbill) {
        this.idbill = idbill;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdcar() {
        return idcar;
    }

    public void setIdcar(int idcar) {
        this.idcar = idcar;
    }

    public String getFrontPassport() {
        return frontPassport;
    }

    public void setFrontPassport(String frontPassport) {
        this.frontPassport = frontPassport;
    }

    public String getBackPassport() {
        return backPassport;
    }

    public void setBackPassport(String backPassport) {
        this.backPassport = backPassport;
    }

    public boolean isDriver() {
        return driver;
    }

    public void setDriver(boolean driver) {
        this.driver = driver;
    }

    public int getRentTime() {
        return rentTime;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(String rentStatus) {
        this.rentStatus = rentStatus;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }
}
