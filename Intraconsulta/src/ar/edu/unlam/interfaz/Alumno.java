package ar.edu.unlam.interfaz;

public class Alumno {
	private String nombre;
	private String apellido;
	private Integer dni;

	public Alumno(Integer dni, String apellido, String nombre) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
	}

	public String  getNombre() {
		// TODO Auto-generated method stub
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

}


