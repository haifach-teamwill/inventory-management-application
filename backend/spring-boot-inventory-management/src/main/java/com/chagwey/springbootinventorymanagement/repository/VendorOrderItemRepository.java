package com.chagwey.springbootinventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chagwey.springbootinventorymanagement.model.VendorOrderItem;

public interface VendorOrderItemRepository extends JpaRepository<VendorOrderItem,Integer>{

}
