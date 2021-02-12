package com.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.model.Loja;

@Repository
public interface TesteRepository extends JpaRepository<Loja, Long>{

}
