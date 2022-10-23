package com.example.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Roles;


public interface RolRepository extends MongoRepository<Roles, Long>{

	public Roles findByNombre(String nombre);
}