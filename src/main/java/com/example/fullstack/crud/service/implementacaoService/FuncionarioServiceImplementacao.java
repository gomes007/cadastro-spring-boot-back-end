package com.example.fullstack.crud.service.implementacaoService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fullstack.crud.api.dto.FuncionarioDTO;
import com.example.fullstack.crud.api.dto.FuncionarioNewDTO;
import com.example.fullstack.crud.exception.RegraNegocioException;
import com.example.fullstack.crud.model.entity.Cidade;
import com.example.fullstack.crud.model.entity.Endereco;
import com.example.fullstack.crud.model.entity.Funcionario;
import com.example.fullstack.crud.model.repository.EnderecoRepository;
import com.example.fullstack.crud.model.repository.FuncionarioRepository;
import com.example.fullstack.crud.service.FuncionarioService;

@Service
public class FuncionarioServiceImplementacao implements FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;


	@Override
	@Transactional
	public Funcionario salvar(Funcionario obj) {
		
		obj.setId(null);
		
		return repository.save(obj);
	}

	@Override
	@Transactional
	public Funcionario atuaizar(Funcionario obj) {

		Objects.requireNonNull(obj.getId());

		validar(obj);
		
		

		return repository.save(obj);

	}

	@Override
	@Transactional
	public void deletar(Funcionario funcionario) {

		Objects.requireNonNull(funcionario.getId());

		repository.delete(funcionario);

	}
	
	
	

	
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscar(Funcionario funcionario) {

		Example<Funcionario> example = Example.of(funcionario,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));

		return repository.findAll(example);
	}

	
	
	
	
	@Override
	public void validar(Funcionario func) {

		if (func.getNome() == null || func.getNome().trim().equals("")) {
			throw new RegraNegocioException("Informe um nome!");
		}

	}
	
	
	

	@Override
	public List<Funcionario> findAll() {

		return repository.findAll();
	}

	
	
	
	public List<Funcionario> localizaAll() {

		return repository.findAll();
	}

	
	
	
	@Override
	public Optional<Funcionario> obterPorId(Long id) {

		return repository.findById(id);
	}
	
	
	

	@Override
	public Funcionario fromDTO(FuncionarioDTO objDTO) {

		return new Funcionario(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null, null, null, null, null, null, false);
	}
	
	
	

	@Override
	public Funcionario fromDTO(FuncionarioNewDTO objDTO) {

		Funcionario func = new Funcionario(null, objDTO.getNome(), objDTO.getEmail(), objDTO.getCpf(), objDTO.getTelefone(),
				objDTO.getDataNascimento(), objDTO.getEstadoCivil(), objDTO.getSexo(), objDTO.getCoding(),
				objDTO.getPodeViajar());
				
		
		Cidade cid = new Cidade(objDTO.getCidadeId(), null, null);
		
		
		Endereco end = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(), objDTO.getBairro(), objDTO.getCep(), func, cid);
		
		
		func.getEnderecos().add(end);
		
		return func;
		
		
	}

}
