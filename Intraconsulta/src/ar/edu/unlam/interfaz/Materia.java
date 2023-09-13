package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class Materia {

	private String nombre;
	private Integer codigoMateria;
	private ArrayList<Integer> codigoMateriascorrelativas;
	private Aula aula;

	public Materia(String nombre, Integer codigoMateria) {
		this.nombre = nombre;
		this.codigoMateria = codigoMateria;
		this.codigoMateriascorrelativas = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getCodigoMateriascorrelativas() {
		return codigoMateriascorrelativas;
	}

	public void setCodigoMateriascorrelativas(ArrayList<Integer> codigoMateriascorrelativas) {
		this.codigoMateriascorrelativas = codigoMateriascorrelativas;
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

	public ArrayList<Integer> getCorrelativas() {
		return codigoMateriascorrelativas;
	}

	public void setCorrelativas(ArrayList<Integer> correlativas) {
		this.codigoMateriascorrelativas = correlativas;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Boolean agregarMateriasCorrelativas(Integer codigoMateriaCorrelativa) {

		Boolean seAgrego = false;
		if (!codigoMateriascorrelativas.contains(codigoMateriaCorrelativa)) {
			codigoMateriascorrelativas.add(codigoMateriaCorrelativa);
			seAgrego = true;
		}
		return seAgrego;

	}

}