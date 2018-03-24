package com.kairos.pontointeligente.api.services;

import java.util.Optional;

import com.kairos.pontointeligente.api.entities.Empresa;

public interface EmpresaService {

	Optional<Empresa> buscarEmpresaPorCnpj(String cnpjEmpresa);
	
	Empresa persistir(Empresa empresa);
}
