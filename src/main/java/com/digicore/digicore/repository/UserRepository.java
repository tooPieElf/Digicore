package com.digicore.digicore.repository;

import com.digicore.digicore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        User findByAccountName(String accountName);
        User findByAccountNumber(String accountNumber);
}
