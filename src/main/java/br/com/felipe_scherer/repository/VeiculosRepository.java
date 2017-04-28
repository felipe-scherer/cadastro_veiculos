package br.com.felipe_scherer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.felipe_scherer.model.Veiculos;

//bean
@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {
	
	@Query("select v from Veiculos v where v.modelo=:modelo")
	public Veiculos buscarPorModelo(@Param("modelo") String Modelo);
	
	@Query("select v from Veiculos v order by v.id")
	public List<Veiculos> buscarTodos();
	
	
	

}
