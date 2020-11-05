package com.ufc.apartamentos.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.ufc.apartamentos.model.Apartamento;



public interface ApartamentoRepository extends JpaRepository<Apartamento, Integer> {
	@Query(value="SELECT * FROM apartamentos u ORDER BY u.id LIMIT ?1 ", nativeQuery = true)
	List<Apartamento> findLimited(int quantidade);
	
	@Query(value="SELECT * FROM apartamentos u WHERE u.valor_aluguel < ?1", nativeQuery = true)
	List<Apartamento> findAllByAluguelMenor(float aluguel);
	
	@Query(value="SELECT * FROM apartamentos u WHERE u.valor_aluguel >= ?1 AND u.valor_aluguel <= ?2", nativeQuery = true)
	List<Apartamento> findAllByAluguelEntre(float inferior, float superior);
	
	@Query(value="SELECT * FROM apartamentos u WHERE u.valor_aluguel >= ?1 AND u.valor_aluguel <= ?2 AND u.valor_condominio >= ?3 AND u.valor_condominio <= ?4", nativeQuery = true)
	List<Apartamento> findAllByAluguelCondominioEntre(float inferiorAluguel, float superiorAluguel, float inferiorCondominio, float superiorCondominio);
	
	@Query(value="SELECT * FROM apartamentos u WHERE u.endereco = ?1", nativeQuery = true)
	List<Apartamento> findAllByEndereco(String endereco);
	
	@Query(value="SELECT * from apartamentos u"
			+ " WHERE EXTRACT(Month from u.data_postagem) = ?1 and Extract(Year from u.data_postagem) = ?2 ", nativeQuery = true)
	List<Apartamento> findAllByMesAno(int mes, int ano);
	
}

