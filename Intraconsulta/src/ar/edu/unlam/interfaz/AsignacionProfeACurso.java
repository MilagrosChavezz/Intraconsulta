package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class AsignacionProfeACurso {

	private Profesor profesor;
	private Cursada curso;
	private static Integer id = 0;

	public AsignacionProfeACurso(Profesor profesor, Cursada curso) {
		super();
		this.profesor = profesor;
		this.curso = curso;
		id++;

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
		if (estaDisponible(profesor, curso) && profesor != null) {
			 
			if (curso.getUnlam().getProfesores().contains(profesor)) {

				return true;
			}
		}
		return false;
	}

	public Boolean estaDisponible(Profesor profesoraAsignar, Cursada cursada) {
		ArrayList<Cursada> cursadaAEvaluar = profesoraAsignar.getCursadasActuales();

		for (int i = 0; i < cursadaAEvaluar.size(); i++) {
			if (cursadaAEvaluar.get(i).getDias().equals(cursada.getDias())
					&& cursadaAEvaluar.get(i).getHorarios().equals(cursada.getHorarios())
					&& cursadaAEvaluar.get(i).getCicloElectivo().getfechaInicioCicloLectivo()
							.equals(cursada.getCicloElectivo().getfechaInicioCicloLectivo())
					&& cursadaAEvaluar.get(i).getCicloElectivo().getCuatrimestre()
							.equals(cursada.getCicloElectivo().getCuatrimestre())) {
				return false; // El profesor tiene otra cursada en el mismo horario y día
			}
		}
		return true;
	}
}