package br.com.felipe_scherer.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.util.FileCopyUtils;

import br.com.felipe_scherer.model.Veiculos;
import br.com.felipe_scherer.repository.VeiculosRepository;

@Named
@ViewScoped
public class VeiculosController {
	
	@Autowired
	private VeiculosRepository veiculosRepository;
	
	//Formulario
	private Veiculos veiculo = new Veiculos();
	//Datatable
	private List<Veiculos> veiculos;
	
	private boolean edicao = false;
	
    private javax.servlet.http.Part fotografia;
	
	
	@PostConstruct
	public void init(){
		setVeiculos(veiculosRepository.buscarTodos());
		
	}
	
	
	public void download(Veiculos veiculo)throws IOException{
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();  
		veiculo = veiculosRepository.findOne(veiculo.getId());
		
        response.setContentType(veiculo.getType_foto());        
        response.setContentLength(veiculo.getTamanho_foto().intValue());
        
        response.setHeader("Content-Disposition","attachment; filename=\"" + veiculo.getNome_foto() +"\"");
	  
        //FileCopyUtils.copy(veiculo.getFoto(), response.getOutputStream());
		
		
	}
	
	public void salvar(){
		
		try{
            InputStream is = fotografia.getInputStream();
            byte[] bytes = IOUtils.toByteArray(is);
            
            veiculo.setFoto(bytes);
            veiculo.setTamanho_foto(fotografia.getSize());
            veiculo.setNome_foto(fotografia.getSubmittedFileName());
            veiculo.setType_foto(fotografia.getContentType());
            
            
        }
        catch(IOException e){
            //logar exceção
        	System.out.println("Erro Upload");
        }
		
		
		veiculosRepository.save(veiculo);
		if (!edicao){
			veiculos.add(veiculo);
		}
		veiculo = new Veiculos();
		edicao=false;
	}
	
	public void excluir(Veiculos veiculo){
		veiculosRepository.delete(veiculo);
		veiculos.remove(veiculo);	
	}
	
	public void editar(Veiculos veiculo){
		
		this.veiculo = veiculo;
		edicao=true;
		
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

	public javax.servlet.http.Part getFotografia() {
		return fotografia;
	}

	public void setFotografia(javax.servlet.http.Part fotografia) {
		this.fotografia = fotografia;
	}


	

	
	

}
