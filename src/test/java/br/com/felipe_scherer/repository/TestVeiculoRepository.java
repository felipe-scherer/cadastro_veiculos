package br.com.felipe_scherer.repository;

import javax.persistence.EntityManager;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.felipe_scherer.model.Veiculos;
import junit.framework.Assert;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
//banco interno para teste
@DataJpaTest

public class TestVeiculoRepository {
	
	
	@Autowired
	private VeiculosRepository veiculosRepository;
	
	@Autowired
	EntityManager entityManager;
	

	@Test
	public void testSalvar(){
		Veiculos v = new Veiculos("VW", "Gol", "2012" );
		Veiculos vSalvo = veiculosRepository.save(v);
		
		Assert.assertNotNull(vSalvo.getId());
		
	}
	
	@Test
	public void testBuscarPorModelo(){
		
		Veiculos v = new Veiculos("VW", "Gol", "2014");
		entityManager.persist(v);
		
		Veiculos vEncontrado = veiculosRepository.buscarPorModelo("Gol");
		
		assertThat(vEncontrado.getModelo()).isEqualTo(v.getModelo());
		assertThat(vEncontrado.getAno()).isEqualTo(v.getAno());
		
		
	}
	
	
}
