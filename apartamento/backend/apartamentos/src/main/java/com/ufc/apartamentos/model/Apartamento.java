package com.ufc.apartamentos.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity(name="apartamentos")
public class Apartamento {
	
	@Id
	@GeneratedValue
    int id;
	@NotBlank
	@Size(min=5)
	String endereco;
	@NotNull
	@Min(1)
	int quantidadeQuartos;
	@NotNull
	@Min(1)
	int quantidadeVagasGaragem;
	@NotNull
	@Min(1)
	float valorAluguel;
	@NotNull
	float valorCondominio;
	@NotNull
	LocalDate dataPostagem;
	

	
	public Apartamento() {
	
	}
	
	
	
	public Apartamento( String endereco, int quantidadeQuartos, int quantidadeVagasGaragem, float valorAluguel,
			float valorCondominio, LocalDate dataPostagem) {
		super();
		this.endereco = endereco;
		this.quantidadeQuartos = quantidadeQuartos;
		this.quantidadeVagasGaragem = quantidadeVagasGaragem;
		this.valorAluguel = valorAluguel;
		this.valorCondominio = valorCondominio;
		this.dataPostagem = dataPostagem;
	}
	
	
	
	public Apartamento(int id, String endereco, int quantidadeQuartos, int quantidadeVagasGaragem, float valorAluguel,
			float valorCondominio, LocalDate dataPostagem) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.quantidadeQuartos = quantidadeQuartos;
		this.quantidadeVagasGaragem = quantidadeVagasGaragem;
		this.valorAluguel = valorAluguel;
		this.valorCondominio = valorCondominio;
		this.dataPostagem = dataPostagem;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getQuantidadeQuartos() {
		return quantidadeQuartos;
	}
	public void setQuantidadeQuartos(int quantidadeQuartos) {
		this.quantidadeQuartos = quantidadeQuartos;
	}
	public int getQuantidadeVagasGaragem() {
		return quantidadeVagasGaragem;
	}
	public void setQuantidadeVagasGaragem(int quantidadeVagasGaragem) {
		this.quantidadeVagasGaragem = quantidadeVagasGaragem;
	}
	public float getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(float valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	public float getValorCondominio() {
		return valorCondominio;
	}
	public void setValorCondominio(float valorCondominio) {
		this.valorCondominio = valorCondominio;
	}
	public LocalDate getDataPostagem() {
		return dataPostagem;
	}
	public void setDataPostagem(LocalDate dataPostagem) {
		this.dataPostagem = dataPostagem;
	}



	@Override
	public String toString() {
		return "Apartamento [id=" + id + ", endereco=" + endereco + ", quantidadeQuartos=" + quantidadeQuartos
				+ ", quantidadeVagasGaragem=" + quantidadeVagasGaragem + ", valorAluguel=" + valorAluguel
				+ ", valorCondominio=" + valorCondominio + ", dataPostagem=" + dataPostagem + "]";
	}
	
	
	
}


