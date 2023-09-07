package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class AsignacionProfeACurso {

	private Profesor profesor;
	private Cursada curso;
	private Integer id;
	private Universidad unlam;

	public AsignacionProfeACurso(Profesor profesor, Cursada curso, Integer id,Universidad unlam) {
		super();
		this.profesor = profesor;
		this.curso = curso;
		this.id = id;
		this.unlam = unlam;

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

	public Boolean asignarProfesorACurso(Profesor profesoraAsignar, Cursada cursada) {

		if (estaDisponible(profesoraAsignar, cursada) 
				&& unlam.estaIngresadaLaCursada(cursada) && profesoraAsignar != null && unlam.estaIngresadoALaUniversidad(profesoraAsignar)) {
			profesor.seAgregaCursadaActual(cursada);
			cursada.setProfesores(profesoraAsignar);
			return true;
		}
		return false;

	}

	private boolean estaDisponible(Profesor profesoraAsignar, Cursada cursada) {
		// TODO Auto-generated method stub
		ArrayList<Cursada> cursadaAEvaluar = profesoraAsignar.getCursadasActuales();
		
			for (int i = 0; i < cursadaAEvaluar.size(); i++) {
				if (cursadaAEvaluar.get(i).getDias().equals(cursada.getDias())
						&& cursadaAEvaluar.get(i).getHorarios().equals(cursada.getHorarios())
						&& cursada.cantidadDeProfesoresPorCursoRequerido() >= cursada.getProfesores().size()) {
					return false;
				}
			}
		

		return true;
	}

}
