package com.example.fullstack.crud.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.fullstack.crud.api.dto.FuncionarioDTO;
import com.example.fullstack.crud.api.dto.FuncionarioNewDTO;
import com.example.fullstack.crud.exception.RegraNegocioException;
import com.example.fullstack.crud.model.entity.Funcionario;
import com.example.fullstack.crud.service.FuncionarioService;

@SuppressWarnings({ "rawtypes", "unchecked" })


@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

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
	public ResponseEntity save(@RequestBody FuncionarioNewDTO objDTO) {

		try {

			Funcionario obj = service.fromDTO(objDTO);
			
			obj = service.salvar(obj);
			
			return new ResponseEntity(obj, HttpStatus.CREATED);

		} catch (RegraNegocioException e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity update(@RequestBody FuncionarioDTO objDTO, @PathVariable Long id) {
		
		Funcionario obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.atuaizar(obj);
		
		return ResponseEntity.noContent().build();
				
		
	}
	
	
	
	
	@DeleteMapping("{id}")
	public ResponseEntity deletar( @PathVariable("id") Long id ) {
		return service.obterPorId(id).map( entidade -> {
			service.deletar(entidade);
			return new ResponseEntity( HttpStatus.NO_CONTENT );
		}).orElseGet( () -> 
			new ResponseEntity("Lancamento não encontrado na base de Dados.", HttpStatus.BAD_REQUEST));
	}
	
	
	
	
	
	
	
	

}
