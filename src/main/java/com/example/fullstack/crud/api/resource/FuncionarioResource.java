package com.example.fullstack.crud.api.resource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.fullstack.crud.api.dto.FuncionarioDTO;
import com.example.fullstack.crud.exception.RegraNegocioException;
import com.example.fullstack.crud.model.entity.Cidade;
import com.example.fullstack.crud.model.entity.Endereco;
import com.example.fullstack.crud.model.entity.Funcionario;
import com.example.fullstack.crud.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

	@Autowired
	private FuncionarioService service;
	
	
	
	@RequestMapping(method=RequestMethod.GET)
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
	

	
	
	
	
	
	
	
	

	@PostMapping
	public ResponseEntity salvar(@RequestBody FuncionarioDTO dto) {
		
		try {
			
			Funcionario entidade = converterDTOParaEntidade(dto);
			
			entidade = service.salvar(entidade);
			
			return new ResponseEntity(entidade, HttpStatus.CREATED);
			
		} catch (RegraNegocioException e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	
	
	
	
	

	private Funcionario converterDTOParaEntidade(FuncionarioDTO dto) {

		Funcionario func = new Funcionario(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getTelefone(), dto.getDataNascimento());

		Cidade cid = new Cidade(dto.getCidadeId(), null, null);

		Endereco end = new Endereco(null, dto.getLogradouro(), dto.getNumero(), dto.getComplemento(), dto.getBairro(), dto.getCep(), func, cid);
		
		func.getEnderecos().add(end);
		

		return func;
	}
	
	
	

	
	

	
	

}
