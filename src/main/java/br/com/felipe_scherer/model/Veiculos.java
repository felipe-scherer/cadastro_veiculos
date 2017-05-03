package br.com.felipe_scherer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Veiculos {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false, length=60)
	private String fabricante;
	private String modelo;
	private String ano;
	private byte[] foto;
	private String nome_foto;
	private Long tamanho_foto;
	private String type_foto;
	
	
	
	
	
	public String getType_foto() {
		return type_foto;
	}


	public void setType_foto(String type_foto) {
		this.type_foto = type_foto;
	}


	public Long getTamanho_foto() {
		return tamanho_foto;
	}


	public void setTamanho_foto(Long tamanho_foto) {
		this.tamanho_foto = tamanho_foto;
	}


	public String getNome_foto() {
		return nome_foto;
	}


	public void setNome_foto(String nome_foto) {
		this.nome_foto = nome_foto;
	}

	public byte[] getFoto() {
		return foto;
	}


	public void setFoto(byte[] foto) {
		this.foto = foto;
	}


	public Veiculos() {
		// TODO Auto-generated constructor stub
	}


	public String getFabricante() {
		return fabricante;
	}


	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}


	public Veiculos(String fabricante, String modelo, String ano) {
		super();
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.ano = ano;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
