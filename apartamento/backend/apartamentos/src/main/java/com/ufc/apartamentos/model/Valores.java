package com.ufc.apartamentos.model;


public class Valores{
	
	float inferior;
	float superior;
	float inferiorCondominio;
	float superiorCondominio;
	
	public Valores() {
		
	}
	
	
	public Valores(float inferior, float superior, float inferiorCondominio, float superiorCondominio) {
		super();
		this.inferior = inferior;
		this.superior = superior;
		this.inferiorCondominio = inferiorCondominio;
		this.superiorCondominio = superiorCondominio;
	}


	public Valores(float inferior, float superior) {
		super();
		this.inferior = inferior;
		this.superior = superior;
	}
	
	public float getInferiorCondominio() {
		return inferiorCondominio;
	}

	public void setInferiorCondominio(float inferiorCondominio) {
		this.inferiorCondominio = inferiorCondominio;
	}

	public float getSuperiorCondominio() {
		return superiorCondominio;
	}

	public void setSuperiorCondominio(float superiorCondominio) {
		this.superiorCondominio = superiorCondominio;
	}

	

	public float getInferior() {
		return inferior;
	}
	public void setInferior(float inferior) {
		this.inferior = inferior;
	}
	public float getSuperior() {
		return superior;
	}
	public void setSuperior(float superior) {
		this.superior = superior;
	}

	
}

