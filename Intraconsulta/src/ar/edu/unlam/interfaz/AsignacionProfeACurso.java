package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class AsignacionProfeACurso {

	private Profesor profesor;
	private Cursada curso;
	private Integer id; 

    private static Integer nextId = 1;

	public AsignacionProfeACurso(Profesor profesor, Cursada curso) {
		super();
		this.profesor = profesor;
		this.curso = curso;
		  this.id = nextId;
	        nextId++;

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

	public Boolean asignarProfesorACurso() {
		if (estaDisponible() && profesor != null) {

			profesor.seAgregaCursadaActual(curso);
			return true;
		}
		return false;
	}

	public Boolean estaDisponible() {
		ArrayList<Cursada> cursadaAEvaluar = profesor.getCursadasActuales();

		for (int i = 0; i < cursadaAEvaluar.size(); i++) {
			if (cursadaAEvaluar.get(i).getDias().equals(curso.getDias())
					&& cursadaAEvaluar.get(i).getHorarios().equals(curso.getHorarios())
					&& cursadaAEvaluar.get(i).getCicloElectivo().getfechaInicioCicloLectivo()
							.equals(curso.getCicloElectivo().getfechaInicioCicloLectivo())
					&& cursadaAEvaluar.get(i).getCicloElectivo().getCuatrimestre()
							.equals(curso.getCicloElectivo().getCuatrimestre()) && cursadaAEvaluar.get(i).getId().equals(curso.getId())) {
				return false; // El profesor tiene otra cursada en el mismo horario y día
			}
		}
		return true;
	}
}