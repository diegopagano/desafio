package br.com.desafio.springbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.springbootapi.entity.Todo;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> { }

//A interface herda a JpaRepository, para nao precisar fazer os metodos
//padrões para o crud.