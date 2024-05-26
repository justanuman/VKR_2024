package com.vkr.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.vkr.inventory.entity.DBUserRoles;

public interface UserRolesRepository extends JpaRepository<DBUserRoles, Integer> {

}
