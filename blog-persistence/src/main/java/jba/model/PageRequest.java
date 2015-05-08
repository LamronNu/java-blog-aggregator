package jba.model;

import org.hibernate.Criteria;

public interface PageRequest {

    int getPageSize();

    int getFirstResult();

    void setSortOrders(Criteria query);
}
