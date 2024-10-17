package ecommereceproductrecord;

import java.util.LinkedList;

public class SearchAndReportFacade {
    private LinkedList<Transaction> transactions;
    private SearchAndReport searchCID;
    private SearchAndReport searchCategory;
    private SearchAndReport sortByNetAmount;
    private SearchAndReport sortByCategoryList;
    private SearchAndReport countByLocation;
    private SearchAndReport countByUser;
    private SearchAndReport sortByDiscount;

    public SearchAndReportFacade(LinkedList<Transaction> transactions) {
        searchCID = new SearchRecordByCustomerId(transactions);
        searchCategory = new SearchRecordByProductCategory(transactions);
        sortByNetAmount = new SortProductCategoryByNetAmount(transactions);
        sortByCategoryList = new ListProductByCategory(transactions);
        countByLocation = new ProductByEachLocation(transactions);
        countByUser = new TotalProductCountByEachUser(transactions);
        sortByDiscount = new ProductWithDiscount(transactions);
    }

    public void searchByCustomerId() {
        searchCID.searchAndReport();
    }

    public void searchByProductCategory() {
        searchCategory.searchAndReport();
    }

    public void reportSortedByNetAmount() {
        sortByNetAmount.searchAndReport();
    }

    public void listProductsByCategory() {
        sortByCategoryList.searchAndReport();
    }

    public void countProductsByLocation() {
        countByLocation.searchAndReport();
    }

    public void productCountByEachUser() {
        countByUser.searchAndReport();
    }

    public void productWithDiscountAvailable() {
        sortByDiscount.searchAndReport();
    }

}
