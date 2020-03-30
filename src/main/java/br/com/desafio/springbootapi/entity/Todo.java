package br.com.desafio.springbootapi.entity;

import java.time.LocalDateTime;
//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.swagger.annotations.ApiModelProperty;
@Entity //ENTIDADE
@Table(name="todo") //NOME DA TABELA CRIADA NO BANCO
public class Todo {
	@ApiModelProperty(value = "Código da tarefa")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //CONFIGS DA VARIAVEL ID, PARA GERAR AUTO;
	private long id;
	@NotNull @NotEmpty
	private String description;
	private boolean completed;
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
    private LocalDateTime updatedAt;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
