package com.example.algaworks.algamoneyapiv2.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.algaworks.algamoneyapiv2.model.Lancamento;
import com.example.algaworks.algamoneyapiv2.model.Pessoa;
import com.example.algaworks.algamoneyapiv2.repository.LancamentoRepository;
import com.example.algaworks.algamoneyapiv2.repository.PessoaRepository;
import com.example.algaworks.algamoneyapiv2.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.getOne(lancamento.getPessoa().getCodigo());
		if (pessoa == null || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativaException();	
		}
		
		return lancamentoRepository.save(lancamento);
	}

	
	
	
	
}
