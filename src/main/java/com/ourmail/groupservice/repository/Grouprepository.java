package com.ourmail.groupservice.repository;

import com.ourmail.groupservice.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Grouprepository extends CrudRepository<Group, long> {
    Group findById(long id)
}

