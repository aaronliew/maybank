package com.maybank.assessment.util;

import com.maybank.assessment.exception.InvalidPaginationException;
import com.maybank.assessment.model.common.Pagination;

public class PaginationUtil {
    public static Pagination createPagination(int count, int pageSize, int pageNumber){
        Pagination pagination = new Pagination();
        int pageCount = (count + pageSize - 1) / pageSize;
        pagination.setPageCount(pageCount);
        pagination.setPageSize(pageSize);
        pagination.setTotalCount(count);
        pagination.setPageNumber(pageNumber+1);
        return pagination;
    }

    public static void validatePagination(int pageNumber, int pageSize) throws InvalidPaginationException {
        if (pageNumber <= 0 || pageSize <= 0) {
            throw new InvalidPaginationException();
        }
    }
}
