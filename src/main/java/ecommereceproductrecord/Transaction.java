package ecommereceproductrecord;

public class Transaction {
    String customerId;
    String transactionId;
    String gender;
    String age;
    String purchaseDate;
    String productCategory;
    String discountAvailed;
    String discountName;
    double discountAmount;
    double grossAmount;
    double netAmount;
    String purchaseMethod;
    String location;

    public Transaction(String customerId, String transactionId, String gender, String age, String purchaseDate, String productCategory, String discountAvailed, String discountName, double discountAmount, double grossAmount, double netAmount, String purchaseMethod, String location) {
        this.customerId = customerId;
        this.transactionId = transactionId;
        this.gender = gender;
        this.age = age;
        this.purchaseDate = purchaseDate;
        this.productCategory = productCategory;
        this.discountAvailed = discountAvailed;
        this.discountName = discountName;
        this.discountAmount = discountAmount;
        this.grossAmount = grossAmount;
        this.netAmount = netAmount;
        this.purchaseMethod = purchaseMethod;
        this.location = location;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getDiscountAvailed() {
        return discountAvailed;
    }

    public String getDiscountName() {
        return discountName;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getGrossAmount() {
        return grossAmount;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public String getPurchaseMethod() {
        return purchaseMethod;
    }

    public String getLocation() {
        return location;
    }

}
