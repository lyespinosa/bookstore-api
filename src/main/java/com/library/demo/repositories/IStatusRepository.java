package com.library.demo.repositories;

import com.library.demo.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStatusRepository extends JpaRepository<Status, Long> {

    @Query(value = "select status.* from status " +
            "where status.name like %:statusName%", nativeQuery = true)
    Status getStatusByName(String statusName);

}
