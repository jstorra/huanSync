package com.u2team.huansync.ticketOffice.accounting.model.DAO;

public interface InterfaceAccountingDAO {
    void generateTotalSalesReport();
    void generateCategorySalesReport();
    void generateAvailabilityReport();
    void generateParticipantsReport();
}
