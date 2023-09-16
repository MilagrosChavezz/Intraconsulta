package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class AsignacionProfeACurso {

	private Profesor profesor;
	private Cursada curso;
	private Universidad unlam;
	private static Integer id;

	public AsignacionProfeACurso(Profesor profesor, Cursada curso, Integer id, Universidad unlam) {
		super();
		this.profesor = profesor;
		this.curso = curso;
		this.unlam = unlam;
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

	public Universidad getUnlam() {
		return unlam;
	}

	public void setUnlam(Universidad unlam) {
		this.unlam = unlam;
	}

	public static Integer getId() {
		return id;
	}

	public static void setId(Integer id) {
		AsignacionProfeACurso.id = id;
	}

	public Boolean asignarProfesorACurso(Profesor profesoraAsignar, Cursada cursada) {
		if (estaDisponible(profesoraAsignar, cursada) && profesoraAsignar != null) {
			// Verifica si el profesor ya está asignado a esta cursada
			if (!cursada.getProfesores().contains(profesoraAsignar)
					&& cursada.cantidadDeProfesoresPorCursoRequerido() > cursada.cantidadDeProfesoresActuales()) {
				profesor.seAgregaCursadaActual(cursada);
				cursada.setProfesores(profesoraAsignar);
				return true;
			}
		}
		return false;
	}

	public boolean estaDisponible(Profesor profesoraAsignar, Cursada cursada) {
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