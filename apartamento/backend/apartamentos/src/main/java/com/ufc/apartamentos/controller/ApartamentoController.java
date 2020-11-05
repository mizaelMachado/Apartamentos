package com.ufc.apartamentos.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.ufc.apartamentos.model.Apartamento;
import com.ufc.apartamentos.model.Valores;
import com.ufc.apartamentos.services.ApartamentoService;


@RestController
@CrossOrigin
@RequestMapping(path = "/api/apartamentos")
public class ApartamentoController {

	@Autowired
    ApartamentoService apartamentoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Apartamento>> getApartamentos() {
	       return new ResponseEntity<List<Apartamento>>(apartamentoService.getApartamentos(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<Apartamento> getApartamento(@PathVariable("id") Integer id) {
           return new ResponseEntity<Apartamento>(apartamentoService.getApartamento(id), HttpStatus.OK);
    }
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/search2")
	public ResponseEntity<List<Apartamento>> getApartamentoByEndereco(@RequestParam("endereco") String endereco) {
	        return new ResponseEntity<List<Apartamento>>(apartamentoService.getApartamentoByEndereco(endereco), HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/search3")
	public ResponseEntity<List<Apartamento>> getApartamentosByMesAno(@RequestParam("data") String data1) {
			LocalDate data = LocalDate.parse(data1);
	       return new ResponseEntity<List<Apartamento>>(apartamentoService.getApartamentoByMesAno(data), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/search1")
	public ResponseEntity<List<Apartamento>> getApartamentosLimited(@RequestParam("quantidade") int quantidade) {
	       return new ResponseEntity<List<Apartamento>>(apartamentoService.getApartamentosByQuantidade(quantidade), HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.GET, value="/search4")
	public ResponseEntity<List<Apartamento>> getApartamentosByAluguelMenor(@RequestParam("valor") float valor) {
	       return new ResponseEntity<List<Apartamento>>(apartamentoService.getApartamentoByAluguelMenor(valor), HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.POST, value="/search5")
	public ResponseEntity<List<Apartamento>> getApartamentosByAluguelEntre(@RequestBody Valores valores) {
		float inferior = valores.getInferior();
		float superior = valores.getSuperior();
		return new ResponseEntity<List<Apartamento>>(apartamentoService.getApartamentoByAluguelEntre(inferior, superior), HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.POST, value="/search6")
	public ResponseEntity<List<Apartamento>> getApartamentosByAluguelCondominioEntre(@RequestBody Valores valores) {
		float inferior = valores.getInferior();
		float superior = valores.getSuperior();
		float inferiorCondominio = valores.getInferiorCondominio();
		float superiorCondominio = valores.getSuperiorCondominio();
		return new ResponseEntity<List<Apartamento>>(apartamentoService.getApartamentoByAluguelCondominioEntre(inferior, superior, inferiorCondominio, superiorCondominio), HttpStatus.OK);
	}
	 @RequestMapping(method = RequestMethod.POST)
	 public ResponseEntity<Apartamento> addApartamento(@Valid @RequestBody Apartamento apartamento, BindingResult resultado, RedirectAttributes atr) {
		    if(resultado.hasErrors()) {
		    	atr.addFlashAttribute("mensagem", "erro ao persistir apartamento");
		    	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		    }
	        return new ResponseEntity<Apartamento>(apartamentoService.addApartamento(apartamento.getEndereco(), apartamento.getQuantidadeQuartos(), apartamento.getQuantidadeVagasGaragem(), apartamento.getValorAluguel(), apartamento.getValorCondominio(), apartamento.getDataPostagem()), HttpStatus.CREATED);
	}
	
	 @RequestMapping(method = RequestMethod.PUT, value = "{id}")
	 public ResponseEntity<Apartamento> updateFuncionario(@PathVariable("id") Integer id,@Valid @RequestBody Apartamento apartamento, BindingResult resultado, RedirectAttributes atr) {
	     if(resultado.hasErrors()) {
	    	 atr.addFlashAttribute("mensagem", "erro ao atualizar apartamento");
		     return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	     }
		 
		 return new ResponseEntity<Apartamento>(apartamentoService.updateApartamento(id, apartamento.getEndereco(), apartamento.getQuantidadeQuartos(),apartamento.getQuantidadeVagasGaragem(), apartamento.getValorAluguel(), apartamento.getValorCondominio(), apartamento.getDataPostagem()), HttpStatus.OK);
	 }
	 
	 @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	    public ResponseEntity<Void> deleteApartamento(@PathVariable("id") Integer id) {
	        if (apartamentoService.removeApartamento(id)) {
	            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	        }
	 
	        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	 }
}

