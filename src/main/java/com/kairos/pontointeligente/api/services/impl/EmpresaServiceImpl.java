package com.kairos.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kairos.pontointeligente.api.entities.Empresa;
import com.kairos.pontointeligente.api.repositories.EmpresaRepository;
import com.kairos.pontointeligente.api.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService{

	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public Optional<Empresa> buscarEmpresaPorCnpj(String cnpjEmpresa) {
		log.info("Buscando uma empresa para o CNPJ {}", cnpjEmpresa);
		
		return Optional.ofNullable(empresaRepository.findByCnpj(cnpjEmpresa));
	}

	@Override
	public Empresa persistir(Empresa empresa) {
		log.info("Persistindo empresa {}", empresa);
		
		return empresaRepository.save(empresa);
	}

}
