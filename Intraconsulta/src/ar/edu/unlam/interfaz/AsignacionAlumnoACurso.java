package ar.edu.unlam.interfaz;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class AsignacionAlumnoACurso {

	private static Integer id = 0;
	private Cursada curso;
	private Alumno alumno;
	private Universidad unlam;
	private ArrayList<Nota> notas;
	private ArrayList<Materia> materiasCorrelaAprobadas;
	private LocalDate diaDeInscripcion;

	public AsignacionAlumnoACurso(Cursada curso, Alumno alumno) {
		super();
		id++;
		this.curso = curso;
		this.alumno = alumno;
		this.materiasCorrelaAprobadas = new ArrayList<Materia>();
		this.notas = new ArrayList<Nota>();

	}

	public ArrayList<Materia> getMateriasAprobadas() {
		return materiasCorrelaAprobadas;
	}

	public Universidad getUnlam() {
		return unlam;
	}

	public void setUnlam(Universidad unlam) {
		this.unlam = unlam;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}
	
	public Boolean AgregarNota(Nota notaNueva) {
	    if (aproboCorrelativas()) {
	        if ((notaNueva.getEvaluacion().equals(Evaluacion.RECUPERATORIO) && !yaExisteNota(Evaluacion.RECUPERATORIO))
	            || (notaNueva.getEvaluacion().equals(Evaluacion.PRIMER_PARCIAL) && !yaExisteNota(Evaluacion.PRIMER_PARCIAL))
	            || (notaNueva.getEvaluacion().equals(Evaluacion.SEGUNDO_PARCIAL) && !yaExisteNota(Evaluacion.SEGUNDO_PARCIAL))) {
	            this.notas.add(notaNueva);
	            return true;
	        }
	    }
	    return false;
	}

	private Boolean yaExisteNota(Evaluacion evaluacion) {
	    for (Nota nota : notas) {
	        if (nota.getEvaluacion().equals(evaluacion)) {
	            return true;
	        }
	    }
	    return false;
	}
	public ArrayList<Materia> getMateriasCorrelaAprobadas() {
		return materiasCorrelaAprobadas;
	}

	public void setMateriasCorrelaAprobadas(ArrayList<Materia> materiasCorrelaAprobadas) {
		this.materiasCorrelaAprobadas = materiasCorrelaAprobadas;
	}

	public Integer getId() {
		return id;
	}

	public Cursada getCurso() {
		return curso;
	}

	public void setCurso(Cursada curso) {
		this.curso = curso;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Boolean inscribirAlumno() {
		boolean sePuedeInscribir = false;

		if (curso.cantidadAlumnosAnotados() <= curso.getCupoMaximoAlumnos()
				&& curso.getUnlam().buscarAsignacion(curso.getId(),alumno.getDni() )!=null
				&& curso.getUnlam().buscarAlumno(alumno.getDni()) != null && inscripcionDentroDeFecha() ) {
			if (aproboCorrelativas() || adeudaCorrelativas() || !recursa()) {
				
				sePuedeInscribir = true;
			}
		}
		return sePuedeInscribir;
	}

	public Boolean apruebaPrimerParcial() {
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).getValor() >= 7 && notas.get(i).getEvaluacion().equals(Evaluacion.PRIMER_PARCIAL)) {
				return true;
			}
		}
		return false;
	}

	public Boolean apruebaSegundoParcial() {
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).getValor() >= 7 && notas.get(i).getEvaluacion().equals(Evaluacion.SEGUNDO_PARCIAL)) {
				return true;
			}
		}
		return false;
	}

	public Boolean recuperaPrimerParcial() {
		if (!apruebaPrimerParcial()) {
			return true;
		}
		return false;
	}

	public Boolean recuperaSegundoParcial() {
		if (!apruebaSegundoParcial()) {
			return true;
		}
		return false;
	}

	public Nota buscarNotas(Evaluacion evaluacionNota) {
		Nota notaBuscada = null;

		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).getEvaluacion().equals(evaluacionNota)) {
				notaBuscada = notas.get(i);
				break;
			}
		}

		return notaBuscada;
	}

	public Boolean aprobarRecuperatorio() {

		Nota notaBuscada = buscarNotas(Evaluacion.RECUPERATORIO);

		// si la nota del recuperatorio es mayor a 7 se aprueba el 1ro o 2do parcial
		if (recuperaPrimerParcial()) {

			if (notaBuscada.getValor() >= 7) {

				asignarNotaRecuperatorio(Evaluacion.PRIMER_PARCIAL, notaBuscada);
				return true;
			}

			if (recuperaSegundoParcial()) {

				if (notaBuscada.getValor() >= 7) {

					asignarNotaRecuperatorio(Evaluacion.SEGUNDO_PARCIAL, notaBuscada);
					return true;
				}

			}
		}
		return false;
	}

	public void asignarNotaRecuperatorio(Evaluacion parcial, Nota notaDelRecuperatorio) {
		// TODO Auto-generated method stub
		Nota notaACambiar = buscarNotas(parcial);
		if (notaACambiar != null)
			notaACambiar.asignarValor(notaDelRecuperatorio.getValor());

	}

	public Nota buscarNota(Evaluacion notaBuscada) {
		Nota notaABuscar = null;
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).getEvaluacion().equals(notaBuscada)) {
				notaABuscar = notas.get(i);
			}
		}
		return notaABuscar;

	}

	public Integer obtenerNotaFinal() {
		Integer notaFinal = null;
		if (apruebaPrimerParcial() && apruebaSegundoParcial()) {
			notaFinal = (buscarNota(Evaluacion.PRIMER_PARCIAL).getValor()
					+ buscarNota(Evaluacion.SEGUNDO_PARCIAL).getValor()) / 2;
		}
		return notaFinal;
	}

	public Boolean promocionaMateria() {
		if (apruebaSegundoParcial() && apruebaPrimerParcial() && aproboCorrelativas() || apruebaFinal()) {
			alumno.setMateriasAprobadas(curso.getMateria());
			return true;
		}
		return false;
	}

	public Boolean debeIrAFinal() {
	    boolean primerParcialEncontrado = false;
	    boolean segundoParcialEncontrado = false;

	    for (int i = 0; i < notas.size(); i++) {
	        if (notas.get(i).getEvaluacion().equals(Evaluacion.PRIMER_PARCIAL) &&
	            notas.get(i).getValor() >= 4 && notas.get(i).getValor() <= 6) {
	            primerParcialEncontrado = true;
	        }
	        if (notas.get(i).getEvaluacion().equals(Evaluacion.SEGUNDO_PARCIAL) &&
	            notas.get(i).getValor() >= 4 && notas.get(i).getValor() <= 6) {
	            segundoParcialEncontrado = true;
	        }
	    }

	    if (primerParcialEncontrado && segundoParcialEncontrado) {
	        alumno.setMateriasAFinal(curso.getMateria());
	        return true;
	    }

	    return false;
	}

	public Boolean recursa() {

		if (!debeIrAFinal() && !promocionaMateria() ) {
			return true;
		}
		return false;

	}
	
	public Boolean apruebaFinal() {
		if(debeIrAFinal() && buscarNota(Evaluacion.FINAL)!=null && buscarNota(Evaluacion.FINAL).getValor()>=4) {
			
			return true;
		}
		return false;
		
	}

	public Boolean aproboCorrelativas() {
		ArrayList<Integer> correlativasRequeridas = curso.getMateria().getCorrelativas();

		if (correlativasRequeridas == null) {
			return true; // No hay correlativas requeridas, por lo tanto, se considera aprobado
		}

		ArrayList<Materia> materiasAprobadasPorAlumno = alumno.getMateriasAprobadas();

		for (int i = 0; i < correlativasRequeridas.size(); i++) {
			Integer correlativaRequerida = correlativasRequeridas.get(i);
			boolean encontrada = false;

			for (int j = 0; j < materiasAprobadasPorAlumno.size(); j++) {
				Materia materiaAprobada = materiasAprobadasPorAlumno.get(j);
				if (materiaAprobada.getCodigoMateria().equals(correlativaRequerida)) {
					encontrada = true;
					break; // Salir del bucle interno si se encuentra la correlativa requerida
				}
			}

			if (!encontrada) {
				return false;
			}
		}

		return true; // Si todas las correlativas requeridas se encuentran, retornar true
	}

	public Boolean adeudaCorrelativas() {
		ArrayList<Integer> correlativasRequeridas = curso.getMateria().getCorrelativas();

		if (correlativasRequeridas == null) {
			return true; // No hay correlativas requeridas, por lo tanto, se considera aprobado
		}

		ArrayList<Materia> materiasAdeudaAlumno = alumno.getMateriasAFinal();

		for (int i = 0; i < correlativasRequeridas.size(); i++) {
			Integer correlativaRequerida = correlativasRequeridas.get(i);
			boolean encontrada = false;

			for (int j = 0; j < materiasAdeudaAlumno.size(); j++) {
				Materia materiasAdeuda = materiasAdeudaAlumno.get(j);
				if (materiasAdeuda.getCodigoMateria().equals(correlativaRequerida)) {
					encontrada = true;
					break; // Salir del bucle interno si se encuentra la correlativa requerida
				}
			}

			if (!encontrada) {
				return false;
			}
		}

		return true; // Si todas las correlativas requeridas se encuentran, retornar true
	}

	
	public Boolean inscripcionDentroDeFecha() {

		if (curso.getCicloElectivo().getFechaInicioInscripcion().compareTo(alumno.getFechaIngreso()) < 0
				&& curso.getCicloElectivo().getFechaFinalizacionInscripcion().compareTo(alumno.getFechaIngreso()) > 0) {
			return true;
		}
		return false;
	}
}
