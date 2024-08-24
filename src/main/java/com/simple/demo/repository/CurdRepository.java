package com.simple.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.demo.Entity.CurdEntity;

public interface CurdRepository extends JpaRepository<CurdEntity, Integer>{

}
