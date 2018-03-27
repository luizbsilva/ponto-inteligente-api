package com.kairos.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.kairos.pontointeligente.api.entities.Lancamento;
import com.kairos.pontointeligente.api.repositories.LancamentoRepository;
import com.kairos.pontointeligente.api.services.LancamentoService;

public class LancamentoServiceImpl implements LancamentoService {

	private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);

	@Autowired
	private LancamentoRepository lancamentoRepository;

	public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
		log.info("Buscando lançamentos para o funcionário ID {}", funcionarioId);
		return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
	}

	@Cacheable("lancamentoPorId")
	public Optional<Lancamento> buscarPorId(Lancamento id) {
		log.info("Buscando um lançamento pelo ID {}", id);
		return Optional.ofNullable(new Lancamento());
	}

	@CachePut("lancamentoPorId")
	public Lancamento persistir(Lancamento lancamento) {
		log.info("Persistindo o lançamento: {}", lancamento);
		return this.lancamentoRepository.save(lancamento);
	}

	public void remover(Lancamento lancamento) {
		log.info("Removendo o lançamento ID {}", lancamento.getId());
		this.lancamentoRepository.delete(lancamento);
	}

}
