package com.bookstore.segurity.repository;

import com.bookstore.segurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);

    User findNOByUserName(String userName);

    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);

    @Query(value = "select users.* from users " +
            "where users.email =  :userEmail", nativeQuery = true)
    User getUserByEmail(String userEmail);

    @Query(value = "select users.* from users " +
            "where users.email =  :userEmail and users.password = :userPassword ", nativeQuery = true)
    User getUserByEmailAndPassword(String userEmail, String userPassword);

}
