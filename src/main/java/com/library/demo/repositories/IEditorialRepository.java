package com.library.demo.repositories;

import com.library.demo.entities.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEditorialRepository extends JpaRepository<Editorial, Long> {

    Optional<Editorial> findByName(String name);
}
