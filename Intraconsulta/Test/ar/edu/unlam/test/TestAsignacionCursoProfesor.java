package ar.edu.unlam.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import ar.edu.unlam.interfaz.AsignacionProfeACurso;
import ar.edu.unlam.interfaz.CicloElectivo;
import ar.edu.unlam.interfaz.Cuatrimestre;
import ar.edu.unlam.interfaz.Cursada;
import ar.edu.unlam.interfaz.Dia;
import ar.edu.unlam.interfaz.Horario;
import ar.edu.unlam.interfaz.Materia;
import ar.edu.unlam.interfaz.Profesor;
import ar.edu.unlam.interfaz.Universidad;

public class TestAsignacionCursoProfesor {

	@Test
	public void pruebaParaQueSePuedaAsignarProfesorAComision() {

		String nombreUniversidad = "Unlam", nombreProfesor = "Javier", apellidoProfesor = "Perez",
				nombreDeMateria = "pb2";
		Integer codigoMateria = 1718, comision = 64, cupoMaximoAlumnos = 70;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		Profesor profesor = new Profesor(nombreProfesor, apellidoProfesor, 123);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		Integer idComision = cursada.getId();

		unlam.ingresarProfesorALaUniversidad(profesor);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);

		Boolean resultado = unlam.asignarProfesorAlaComision(idComision, profesor.getCodigoProfesor());

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaUnProfesorEsteDisponible() {

		String nombreUniversidad = "Unlam", nombreProfesor = "Javier", apellidoProfesor = "Perez",
				nombreDeMateria = "pb2";
		Integer codigoMateria = 1718, comision = 64, cupoMaximoAlumnos = 70;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		Profesor profesor = new Profesor(nombreProfesor, apellidoProfesor, 123);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		AsignacionProfeACurso asignacion = new AsignacionProfeACurso(profesor, cursada);
		Integer idComision = cursada.getId();
		Integer idProfesor = profesor.getId();

		unlam.ingresarProfesorALaUniversidad(profesor);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.asignarProfesorAlaComision(idComision, idProfesor);
		Boolean resultado = asignacion.estaDisponible();

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaUnProfesorNoSePuedaAsignarAUnaCursadaPorQueTieneLosMismosDiasYHorarios() {

		String nombreUniversidad = "Unlam", nombreProfesor = "Javier", apellidoProfesor = "Perez",
				nombreDeMateria = "pb2";
		Integer codigoMateria = 1718, comision = 64, cupoMaximoAlumnos = 70, codigoProfesor = 123;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		Profesor profesor = new Profesor(nombreProfesor, apellidoProfesor, codigoProfesor);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		Cursada otraCursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		AsignacionProfeACurso asignacion = new AsignacionProfeACurso(profesor, cursada);

		unlam.ingresarProfesorALaUniversidad(profesor);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarCurso(otraCursada);
		unlam.asignarProfesorAlaComision(cursada.getId(), codigoProfesor);

		Boolean resultado = asignacion.estaDisponible();

		assertFalse(resultado);
	}
}