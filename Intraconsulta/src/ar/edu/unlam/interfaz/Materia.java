package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class Materia {

	private String nombre;
	private Integer codigoMateria;
	private ArrayList<Integer> correlativas;
	private Aula aula;

	

	public Materia(String nombre, Integer codigoMateria) {
		this.nombre = nombre;
		this.codigoMateria=codigoMateria;
		this.correlativas = new ArrayList<Integer>();
	}

	public Integer getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(Integer codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Boolean agregarMateriasCorrelativas(Integer codigoMateriaCorrelativa) {
		
		Boolean seAgrego=false;
		if(!correlativas.contains(codigoMateriaCorrelativa)) {
			correlativas.add(codigoMateriaCorrelativa);
			seAgrego=true;
		}
		return seAgrego;
		
	}

}
