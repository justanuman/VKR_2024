package com.vkr.inventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.vkr.inventory.entity.DBUsers;

public interface UserRepository extends JpaRepository<DBUsers, String> {
	Optional<DBUsers> findByUsername(String username);

    Boolean existsByMail(String email);

    Optional<DBUsers> findByUsernameOrMail(String username, String mail);

    boolean existsByUsername(String username);
}
