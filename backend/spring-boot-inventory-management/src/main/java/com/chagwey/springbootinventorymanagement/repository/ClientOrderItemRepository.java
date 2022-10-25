package com.chagwey.springbootinventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chagwey.springbootinventorymanagement.model.ClientOrderItem;

public interface ClientOrderItemRepository extends JpaRepository<ClientOrderItem, Integer>{
	 

}
