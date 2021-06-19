package com.example.algaworks.algamoneyapiv2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algaworks.algamoneyapiv2.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
	
}
