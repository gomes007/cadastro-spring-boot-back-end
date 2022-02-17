package com.example.fullstack.crud.api.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.fullstack.crud.model.entity.Funcionario;



public class FuncionarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	

	
	
	
	


	public FuncionarioDTO(Funcionario obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
	}



	public FuncionarioDTO() {
		
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	


}
