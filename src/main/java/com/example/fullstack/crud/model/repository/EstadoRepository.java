package com.example.fullstack.crud.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fullstack.crud.model.entity.Estado;


@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
