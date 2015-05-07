package jba.model.pagination;

import org.hibernate.Criteria;

public interface PageRequest {

    int getPageSize();

    int getFirstResult();

    void setSortOrders(Criteria query);
}
