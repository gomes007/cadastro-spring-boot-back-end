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

import com.example.fullstack.crud.exception.RegraNegocioException;
import com.example.fullstack.crud.model.entity.Funcionario;
import com.example.fullstack.crud.model.repository.EnderecoRepository;
import com.example.fullstack.crud.model.repository.FuncionarioRepository;
import com.example.fullstack.crud.service.FuncionarioService;


@Service
public class FuncionarioServiceImplementacao implements FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	@Transactional
	public Funcionario salvar(Funcionario funcionario) {
		validar(funcionario);

		funcionario = repository.save(funcionario);

		enderecoRepository.saveAll(funcionario.getEnderecos()); // ver se precisa dessa linha

		return funcionario;

		// return repository.save(funcionario);
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
	
	
	
	

}
