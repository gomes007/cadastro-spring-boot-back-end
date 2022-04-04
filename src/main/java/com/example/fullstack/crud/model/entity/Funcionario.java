package com.example.fullstack.crud.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Funcionario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String email;
	private String cpf;
	private String telefone;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataNascimento;
	
	private String [] estadoCivil; //dropdownlist
	private String sexo; //radio button
	private String [] coding; //check box
	private boolean podeViajar; //switch
	
	private String outrasInfo;
	
	
	
	public String getCodingFormat() {
		StringBuilder elementsBuilder = new StringBuilder();
		for (String f : coding) {
			elementsBuilder.append(f).append(",");
		}
		return elementsBuilder.toString();
	}

	
	

	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();



	public Funcionario(Long id, String nome, String email, String cpf, String telefone, Date dataNascimento,
			String [] estadoCivil, String sexo, String [] coding, boolean podeViajar, String outrasInfo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.estadoCivil = estadoCivil;
		this.sexo = sexo;
		this.coding = coding;
		this.podeViajar = podeViajar;
		this.outrasInfo = outrasInfo;
		
	}
	
	


	public Funcionario() {
		super();
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


	public List<Endereco> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String [] getCoding() {
		return coding;
	}

	public void setCoding(String [] coding) {
		this.coding = coding;
	}
	



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}


	public boolean getDisponivelViagens() {
		return podeViajar;
	}


	public void setDisponivelViagens(boolean disponivelViagens) {
		this.podeViajar = disponivelViagens;
	}




	public String getOutrasInfo() {
		return outrasInfo;
	}




	public void setOutrasInfo(String outrasInfo) {
		this.outrasInfo = outrasInfo;
	}




	public String [] getEstadoCivil() {
		return estadoCivil;
	}




	public void setEstadoCivil(String [] estadoCivil) {
		this.estadoCivil = estadoCivil;
	}






	
	
	

}
