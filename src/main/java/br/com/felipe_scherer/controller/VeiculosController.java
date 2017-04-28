package br.com.felipe_scherer.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.felipe_scherer.model.Veiculos;
import br.com.felipe_scherer.repository.VeiculosRepository;

@Named
@ViewScoped
public class VeiculosController {
	
	@Autowired
	private VeiculosRepository veiculosRepository;
	private Veiculos veiculo = new Veiculos();
	private List<Veiculos> veiculos;
	
	@PostConstruct
	public void init(){
		setVeiculos(veiculosRepository.buscarTodos());
		
	}
	
	public void salvar(){
		
		veiculosRepository.save(veiculo);
		veiculos.add(veiculo);
		veiculo = new Veiculos();
	}
	
	public Veiculos getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}

	public List<Veiculos> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculos> veiculos) {
		this.veiculos = veiculos;
	}



	public VeiculosRepository getVeiculosRepository() {
		return veiculosRepository;
	}



	public void setVeiculosRepository(VeiculosRepository veiculosRepository) {
		this.veiculosRepository = veiculosRepository;
	}



	
	

}
