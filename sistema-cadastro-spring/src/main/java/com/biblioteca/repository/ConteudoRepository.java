package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.model.Conteudo;

@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo,Integer>{
	
}