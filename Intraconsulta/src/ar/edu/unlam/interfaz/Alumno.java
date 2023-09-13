package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class Alumno {
	private String nombre;
	private String apellido;
	private Integer dni;
	private Integer fechaIngreso;
	private Integer fechaNacimineto;
	private ArrayList<Materia> materiasAprobadas;

	public Alumno(Integer dni, String apellido, String nombre, Integer fechaIngreso, Integer fechaNacimineto) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimineto = fechaNacimineto;
		this.materiasAprobadas = new ArrayList<Materia>();
	}

	public Integer getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Integer fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Integer getFechaNacimineto() {
		return fechaNacimineto;
	}

	public void setFechaNacimineto(Integer fechaNacimineto) {
		this.fechaNacimineto = fechaNacimineto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Materia> getMateriasAprobadas() {
		return materiasAprobadas;
	}

	public void setMateriasAprobadas(Materia materiasAprobadas) {
		this.materiasAprobadas.add(materiasAprobadas);

	}

}
