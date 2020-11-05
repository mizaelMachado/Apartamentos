package com.ufc.apartamentos.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ufc.apartamentos.model.Apartamento;
import com.ufc.apartamentos.repository.ApartamentoRepository;


@Service
public class ApartamentoService {
	
	 @Autowired
	 ApartamentoRepository apartamentoRepository;
	 
	 public Apartamento addApartamento(String endereco, int quantidadeQuartos, int quantidadeVagasGaragem, float valorAluguel,
										float valorCondominio, LocalDate dataPostagem) {
	        Apartamento apartamento = new Apartamento(endereco, quantidadeQuartos, quantidadeVagasGaragem,valorAluguel,valorCondominio,dataPostagem);
	        return apartamentoRepository.save(apartamento);
	 }
	 
	 public boolean removeApartamento(Integer id) {
	        if(apartamentoRepository.existsById(id)) {
	        	apartamentoRepository.deleteById(id);
	            return true;
	        }
	        
	        return false;
	 }
	 public List<Apartamento> getApartamentosByQuantidade(int quantidade) {
	       return apartamentoRepository.findLimited(quantidade);
	 }
	 public List<Apartamento> getApartamentos() {
	        return apartamentoRepository.findAll();
	 }
	 
	 
	 public Apartamento getApartamento(Integer id) {
	        return apartamentoRepository.findById(id).get();
	 }
	 
	 public List<Apartamento> getApartamentoByEndereco(String endereco) {
	      return apartamentoRepository.findAllByEndereco(endereco);
	 }
	 public List<Apartamento> getApartamentoByMesAno(LocalDate data) {
		  int mes= data.getMonthValue();
		  int ano= data.getYear();
	      return apartamentoRepository.findAllByMesAno(mes, ano);
	 }
	 
	 public List<Apartamento> getApartamentoByAluguelMenor(float valor) {
	       return apartamentoRepository.findAllByAluguelMenor(valor);
	 }
	 
	 public List<Apartamento> getApartamentoByAluguelEntre(float inferior, float superior) {
	       return apartamentoRepository.findAllByAluguelEntre(inferior, superior);
	 }
	public List<Apartamento> getApartamentoByAluguelCondominioEntre(float inferior, float superior,float inferiorCondominio, float superiorCondominio) {
	       return apartamentoRepository.findAllByAluguelCondominioEntre(inferior, superior, inferiorCondominio, superiorCondominio);
	}
	 
	 public Apartamento updateApartamento(int id, String endereco, int quantidadeQuartos, int quantidadeVagasGaragem, float valorAluguel,
											float valorCondominio, LocalDate dataPostagem) {
	       Apartamento apartamento = apartamentoRepository.findById(id).get();
	        
	        if(apartamento != null) {
	            apartamento.setEndereco(endereco);
	            apartamento.setQuantidadeQuartos(quantidadeQuartos);
	            apartamento.setQuantidadeVagasGaragem(quantidadeVagasGaragem);
	            apartamento.setValorAluguel(valorAluguel);
	            apartamento.setValorCondominio(valorCondominio);
	            apartamento.setDataPostagem(dataPostagem);
	            
	            apartamentoRepository.save(apartamento);         
	        }
	        
	        return apartamento;
	    }
}

