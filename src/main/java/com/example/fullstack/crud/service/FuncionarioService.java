package com.example.fullstack.crud.service;

import java.util.List;
import java.util.Optional;

import com.example.fullstack.crud.model.entity.Funcionario;



public interface FuncionarioService {
	
	Funcionario salvar(Funcionario funcionario);
	
	Funcionario atuaizar(Funcionario funcionario);
	
	void deletar(Funcionario funcionario);
	
	List<Funcionario> buscar(Funcionario funcionario);
	
	Optional<Funcionario> obterPorId(Long id);
	
	void validar(Funcionario funcionario);
	
	List<Funcionario> findAll();

}
