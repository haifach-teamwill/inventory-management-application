package com.chagwey.springbootinventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chagwey.springbootinventorymanagement.model.Sale;

public interface SaleRepository extends JpaRepository<Sale,Integer>{

}
