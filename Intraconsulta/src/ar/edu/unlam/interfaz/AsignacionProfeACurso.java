package ar.edu.unlam.interfaz;

public class AsignacionProfeACurso {
	
	private Profesor profesor;
	private Cursada curso;
	private Integer id;
	
	public AsignacionProfeACurso(Profesor profesor, Cursada curso, Integer id) {
		super();
		this.profesor = profesor;
		this.curso = curso;
		this.id = id;
	}


	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Cursada getCurso() {
		return curso;
	}

	public void setCurso(Cursada curso) {
		this.curso = curso;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
