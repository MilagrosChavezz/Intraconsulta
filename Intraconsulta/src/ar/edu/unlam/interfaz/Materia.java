package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class Materia {

	private String nombre;
	private Integer codigoMateria;
	private ArrayList<Integer> codigoMateriascorrelativas;
	private Aula aula;
	private static Integer id = 0;

	public Materia(String nombre, Integer codigoMateria, Universidad universidad) {
		this.nombre = nombre;
		this.codigoMateria = codigoMateria;
		this.codigoMateriascorrelativas = new ArrayList<Integer>();
		id++;
	}

	public Integer getId() {
		return id;
	}

	public static void setId(Integer id) {
		Materia.id = id;
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

	public void agregarMateriasCorrelativas(Integer codigoMateriaCorrelativa) {

		codigoMateriascorrelativas.add(codigoMateriaCorrelativa);

	}

	public void eliminarCorrelatividad(Integer idCorrelativaAELiminar) {

		Integer codigoMateriascorrelativasAEliminar = null;

		for (int i = 0; i < codigoMateriascorrelativas.size(); i++) {

			if (codigoMateriascorrelativas.get(i).equals(idCorrelativaAELiminar)) {
				codigoMateriascorrelativasAEliminar = codigoMateriascorrelativas.get(i);
				codigoMateriascorrelativasAEliminar = null;

			}
		}

	}
}