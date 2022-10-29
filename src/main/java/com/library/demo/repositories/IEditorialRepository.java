package com.library.demo.repositories;

import com.library.demo.entities.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEditorialRepository extends JpaRepository<Editorial, Long> {

    @Query(value = "select editorials.* from editorials " +
            "where editorials.name like %:editorialName%", nativeQuery = true)
    List<Editorial> getEditorialByName(String editorialName);

}
