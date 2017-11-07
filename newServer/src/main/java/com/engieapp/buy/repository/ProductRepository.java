package com.engieapp.buy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.engieapp.buy.model.Products;

public interface ProductRepository extends JpaRepository<Products,Integer>{

}
