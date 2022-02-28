package com.example.fullstack.crud.api.dto;

import java.io.Serializable;
import java.util.Date;



public class FuncionarioNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String email;
	private String cpf;
	private String telefone;
	private Date dataNascimento;
	private String estadoCivil; //radio button
	private String sexo; //radio button
	private String [] coding; //check box
	private boolean podeViajar; //switch
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	private Long cidadeId;


	
		

	public FuncionarioNewDTO() {
		super();
		
	}


	
	public String getCodingFormat() {
		StringBuilder elementsBuilder = new StringBuilder();
		for (String f : coding) {
			elementsBuilder.append(f).append(",");
		}
		return elementsBuilder.toString();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}





	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Long cidadeId) {
		this.cidadeId = cidadeId;
	}

	public boolean getPodeViajar() {
		return podeViajar;
	}

	public void setPodeViajar(boolean podeViajar) {
		this.podeViajar = podeViajar;
	}

	public String [] getCoding() {
		 
		return coding;
	}

	public void setCoding(String [] coding) {
		
		this.coding = coding;
	}



	
	
	
	
	


}
