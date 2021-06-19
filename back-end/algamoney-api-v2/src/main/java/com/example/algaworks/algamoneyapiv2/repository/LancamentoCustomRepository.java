package com.example.algaworks.algamoneyapiv2.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.algaworks.algamoneyapiv2.model.Categoria;
import com.example.algaworks.algamoneyapiv2.model.Lancamento;

@Repository
public class LancamentoCustomRepository {

	@Autowired
	private EntityManager em;
	
	public LancamentoCustomRepository(EntityManager em) {
		this.em = em;
	}
	
	public List<Lancamento> find(String descricao, LocalDate dataVencimentoDe, LocalDate dataVencimentoAte){
		String query = "select * from lancamento ";
		String condicao = " where ";
		if(descricao != null) {
			query += condicao + "descricao = :descricao";
			condicao = " and ";
		}
		if(dataVencimentoDe != null) {
			query += condicao + "data_vencimento > :dataVencimentoDe";
			condicao = " and ";
		}
		if(dataVencimentoAte != null) {
			query += condicao + "data_vencimento < :dataVencimentoAte";
		}
		System.out.println(query);
		 Query q = em.createNativeQuery(query, Lancamento.class);
		//TypedQuery<Lancamento> q = em.createQuery(query, Lancamento.class);
		if (descricao != null) {
			q.setParameter("descricao", descricao);
		}
		if (dataVencimentoDe != null) {
			q.setParameter("dataVencimentoDe", dataVencimentoDe);
		}
		if (dataVencimentoAte != null) {
			q.setParameter("dataVencimentoAte", dataVencimentoAte);
		}
		return q.getResultList();
	}
	
}
