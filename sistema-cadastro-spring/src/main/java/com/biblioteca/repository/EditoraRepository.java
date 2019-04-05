package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora,Integer>{
	
}