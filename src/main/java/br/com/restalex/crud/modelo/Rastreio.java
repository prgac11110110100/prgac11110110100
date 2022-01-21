package br.com.restalex.crud.modelo;

public class Rastreio {

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getId_encomenda() {
		return id_encomenda;
	}

	public void setId_encomenda(String id_encomenda) {
		this.id_encomenda = id_encomenda;
	}

	public String getDescr_encomenda() {
		return descr_encomenda;
	}

	public void setDescr_encomenda(String descr_encomenda) {
		this.descr_encomenda = descr_encomenda;
	}

	public String getNota_fiscal() {
		return nota_fiscal;
	}

	public void setNota_fiscal(String nota_fiscal) {
		this.nota_fiscal = nota_fiscal;
	}

	public String getSituacao_rastreio() {
		return situacao_rastreio;
	}

	public void setSituacao_rastreio(String situacao_rastreio) {
		this.situacao_rastreio = situacao_rastreio;
	}

	public String getDt_rastreio() {
		return dt_rastreio;
	}

	public void setDt_rastreio(String dt_rastreio) {
		this.dt_rastreio = dt_rastreio;
	}

	public String getUsu_rastreio() {
		return usu_rastreio;
	}

	public void setUsu_rastreio(String usu_rastreio) {
		this.usu_rastreio = usu_rastreio;
	}

	private Long    id;                 
	private String  id_encomenda;       
	private String  descr_encomenda;
	private String  nota_fiscal; 
	private String  situacao_rastreio;   
	private String  dt_rastreio;        
	private String  usu_rastreio;        

	public Rastreio() {	}

	public Rastreio(Long id,                  
	String  id_encomenda,        
	String  descr_encomenda,     
	String  nota_fiscal,       
	String  situacao_rastreio,    
	String  dt_rastreio,         
	String  usu_rastreio) {	
		this.id = id;
		this.id_encomenda = id_encomenda; 
		this.descr_encomenda = descr_encomenda; 
		this.nota_fiscal = nota_fiscal; 
		this.situacao_rastreio = situacao_rastreio; 
		this.dt_rastreio = dt_rastreio; 
		this.usu_rastreio = usu_rastreio; 
	}          

}
