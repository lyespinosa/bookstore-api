package com.bookstore.repositories;

import com.bookstore.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGenderRepository  extends JpaRepository<Gender, Long> {

    @Query(value = "select genders.* from genders " +
            "where genders.name like %:genderName%", nativeQuery = true)
    List<Gender> getGenderByName(String genderName);



}
