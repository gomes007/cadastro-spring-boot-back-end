package com.example.fullstack.crud.service;

import java.util.List;
import java.util.Optional;

import com.example.fullstack.crud.api.dto.FuncionarioDTO;
import com.example.fullstack.crud.api.dto.FuncionarioNewDTO;
import com.example.fullstack.crud.model.entity.Endereco;
import com.example.fullstack.crud.model.entity.Funcionario;



public interface FuncionarioService {
	
	Funcionario salvar(Funcionario funcionario);
	
	Funcionario atuaizar(Funcionario funcionario);
	
	void deletar(Funcionario funcionario);
	
	List<Funcionario> buscar(Funcionario funcionario);
	
	Optional<Funcionario> obterPorId(Long id);
	
	void validar(Funcionario funcionario);
	
	List<Funcionario> findAll();
	
	
	Funcionario fromDTO(FuncionarioDTO objDTO);
	
	
	Funcionario fromDTO(FuncionarioNewDTO objDTO);

	void salvarEnderecos(Funcionario funcionario, Endereco[] enderecos);
	

}
