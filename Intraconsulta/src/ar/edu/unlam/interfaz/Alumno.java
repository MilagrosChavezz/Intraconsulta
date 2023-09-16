package ar.edu.unlam.interfaz;

import java.time.LocalDate;
import java.util.ArrayList;

public class Alumno {
	private String nombre;
	private String apellido;
	private Integer dni;
<<<<<<< Updated upstream
	private ArrayList<Materia>materiasAprobadas;

	public Alumno(Integer dni, String apellido, String nombre) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.materiasAprobadas=new ArrayList<Materia>();
	}

	public String  getNombre() {
		// TODO Auto-generated method stub
=======
	private LocalDate fechaIngreso;
	private LocalDate fechaNacimineto;
	private ArrayList<Materia> materiasAprobadas;
	private ArrayList<Materia> materiasAFinal;
	
	public static Integer getId() {
		return id;
	}

	public static void setId(Integer id) {
		Alumno.id = id;
	}

	public void setMateriasAprobadas(ArrayList<Materia> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}

	public void setMateriasAFinal(ArrayList<Materia> materiasAFinal) {
		this.materiasAFinal = materiasAFinal;
	}


	private static Integer id=0;	

	public Alumno(Integer dni, String apellido, String nombre, LocalDate fechaIngreso, LocalDate fechaNacimineto) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimineto = fechaNacimineto;
		this.materiasAprobadas = new ArrayList<Materia>();
		this.materiasAFinal = new ArrayList<Materia>();
		id++;
		
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaNacimineto() {
		return fechaNacimineto;
	}

	public void setFechaNacimineto(LocalDate fechaNacimineto) {
		this.fechaNacimineto = fechaNacimineto;
	}

	public String getNombre() {
>>>>>>> Stashed changes
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

	public void setMateriasAprobadas(Materia  materiasAprobadas) {
		this.materiasAprobadas.add(materiasAprobadas);
		
	}

	public ArrayList<Materia> getMateriasAFinal() {
		return materiasAFinal;
	}


	public void setMateriasAFinal(Materia materiasAFinal) {
		this.materiasAFinal.add(materiasAFinal);

	}

}


