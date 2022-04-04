package com.example.fullstack.crud.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Cidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nome_cidade;
	
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "estado_id")
	private Estado estado;
	


	public Cidade() {
		
	}
	
		


	public Cidade(Long id, String nome_cidade, Estado estado) {
		super();
		this.id = id;
		this.nome_cidade = nome_cidade;
		this.estado = estado;

	}






	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}





	public String getNome_cidade() {
		return nome_cidade;
	}




	public void setNome_cidade(String nome_cidade) {
		this.nome_cidade = nome_cidade;
	}




	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
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
		Cidade other = (Cidade) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}
