package com.vkr.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.vkr.inventory.entity.DBItemClass;

public interface ItemClassRepository extends JpaRepository<DBItemClass, Integer> {

}
