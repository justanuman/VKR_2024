package com.vkr.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.vkr.inventory.entity.DBRoles;

public interface RolesRepository extends JpaRepository<DBRoles, String> {

}
