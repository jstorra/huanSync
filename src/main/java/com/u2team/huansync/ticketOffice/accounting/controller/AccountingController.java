package com.u2team.huansync.ticketOffice.accounting.controller;

import com.u2team.huansync.ticketOffice.accounting.model.InterfaceAccountingDAO;
import com.u2team.huansync.ticketOffice.accounting.model.classes.AccountingDAO;

public class AccountingController {

    private InterfaceAccountingDAO accountingDAO;

    public AccountingController() {
        this.accountingDAO = new AccountingDAO();
    }

    public void generateReports() {
        accountingDAO.generateTotalSalesReport();
        accountingDAO.generateCategorySalesReport();
        accountingDAO.generateAvailabilityReport();
        accountingDAO.generateParticipantsReport();
    }

}
