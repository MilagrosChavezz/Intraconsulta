package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class Profesor {

	private String nombre;
	private Integer codigoProfesor;
	private ArrayList<Cursada> cursadasActuales;
	private static Integer id = 0;

	public Profesor(String nombre, String apellido, Integer codigoProfesor) {

		this.nombre = nombre;
		this.codigoProfesor = codigoProfesor;
		this.cursadasActuales = new ArrayList<Cursada>();
		id++;
	}

	public ArrayList<Cursada> getCursadasActuales() {
		return cursadasActuales;
	}

	public void setCursadasActuales(ArrayList<Cursada> cursadasActuales) {
		this.cursadasActuales = cursadasActuales;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigoProfesor() {
		return codigoProfesor;
	}

	public void setCodigoProfesor(Integer codigoProfesor) {
		this.codigoProfesor = codigoProfesor;
	}

	public Boolean seAgregaCursadaActual(Cursada cursoNuevo) {
		return cursadasActuales.add(cursoNuevo);
	}

	public static Integer getId() {
		return id;
	}

	public static void setId(Integer id) {
		Profesor.id = id;
	}

}
