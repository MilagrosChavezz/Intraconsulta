package ar.edu.unlam.test;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Test;

import ar.edu.unlam.interfaz.AsignacionProfeACurso;
import ar.edu.unlam.interfaz.Aula;
import ar.edu.unlam.interfaz.CicloElectivo;
import ar.edu.unlam.interfaz.Cuatrimestre;
import ar.edu.unlam.interfaz.Cursada;
import ar.edu.unlam.interfaz.Dia;
import ar.edu.unlam.interfaz.Evaluacion;
import ar.edu.unlam.interfaz.Horario;
import ar.edu.unlam.interfaz.Materia;
import ar.edu.unlam.interfaz.Nota;
import ar.edu.unlam.interfaz.Profesor;
import ar.edu.unlam.interfaz.Universidad;
import ar.edu.unlam.interfaz.Alumno;
import ar.edu.unlam.interfaz.AsignacionAlumnoACurso;

public class UniversidadTest {

	@Test
	public void pruebaParaQueSePuedaAgregarUnAulaAlaUniversidad() {

		String nombreUniversidad = "Unlam";
		Integer numeroAula = 404, capacidadMaximaAlumnos = 100;

		Universidad unlam = new Universidad(nombreUniversidad);
		Aula aula = new Aula(numeroAula, capacidadMaximaAlumnos);

		Boolean resultado = unlam.agregarAula(aula);

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueSePuedaBuscarUnAulaAlaUniversidad() {

		String nombreUniversidad = "Unlam";
		Integer numeroAula = 404, capacidadMaximaAlumnos = 100;

		Universidad unlam = new Universidad(nombreUniversidad);
		Aula aula = new Aula(numeroAula, capacidadMaximaAlumnos);

		unlam.agregarAula(aula);
		Aula resultado = unlam.buscarAula(numeroAula);

		assertNotNull(resultado);
	}

	@Test
	public void pruebaParaQueSePuedaAgregarUnCursoAlaUniversidad() {

		String nombreUniversidad = "Unlam", nombreDeMateria = "pb2";
		Integer codigoMateria = 1918, comision = 64, cupoMaximoAlumnos = 35;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);

		boolean resultado = unlam.agregarCurso(cursada);

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueNoSePuedaAgregarUnCursoAlaUniversidadSiEsLaMismaCursada() {

		String nombreUniversidad = "Unlam", nombreDeMateria = "pb2";
		Integer codigoMateria = 1918, comision = 64, cupoMaximoAlumnos = 35;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		Cursada cursada2 = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);

		unlam.agregarCurso(cursada);
		Boolean resultado = unlam.agregarCurso(cursada2);

		assertFalse(resultado);
	}

	@Test
	public void pruebaParaQueSePuedaAgregarUnAlumnoAlaUniversidad() {

		String nombreUniversidad = "Unlam", nombreAlumno = "Javier", apellidoAlumno = "Perez";
		Integer dniAlumno = 7896;
		LocalDate fechaIngreso = LocalDate.of(2023, Month.MARCH, 27);
		LocalDate fechaNacimineto = LocalDate.of(2004, Month.MAY, 26);

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dniAlumno, apellidoAlumno, nombreAlumno, fechaIngreso, fechaNacimineto);

		Boolean resultado = unlam.agregarAlumno(alumno);

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueNoSePuedaAgregarUnAlumnoSiYaEstaAgregadoAlaUniversidad() {

		String nombreUniversidad = "Unlam", nombreAlumno = "Javier", apellidoAlumno = "Perez";
		Integer dniAlumno = 7896;
		LocalDate fechaIngreso = LocalDate.of(2023, Month.MARCH, 27);
		LocalDate fechaNacimineto = LocalDate.of(2004, Month.MAY, 26);

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dniAlumno, apellidoAlumno, nombreAlumno, fechaIngreso, fechaNacimineto);
		Alumno Otroalumno = new Alumno(dniAlumno, apellidoAlumno, nombreAlumno, fechaIngreso, fechaNacimineto);

		unlam.agregarAlumno(alumno);
		Boolean resultado = unlam.agregarAlumno(Otroalumno);

		assertFalse(resultado);
	}

	@Test
	public void pruebaParaQueSePuedaBuscarUnAlumnoPorSuDniEnlaUniversidad() {

		String nombreUniversidad = "Unlam", nombreAlumno = "Javier", apellidoAlumno = "Perez";
		Integer dniAlumno = 7896;
		LocalDate fechaIngreso = LocalDate.of(2023, Month.MARCH, 27);
		LocalDate fechaNacimineto = LocalDate.of(2004, Month.MAY, 26);

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dniAlumno, apellidoAlumno, nombreAlumno, fechaIngreso, fechaNacimineto);

		unlam.agregarAlumno(alumno);
		Alumno resultado = unlam.buscarAlumno(dniAlumno);

		assertNotNull(resultado);
	}

	@Test
	public void pruebaParaQueSePuedaIngresarUnProfesorAlaUniversidad() {

		String nombreUniversidad = "Unlam", nombreProfesor = "Javier", apellidoProfesor = "Perez";
		Integer CodigoProfesor = 7896;

		Universidad unlam = new Universidad(nombreUniversidad);
		Profesor profesor = new Profesor(nombreProfesor, apellidoProfesor, CodigoProfesor);

		Boolean resultado = unlam.ingresarProfesorALaUniversidad(profesor);

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueNoSePuedaIngresarUnProfesorAlaUniversidadSiYaEstaIngresado() {

		String nombreUniversidad = "Unlam", nombreProfesor = "Javier", apellidoProfesor = "Perez";
		Integer CodigoProfesor = 7896;

		Universidad unlam = new Universidad(nombreUniversidad);
		Profesor profesor = new Profesor(nombreProfesor, apellidoProfesor, CodigoProfesor);
		Profesor Otroprofesor = new Profesor(nombreProfesor, apellidoProfesor, CodigoProfesor);

		unlam.ingresarProfesorALaUniversidad(profesor);
		Boolean resultado = unlam.ingresarProfesorALaUniversidad(Otroprofesor);

		assertFalse(resultado);
	}

	@Test
	public void pruebaParaQueSePuedaIngresarUnaMateriaAlaUniversidad() {

		String nombreUniversidad = "Unlam", nombreDeMateria = "pb2";
		Integer CodigoMateria = 7896;

		Universidad unlam = new Universidad(nombreUniversidad);
		Materia materia = new Materia(nombreDeMateria, CodigoMateria, unlam);

		Boolean resultado = unlam.agregarMateria(materia);

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueNoSePuedaIngresarUnaMateriaAlaUniversidadYaEstaIngresada() {

		String nombreUniversidad = "Unlam", nombreDeMateria = "pb2";
		Integer CodigoMateria = 7896;

		Universidad unlam = new Universidad(nombreUniversidad);
		Materia materia = new Materia(nombreDeMateria, CodigoMateria, unlam);
		Materia OtraMateria = new Materia(nombreDeMateria, CodigoMateria, unlam);

		unlam.agregarMateria(materia);
		Boolean resultado = unlam.agregarMateria(OtraMateria);

		assertFalse(resultado);
	}

	@Test
	public void pruebaParaQueSePuedaBuscarUnaMateriaPorSuCodigoEnlaUniversidad() {

		String nombreUniversidad = "Unlam", nombreDeMateria = "pb2";
		Integer CodigoMateria = 7896;

		Universidad unlam = new Universidad(nombreUniversidad);
		Materia materia = new Materia(nombreDeMateria, CodigoMateria, unlam);

		unlam.agregarMateria(materia);
		Materia resultado = unlam.buscarMateria(CodigoMateria);

		assertNotNull(resultado);
	}

	@Test
	public void pruebaParaQueSePuedaAgregarUnCicloElectivoAlaUniversidad() {

		String nombreUniversidad = "Unlam";
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);

		Boolean resultado = unlam.agregarCicloElectivo(cicloElectivo);

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaVerSiLosCicloElectivosTienenLaMismaFecha() {

		String nombreUniversidad = "Unlam";
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		CicloElectivo otroCicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);

		unlam.agregarCicloElectivo(cicloElectivo);
		unlam.agregarCicloElectivo(otroCicloElectivo);
		Boolean resultado = unlam.existeCicloElectivoConLaMismaFecha(otroCicloElectivo);

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueNoSePuedaAgregarUnCicloElectivoAlaUniversidadConLaMismaFechaYid() {

		String nombreUniversidad = "Unlam";
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		CicloElectivo otroCicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);

		unlam.agregarCicloElectivo(cicloElectivo);
		Boolean resultado = unlam.agregarCicloElectivo(otroCicloElectivo);

		assertFalse(resultado);
	}

	@Test
	public void pruebaParaQueSePuedaAgregarUnaCorrelativa() {

		String nombreUniversidad = "Unlam", nombreDeMateria = "pb2", nombreDeMateriaCorrelativa = "pbw";
		Integer CodigoMateria = 7896, CodigoMateriaCorrelativa = 7897;

		Universidad unlam = new Universidad(nombreUniversidad);
		Materia materia = new Materia(nombreDeMateria, CodigoMateria, unlam);
		Materia materiaCorrelativa = new Materia(nombreDeMateriaCorrelativa, CodigoMateriaCorrelativa, unlam);
		unlam.agregarMateria(materia);
		unlam.agregarMateria(materiaCorrelativa);
		Boolean resultado = unlam.agregarCorrelatividad(CodigoMateria, CodigoMateriaCorrelativa);

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueSePuedaEliminarUnaCorrelativa() {

		String nombreUniversidad = "Unlam", nombreDeMateria = "pb2", nombreDeMateriaCorrelativa = "pbw";
		Integer CodigoMateria = 7896, CodigoMateriaCorrelativa = 7897;

		Universidad unlam = new Universidad(nombreUniversidad);
		Materia materia = new Materia(nombreDeMateria, CodigoMateria, unlam);
		Materia materiaCorrelativa = new Materia(nombreDeMateriaCorrelativa, CodigoMateriaCorrelativa, unlam);
		unlam.agregarMateria(materia);
		unlam.agregarMateria(materiaCorrelativa);
		unlam.agregarCorrelatividad(CodigoMateria, CodigoMateriaCorrelativa);
		Boolean resultado = unlam.eliminarCorrelatividad(CodigoMateria, CodigoMateriaCorrelativa);

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueSePuedaInscribirAlumnoACursada() {

		String nombreUniversidad = "Unlam", nombreAlumno = "Javier", apellidoAlumno = "Perez", nombreDeMateria = "pb2";
		Integer dniAlumno = 7896, codigoMateria = 1718, comision = 64, cupoMaximoAlumnos = 70;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaIngreso = LocalDate.of(2023, Month.MARCH, 27);
		LocalDate fechaNacimineto = LocalDate.of(2004, Month.MAY, 26);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dniAlumno, apellidoAlumno, nombreAlumno, fechaIngreso, fechaNacimineto);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		Integer idComision = cursada.getId();
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);
		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAsignacion(asignacion);

		Boolean resultado = unlam.inscribirAlumnoACursada(dniAlumno, idComision);

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueSePuedaInscribirMasDeUnAlumnoACursada() {

		String nombreUniversidad = "Unlam", nombreAlumno1 = "Javier", apellidoAlumno1 = "Perez",
				nombreAlumno2 = "Martin", apellidoAlumno2 = "Ramirez", nombreAlumno3 = "Pedro",
				apellidoAlumno3 = "Gonzales", nombreDeMateria = "pb2";
		Integer dniAlumno1 = 7896, dniAlumno2 = 7897, dniAlumno3 = 7898, codigoMateria = 1718, comision = 64,
				cupoMaximoAlumnos = 70, nroAula = 404, cantidadMaximaAlumnos = 100;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaIngreso = LocalDate.of(2023, Month.MARCH, 27);
		LocalDate fechaNacimineto = LocalDate.of(2004, Month.MAY, 26);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno1 = new Alumno(dniAlumno1, apellidoAlumno1, nombreAlumno1, fechaIngreso, fechaNacimineto);
		Alumno alumno2 = new Alumno(dniAlumno2, apellidoAlumno2, nombreAlumno2, fechaIngreso, fechaNacimineto);
		Alumno alumno3 = new Alumno(dniAlumno3, apellidoAlumno3, nombreAlumno3, fechaIngreso, fechaNacimineto);
		Aula aula = new Aula(nroAula, cantidadMaximaAlumnos);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		AsignacionAlumnoACurso asignacion1 = new AsignacionAlumnoACurso(cursada, alumno1);
		AsignacionAlumnoACurso asignacion2 = new AsignacionAlumnoACurso(cursada, alumno2);
		AsignacionAlumnoACurso asignacion3 = new AsignacionAlumnoACurso(cursada, alumno3);
		Integer idComision = cursada.getId();

		unlam.agregarAlumno(alumno1);
		unlam.agregarAlumno(alumno2);
		unlam.agregarAlumno(alumno3);
		unlam.agregarAula(aula);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		cursada.AgregarAula(aula);
		unlam.agregarAsignacion(asignacion1);
		unlam.agregarAsignacion(asignacion2);
		unlam.agregarAsignacion(asignacion3);
		unlam.inscribirAlumnoACursada(dniAlumno1, idComision);
		unlam.inscribirAlumnoACursada(dniAlumno2, idComision);
		unlam.inscribirAlumnoACursada(dniAlumno3, idComision);

		Integer valor = cursada.cantidadAlumnosAnotados();
		Integer valorEsperado = 3;

		assertEquals(valorEsperado, valor);
	}

	@Test
	public void pruebaParaQueSePuedaBuscarUnaCursada() {

		String nombreUniversidad = "Unlam", nombreAlumno = "Javier", apellidoAlumno = "Perez", nombreDeMateria = "pb2";
		Integer dniAlumno = 7896, codigoMateria = 1718, comision = 64, cupoMaximoAlumnos = 70;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaIngreso = LocalDate.of(2023, Month.MARCH, 27);
		LocalDate fechaNacimineto = LocalDate.of(2004, Month.MAY, 26);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dniAlumno, apellidoAlumno, nombreAlumno, fechaIngreso, fechaNacimineto);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		Integer idComision = cursada.getId();
		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		Cursada resultado = unlam.BuscarCursada(idComision);
		assertNotNull(resultado);
	}

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

		Integer idProfesor = Profesor.getId();
		Universidad unlam = new Universidad(nombreUniversidad);
		Profesor profesor = new Profesor(nombreProfesor, apellidoProfesor, idProfesor);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		Integer idComision = cursada.getId();
		unlam.ingresarProfesorALaUniversidad(profesor);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);

		Boolean resultado = unlam.asignarProfesorAlaComision(idComision, idProfesor);

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueSePuedaBuscarUnaAsignacionAlumno() {

		String nombreUniversidad = "Unlam", nombreAlumno = "Javier", apellidoAlumno = "Perez", nombreDeMateria = "pb2";
		Integer dniAlumno = 7896, codigoMateria = 1718, comision = 64, cupoMaximoAlumnos = 70;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaIngreso = LocalDate.of(2023, Month.MARCH, 27);
		LocalDate fechaNacimineto = LocalDate.of(2004, Month.MAY, 26);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dniAlumno, apellidoAlumno, nombreAlumno, fechaIngreso, fechaNacimineto);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);
		Integer idComision = cursada.getId();
		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAsignacion(asignacion);
		AsignacionAlumnoACurso resultado = unlam.buscarAsignacion(idComision, dniAlumno);
		assertNotNull(resultado);
	}

	@Test
	public void pruebaParaQueSePuedaRegistrarUnaNota() {

		String nombreUniversidad = "Unlam", nombreAlumno = "Javier", apellidoAlumno = "Perez", nombreDeMateria = "pb2";
		Integer dniAlumno = 7896, codigoMateria = 1718, comision = 64, cupoMaximoAlumnos = 70, valorNota = 10,
				nroAula = 404, cantidadMaximaAlumnos = 100;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		Evaluacion evaluacion = Evaluacion.PRIMER_PARCIAL;
		LocalDate fechaIngreso = LocalDate.of(2023, Month.MARCH, 27);
		LocalDate fechaNacimineto = LocalDate.of(2004, Month.MAY, 26);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dniAlumno, apellidoAlumno, nombreAlumno, fechaIngreso, fechaNacimineto);
		Aula aula = new Aula(nroAula, cantidadMaximaAlumnos);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		Nota nota = new Nota(valorNota, evaluacion);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);
		Integer idComision = cursada.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarAula(aula);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		cursada.AgregarAula(aula);
		unlam.agregarAsignacion(asignacion);
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);

		Boolean resultado = unlam.registrarNota(idComision, dniAlumno, nota);

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueSePuedaObtenerLasMateriasAprobadasDeUnAlumno() {

		String nombreUniversidad = "Unlam", nombreAlumno = "Javier", apellidoAlumno = "Perez", nombreDeMateria = "pb2";
		Integer dniAlumno = 7896, codigoMateria = 1718, comision = 64, cupoMaximoAlumnos = 70, valorNota = 10;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		Evaluacion evaluacion1 = Evaluacion.PRIMER_PARCIAL;
		Evaluacion evaluacion2 = Evaluacion.SEGUNDO_PARCIAL;
		LocalDate fechaIngreso = LocalDate.of(2023, Month.MARCH, 27);
		LocalDate fechaNacimineto = LocalDate.of(2004, Month.MAY, 26);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dniAlumno, apellidoAlumno, nombreAlumno, fechaIngreso, fechaNacimineto);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		Nota nota1 = new Nota(valorNota, evaluacion1);
		Nota nota2 = new Nota(valorNota, evaluacion2);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);
		Integer idComision = cursada.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAsignacion(asignacion);
		unlam.registrarNota(idComision, dniAlumno, nota1);
		unlam.registrarNota(idComision, dniAlumno, nota2);
		ArrayList<Materia> materiasAprobadas = unlam.materiasAprobadas(dniAlumno);

		assertNotNull(materiasAprobadas);
	}

	@Test
	public void pruebaParaQueSePuedaObtenerNotaFinalDeUnAlumno() {

		String nombreUniversidad = "Unlam", nombreAlumno = "Javier", apellidoAlumno = "Perez", nombreDeMateria = "pb2";
		Integer dniAlumno = 7896, codigoMateria = 1718, comision = 64, cupoMaximoAlumnos = 70, valorNota = 10,
				nroAula = 404, cantidadMaximaAlumnos = 100;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		Evaluacion evaluacion1 = Evaluacion.PRIMER_PARCIAL;
		Evaluacion evaluacion2 = Evaluacion.SEGUNDO_PARCIAL;
		LocalDate fechaIngreso = LocalDate.of(2023, Month.MARCH, 27);
		LocalDate fechaNacimineto = LocalDate.of(2004, Month.MAY, 26);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dniAlumno, apellidoAlumno, nombreAlumno, fechaIngreso, fechaNacimineto);
		Aula aula = new Aula(nroAula, cantidadMaximaAlumnos);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		Nota nota1 = new Nota(valorNota, evaluacion1);
		Nota nota2 = new Nota(valorNota, evaluacion2);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);
		Integer idComision = cursada.getId();
		Integer idMateria = materia.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarAula(aula);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		cursada.AgregarAula(aula);
		unlam.agregarAsignacion(asignacion);
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);

		unlam.registrarNota(idComision, dniAlumno, nota1);
		unlam.registrarNota(idComision, dniAlumno, nota2);

		Integer resultado = unlam.obtenerNota(dniAlumno, idMateria, idComision);
		Integer resultadoEsperado = 10;

		assertEquals(resultadoEsperado, resultado);
	}

	@Test
	public void pruebaParaQueSePuedaObtenerLaCantidadDeAlumnosPromocionados() {

		String nombreUniversidad = "Unlam", nombreAlumno = "Javier", apellidoAlumno = "Perez", nombreDeMateria = "pb2";
		Integer dniAlumno = 7896, codigoMateria = 1718, comision = 64, cupoMaximoAlumnos = 70, valorNota = 10,
				nroAula = 404, cantidadMaximaAlumnos = 100;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		Evaluacion evaluacion1 = Evaluacion.PRIMER_PARCIAL;
		Evaluacion evaluacion2 = Evaluacion.SEGUNDO_PARCIAL;
		LocalDate fechaIngreso = LocalDate.of(2023, Month.MARCH, 27);
		LocalDate fechaNacimineto = LocalDate.of(2004, Month.MAY, 26);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dniAlumno, apellidoAlumno, nombreAlumno, fechaIngreso, fechaNacimineto);
		Alumno alumno2 = new Alumno(123,"Llombart", "kevin", fechaIngreso, fechaNacimineto);
		Aula aula = new Aula(nroAula, cantidadMaximaAlumnos);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		Nota nota1 = new Nota(valorNota, evaluacion1);
		Nota nota2 = new Nota(valorNota, evaluacion2);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);
		AsignacionAlumnoACurso asignacion2 = new AsignacionAlumnoACurso(cursada, alumno2);
		Integer idComision = cursada.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarAula(aula);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		cursada.AgregarAula(aula);
		unlam.agregarAsignacion(asignacion);
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		unlam.registrarNota(idComision, dniAlumno, nota1);
		unlam.registrarNota(idComision, dniAlumno, nota2);
		
		unlam.agregarAlumno(alumno2);
		unlam.agregarAsignacion(asignacion2);
		unlam.inscribirAlumnoACursada(123, idComision);
		unlam.registrarNota(idComision, 123, nota1);
		unlam.registrarNota(idComision, 123, nota2);
		
		
		


		Integer resultado = unlam.cantidadAlumnosPromocionados(idComision);
		Integer resultadoEsperado = 2;

		assertEquals(resultadoEsperado, resultado);


	}
	
	@Test
	public void pruebaParaQueSePuedaObtenerLaCantidadDeAlumnosAFinal() {

		String nombreUniversidad = "Unlam", nombreAlumno = "Javier", apellidoAlumno = "Perez", nombreDeMateria = "pb2";
		Integer dniAlumno = 7896, codigoMateria = 1718, comision = 64, cupoMaximoAlumnos = 6, valorNota = 5,
				nroAula = 404, cantidadMaximaAlumnos = 100;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		Evaluacion evaluacion1 = Evaluacion.PRIMER_PARCIAL;
		Evaluacion evaluacion2 = Evaluacion.SEGUNDO_PARCIAL;
		LocalDate fechaIngreso = LocalDate.of(2023, Month.MARCH, 27);
		LocalDate fechaNacimineto = LocalDate.of(2004, Month.MAY, 26);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dniAlumno, apellidoAlumno, nombreAlumno, fechaIngreso, fechaNacimineto);
		Alumno alumno2 = new Alumno(123,"Llombart", "kevin", fechaIngreso, fechaNacimineto);
		Aula aula = new Aula(nroAula, cantidadMaximaAlumnos);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		Nota nota1 = new Nota(valorNota, evaluacion1);
		Nota nota2 = new Nota(valorNota, evaluacion2);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);
		AsignacionAlumnoACurso asignacion2 = new AsignacionAlumnoACurso(cursada, alumno2);
		Integer idComision = cursada.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarAula(aula);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		cursada.AgregarAula(aula);
		unlam.agregarAsignacion(asignacion);
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		unlam.registrarNota(idComision, dniAlumno, nota1);
		unlam.registrarNota(idComision, dniAlumno, nota2);
		
		unlam.agregarAlumno(alumno2);
		unlam.agregarAsignacion(asignacion2);
		unlam.inscribirAlumnoACursada(123, idComision);
		unlam.registrarNota(idComision, 123, nota1);
		unlam.registrarNota(idComision, 123, nota2);
		;
		
		


		Integer resultado = unlam.cantidadAlumnosAFinal( idComision);
		Integer resultadoEsperado = 2;

		assertEquals(resultadoEsperado, resultado);


	}
	
	@Test
	public void pruebaParaQueSePuedaObtenerLaCantidadDeAlumnosDesaprobados() {

		String nombreUniversidad = "Unlam", nombreAlumno = "Javier", apellidoAlumno = "Perez", nombreDeMateria = "pb2";
		Integer dniAlumno = 7896, codigoMateria = 1718, comision = 64, cupoMaximoAlumnos = 6, valorNota = 1,
				nroAula = 404, cantidadMaximaAlumnos = 100;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		Evaluacion evaluacion1 = Evaluacion.PRIMER_PARCIAL;
		Evaluacion evaluacion2 = Evaluacion.SEGUNDO_PARCIAL;
		LocalDate fechaIngreso = LocalDate.of(2023, Month.MARCH, 27);
		LocalDate fechaNacimineto = LocalDate.of(2004, Month.MAY, 26);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dniAlumno, apellidoAlumno, nombreAlumno, fechaIngreso, fechaNacimineto);
		Alumno alumno2 = new Alumno(123,"Llombart", "kevin", fechaIngreso, fechaNacimineto);
		Aula aula = new Aula(nroAula, cantidadMaximaAlumnos);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		Nota nota1 = new Nota(valorNota, evaluacion1);
		Nota nota2 = new Nota(valorNota, evaluacion2);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);
		AsignacionAlumnoACurso asignacion2 = new AsignacionAlumnoACurso(cursada, alumno2);
		Integer idComision = cursada.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarAula(aula);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		cursada.AgregarAula(aula);
		unlam.agregarAsignacion(asignacion);
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		unlam.registrarNota(idComision, dniAlumno, nota1);
		unlam.registrarNota(idComision, dniAlumno, nota2);
		
		unlam.agregarAlumno(alumno2);
		unlam.agregarAsignacion(asignacion2);
		unlam.inscribirAlumnoACursada(123, idComision);
		unlam.registrarNota(idComision, 123, nota1);
		unlam.registrarNota(idComision, 123, nota2);
		
		
		Integer resultado = unlam.cantidadAlumnosReprobados( idComision);
		Integer resultadoEsperado = 2;

		assertEquals(resultadoEsperado, resultado);


	}
}