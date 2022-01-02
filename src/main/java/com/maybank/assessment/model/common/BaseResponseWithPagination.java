package com.maybank.assessment.model.common;

public class BaseResponseWithPagination {
    Pagination pagination;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
