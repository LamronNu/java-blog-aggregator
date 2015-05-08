package jba.model;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class PageRequestImpl implements PageRequest{

    int pageNumber;
    int pageSize;
    Order[] sortedFields;


    public PageRequestImpl(int pageNumber, int pageSize, Order[] sortedFields) {
        //check values
        checkPageNumber(pageNumber);
        checkPageSize(pageSize);
        //set values
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sortedFields = checkSortedFields(sortedFields);
    }

    public PageRequestImpl(int pageNumber, int pageSize) {
        this(pageNumber, pageSize, null);
    }

    private Order[] checkSortedFields(Order[] sortedFields) {
        sortedFields = sortedFields == null ? new Order[0] : sortedFields;
        return sortedFields;
    }

    private void checkPageSize(int pageSize) {
        if (pageSize <= 0) {
            throw new IllegalArgumentException("pageSize must be greater than 0");
        }
    }

    private void checkPageNumber(int pageNumber) {
        if (pageNumber <= 0) {
            throw new IllegalArgumentException("pageNumber must be greater than 0");
        }
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public int getFirstResult() {
        return (pageNumber - 1) * pageSize;
    }

    @Override
    public void setSortOrders(Criteria query) {
        for (Order fieldOrder : sortedFields) {
            query.addOrder(fieldOrder);
        }
    }

    public void setPageNumber(int pageNumber) {
        checkPageNumber(pageNumber);
        this.pageNumber = pageNumber;
    }

    public void setPageSize(int pageSize) {
        checkPageSize(pageSize);
        this.pageSize = pageSize;
    }

    public void setSortedFields(Order[] sortedFields) {
        this.sortedFields = checkSortedFields(sortedFields);
    }
}
