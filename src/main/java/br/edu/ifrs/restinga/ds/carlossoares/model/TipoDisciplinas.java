package br.edu.ifrs.restinga.ds.carlossoares.model;

public enum TipoDisciplinas {

	PORTUGUES("Portugês"), 
	MATEMATICA("Matemática"), 
	INGLES("Inglês"), 
	HISTORIA("História"), 
	FISICA("Fisica");
	
	private String descricao;
	
	TipoDisciplinas(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
