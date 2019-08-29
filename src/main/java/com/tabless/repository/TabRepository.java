package com.tabless.repository;

import com.tabless.models.Tab;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TabRepository extends PagingAndSortingRepository<Tab, Long> {
}
