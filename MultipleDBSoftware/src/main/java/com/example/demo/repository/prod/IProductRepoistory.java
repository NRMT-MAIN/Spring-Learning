package com.example.demo.repository.prod;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.prod.Product;

public interface IProductRepoistory extends JpaRepository<Product, Integer> {

}
