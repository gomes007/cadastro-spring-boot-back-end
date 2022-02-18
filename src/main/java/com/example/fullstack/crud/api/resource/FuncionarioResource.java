package com.example.fullstack.crud.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.fullstack.crud.api.dto.FuncionarioDTO;
import com.example.fullstack.crud.api.dto.FuncionarioNewDTO;
import com.example.fullstack.crud.model.entity.Funcionario;
import com.example.fullstack.crud.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

	@Autowired
	private FuncionarioService service;

	
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<FuncionarioDTO>> findAll() {

		List<Funcionario> list = service.findAll();
		
		List<FuncionarioDTO> listDTO = list.stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	

		
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Funcionario>> find(@PathVariable Long id) {

		Optional<Funcionario> obj = service.obterPorId(id);
		
		return ResponseEntity.ok().body(obj);

	}

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody FuncionarioNewDTO objDTO){
		
		Funcionario obj = service.fromDTO(objDTO);
		
		obj = service.salvar(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();		
	}
	
	

	
	
	
	

}
