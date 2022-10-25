package com.chagwey.springbootinventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chagwey.springbootinventorymanagement.model.SaleItem;

public interface SaleItemRepository extends JpaRepository<SaleItem,Integer> {

}
