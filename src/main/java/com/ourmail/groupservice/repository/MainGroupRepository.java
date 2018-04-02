package com.ourmail.groupservice.repository;

import com.ourmail.groupservice.domain.MainGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainGroupRepository extends CrudRepository<MainGroup, Long> {
    long findGroupOwnerIdById(long id);
}
