package com.vkr.inventory.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.vkr.inventory.entity.DBItem;

public interface ItemRepository extends JpaRepository<DBItem,Integer > {

}
