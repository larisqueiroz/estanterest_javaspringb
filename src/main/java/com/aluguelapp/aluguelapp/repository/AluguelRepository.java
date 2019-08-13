package com.aluguelapp.aluguelapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.aluguelapp.aluguelapp.models.Aluguel;

public interface AluguelRepository extends CrudRepository<Aluguel, String>{
	Aluguel findByCodigo(long codigo);
}
