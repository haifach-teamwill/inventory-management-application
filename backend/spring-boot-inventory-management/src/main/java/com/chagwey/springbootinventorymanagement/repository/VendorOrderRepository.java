package com.chagwey.springbootinventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chagwey.springbootinventorymanagement.model.VendorOrder;

public interface VendorOrderRepository extends JpaRepository<VendorOrder,Integer> {

}
