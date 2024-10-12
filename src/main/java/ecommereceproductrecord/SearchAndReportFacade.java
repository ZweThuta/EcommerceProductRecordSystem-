package ecommereceproductrecord;

import java.util.LinkedList;

public class SearchAndReportFacade {
    private LinkedList<Transaction> transactions;

    public SearchAndReportFacade(LinkedList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void searchByCustomerId() {
        new SearchRecordByCustomerId(transactions).search();
    }

    public void searchByProductCategory() {
        new SearchRecordByProductCategory(transactions).search();
    }

    public void reportSortedByNetAmount() {
        new SortProductCategoryByNetAmount(transactions).report();
    }

    public void listProductsByCategory() {
        new ListProductByCategory(transactions).report();
    }

    public void countProductsByLocation() {
        new ProductByEachLocation(transactions).report();
    }

    public void productCountByEachUser() {
        new TotalProductCountByEachUser(transactions).report();
    }

    public void productWithDiscountAvailable() {
        new ProductWithDiscount(transactions).report();
    }


}
