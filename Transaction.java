import java.time.LocalDate;

public class Transaction {
    Object vehicle;
    String transactionType;
    User user;
    LocalDate dateOfTransaction;
    String paymentType;
    Integer amountPaid;
    Admin issuedBy;

    public Transaction(Object vehicle, String transactionType, User user, LocalDate dateOfTransaction,
            String paymentType, Integer amountPaid, Admin issuedBy) {
        this.vehicle = vehicle;
        this.transactionType = transactionType;
        this.user = user;
        this.dateOfTransaction = dateOfTransaction;
        this.paymentType = paymentType;
        this.amountPaid = amountPaid;
        this.issuedBy = issuedBy;
    }
 
    
}
