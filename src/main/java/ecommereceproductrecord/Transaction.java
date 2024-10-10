package ecommereceproductrecord;

public class Transaction {
    String  customerId;
    String  transactionId;
    String gender;
    String age;
    String  purchaseDate;
    String productCategory;
    String  discountAvailed;
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

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setDiscountAvailed(String discountAvailed) {
        this.discountAvailed = discountAvailed;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setGrossAmount(double grossAmount) {
        this.grossAmount = grossAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    public void setPurchaseMethod(String purchaseMethod) {
        this.purchaseMethod = purchaseMethod;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
