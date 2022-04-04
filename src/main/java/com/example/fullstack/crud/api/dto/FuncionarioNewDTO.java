package com.example.fullstack.crud.api.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.fullstack.crud.model.entity.Endereco;



public class FuncionarioNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String email;
	private String cpf;
	private String telefone;
	private Date dataNascimento;
	private String [] estadoCivil; //dropdownlist
	private String sexo; //radio button
	private String [] coding; //check box
	private boolean podeViajar; //switch
	
	private Endereco[] enderecos;
	
	public Endereco[] getEnderecos() {
		return enderecos;
	}



	public void setEnderecos(Endereco[] enderecos) {
		this.enderecos = enderecos;
	}



	private String outrasInfo;
	
	private Long cidadeId;
	
	
	//testes
	private Long estadoId;	
	private String nome_cidade;
	private String uf;

	
		

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



	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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


	public Long getEstadoId() {
		return estadoId;
	}



	public void setEstadoId(Long estadoId) {
		this.estadoId = estadoId;
	}



	public String getNome_cidade() {
		return nome_cidade;
	}



	public void setNome_cidade(String nome_cidade) {
		this.nome_cidade = nome_cidade;
	}



	public String getUf() {
		return uf;
	}



	public void setUf(String uf) {
		this.uf = uf;
	}



	public String getOutrasInfo() {
		return outrasInfo;
	}



	public void setOutrasInfo(String outrasInfo) {
		this.outrasInfo = outrasInfo;
	}


	public String [] getCoding() {
		 
		return coding;
	}

	public void setCoding(String [] coding) {
		
		this.coding = coding;
	}
	
	

	public String [] getEstadoCivil() {
		return estadoCivil;
	}



	public void setEstadoCivil(String [] estadoCivil) {
		this.estadoCivil = estadoCivil;
	}







	
	
	
	
	


}
