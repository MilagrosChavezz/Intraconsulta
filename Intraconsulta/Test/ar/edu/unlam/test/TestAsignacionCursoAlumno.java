package ar.edu.unlam.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import ar.edu.unlam.interfaz.Alumno;
import ar.edu.unlam.interfaz.AsignacionAlumnoACurso;
import ar.edu.unlam.interfaz.Aula;
import ar.edu.unlam.interfaz.CicloElectivo;
import ar.edu.unlam.interfaz.Cuatrimestre;
import ar.edu.unlam.interfaz.Cursada;
import ar.edu.unlam.interfaz.Dia;
import ar.edu.unlam.interfaz.Evaluacion;
import ar.edu.unlam.interfaz.Horario;
import ar.edu.unlam.interfaz.Materia;
import ar.edu.unlam.interfaz.Nota;
import ar.edu.unlam.interfaz.Universidad;

public class TestAsignacionCursoAlumno {

	@Test
	public void pruebaParaQueSeApruebePrimerParcial() {

		String nombreAlumno = "Martin", apellidoAlumno = "Suarez", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigoMateria = 1918, comision = 64, numeroAula = 404, cupoMaximoAlumnos = 55,
				capacidadMaximaAulas = 80, dniAlumno = 45868259, notaPrimerparcial = 10;
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
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		Nota notaDelPrimerParcial = new Nota(notaPrimerparcial, Evaluacion.PRIMER_PARCIAL);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);
		Integer idComision = cursada.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		unlam.agregarAsignacion(asignacion);
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		unlam.registrarNota(idComision, dniAlumno, notaDelPrimerParcial);

		assertTrue(asignacion.apruebaPrimerParcial());
	}

	@Test
	public void pruebaParaQueSeApruebeASegundoParcial() {

		String nombreAlumno = "Martin", apellidoAlumno = "Suarez", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigoMateria = 1918, comision = 64, numeroAula = 404, cupoMaximoAlumnos = 55,
				capacidadMaximaAulas = 80, dniAlumno = 45868259, notaSegundoparcial = 10;
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
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		Nota notaDelSegundoParcial = new Nota(notaSegundoparcial, Evaluacion.SEGUNDO_PARCIAL);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);
		Integer idComision = cursada.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		unlam.agregarAsignacion(asignacion);
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		unlam.registrarNota(idComision, dniAlumno, notaDelSegundoParcial);

		assertTrue(asignacion.apruebaSegundoParcial());
	}

	@Test
	public void pruebaParaVerSiRecuperaPrimerParcial() {

		String nombreAlumno = "Martin", apellidoAlumno = "Suarez", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigoMateria = 1918, comision = 64, numeroAula = 404, cupoMaximoAlumnos = 55,
				capacidadMaximaAulas = 80, dniAlumno = 45868259, notaPrimerparcial = 3;
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
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		Nota notaDelPrimerParcial = new Nota(notaPrimerparcial, Evaluacion.SEGUNDO_PARCIAL);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);
		Integer idComision = cursada.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		unlam.agregarAsignacion(asignacion);
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		unlam.registrarNota(idComision, dniAlumno, notaDelPrimerParcial);

		assertTrue(asignacion.recuperaPrimerParcial());
	}

	@Test
	public void pruebaParaVerSiRecuperaSegundoParcial() {

		String nombreAlumno = "Martin", apellidoAlumno = "Suarez", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigoMateria = 1918, comision = 64, numeroAula = 404, cupoMaximoAlumnos = 55,
				capacidadMaximaAulas = 80, dniAlumno = 45868259, notaSegundoparcial = 3;
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
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		Nota notaDelSegundoParcial = new Nota(notaSegundoparcial, Evaluacion.SEGUNDO_PARCIAL);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);
		Integer idComision = cursada.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		unlam.agregarAsignacion(asignacion);
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		unlam.registrarNota(idComision, dniAlumno, notaDelSegundoParcial);

		assertTrue(asignacion.recuperaSegundoParcial());
	}

	@Test
	public void pruebaParaVerSiApruebaRecuperatorio() {

		String nombreAlumno = "Martin", apellidoAlumno = "Suarez", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigoMateria = 1918, comision = 64, numeroAula = 404, cupoMaximoAlumnos = 55,
				capacidadMaximaAulas = 80, dniAlumno = 45868259, notaSegundoparcial = 3, notaRecuperatorio = 10;
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
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		Nota notaDelSegundoParcial = new Nota(notaSegundoparcial, Evaluacion.SEGUNDO_PARCIAL);
		Nota notaDelRecuperatorio = new Nota(notaRecuperatorio, Evaluacion.RECUPERATORIO);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);
		Integer idComision = cursada.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		unlam.agregarAsignacion(asignacion);
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		unlam.registrarNota(idComision, dniAlumno, notaDelSegundoParcial);
		unlam.registrarNota(idComision, dniAlumno, notaDelRecuperatorio);

		assertTrue(asignacion.aprobarRecuperatorio());
	}

	@Test
	public void pruebaParaQueApruebeFinal() {

		String nombreAlumno = "Martin", apellidoAlumno = "Suarez", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigoMateria = 1918, comision = 64, numeroAula = 404, cupoMaximoAlumnos = 55,
				capacidadMaximaAulas = 80, dniAlumno = 45868259, notaPrimerparcial = 4, notaSegundoParcial = 4,
				notaRecuperatorio = 4, notaFinal = 4;
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
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);
		Nota notaDelPrimerParcial = new Nota(notaPrimerparcial, Evaluacion.PRIMER_PARCIAL);
		Nota notaDelSegundoParcial = new Nota(notaSegundoParcial, Evaluacion.SEGUNDO_PARCIAL);
		Nota notaDelRecuperatorio = new Nota(notaRecuperatorio, Evaluacion.RECUPERATORIO);
		Nota notaDelFinal = new Nota(notaFinal, Evaluacion.FINAL);
		Integer idComision = cursada.getId();
		Integer idAula = aula.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		unlam.agregarAsignacion(asignacion);
		unlam.asignarAulaAlaComision(idComision, idAula);
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		unlam.registrarNota(idComision, dniAlumno, notaDelPrimerParcial);
		unlam.registrarNota(idComision, dniAlumno, notaDelSegundoParcial);
		unlam.registrarNota(idComision, dniAlumno, notaDelRecuperatorio);
		unlam.registrarNota(idComision, dniAlumno, notaDelFinal);

		Boolean resultado = asignacion.apruebaFinal();

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueVayaAFinal() {

		String nombreAlumno = "Martin", apellidoAlumno = "Suarez", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigoMateria = 1918, comision = 64, numeroAula = 404, cupoMaximoAlumnos = 55,
				capacidadMaximaAulas = 80, dniAlumno = 45868259, notaPrimerparcial = 4, notaSegundoParcial = 4,
				notaRecuperatorio = 4;
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
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);
		Nota notaDelPrimerParcial = new Nota(notaPrimerparcial, Evaluacion.PRIMER_PARCIAL);
		Nota notaDelSegundoParcial = new Nota(notaSegundoParcial, Evaluacion.SEGUNDO_PARCIAL);
		Nota notaDelRecuperatorio = new Nota(notaRecuperatorio, Evaluacion.RECUPERATORIO);
		Integer idComision = cursada.getId();
		Integer idAula = aula.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		unlam.agregarAsignacion(asignacion);
		unlam.asignarAulaAlaComision(idComision, idAula);
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		unlam.registrarNota(idComision, dniAlumno, notaDelPrimerParcial);
		unlam.registrarNota(idComision, dniAlumno, notaDelSegundoParcial);
		unlam.registrarNota(idComision, dniAlumno, notaDelRecuperatorio);

		Boolean resultado = asignacion.debeIrAFinal();

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueRecurse() {

		String nombreAlumno = "Martin", apellidoAlumno = "Suarez", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigoMateria = 1918, comision = 64, numeroAula = 404, cupoMaximoAlumnos = 55,
				capacidadMaximaAulas = 80, dniAlumno = 45868259, notaPrimerparcial = 3, notaSegundoParcial = 3;
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
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);
		Nota notaDelPrimerParcial = new Nota(notaPrimerparcial, Evaluacion.PRIMER_PARCIAL);
		Nota notaDelSegundoParcial = new Nota(notaSegundoParcial, Evaluacion.SEGUNDO_PARCIAL);
		Integer idComision = cursada.getId();
		Integer idAula = aula.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		unlam.agregarAsignacion(asignacion);
		unlam.asignarAulaAlaComision(idComision, idAula);
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		unlam.registrarNota(idComision, dniAlumno, notaDelPrimerParcial);
		unlam.registrarNota(idComision, dniAlumno, notaDelSegundoParcial);

		Boolean resultado = asignacion.recursa();

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueLaInscripcionEsteDentroDeFecha() {

		String nombreAlumno = "Martin", apellidoAlumno = "Suarez", nombreDeMateria = "pb2",
				nombreDeMateriaCorrelativa = "pw", nombreUniversidad = "Unlam";
		Integer codigoMateria = 1918, codigoMateriaCorrelativa = 1919, comision = 64, numeroAula = 404,
				cupoMaximoAlumnos = 55, capacidadMaximaAulas = 80, dniAlumno = 45868259;

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
		Materia materiaCorrelativa = new Materia(nombreDeMateriaCorrelativa, codigoMateriaCorrelativa, unlam);
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);

		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarMateria(materiaCorrelativa);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);

		assertTrue(asignacion.inscripcionDentroDeFecha());
	}

	@Test
	public void pruebaParaQueLaInscripcionNoEsteDentroDeFecha() {

		String nombreAlumno = "Martin", apellidoAlumno = "Suarez", nombreDeMateria = "pb2",
				nombreDeMateriaCorrelativa = "pw", nombreUniversidad = "Unlam";
		Integer codigoMateria = 1918, codigoMateriaCorrelativa = 1919, comision = 64, numeroAula = 404,
				cupoMaximoAlumnos = 55, capacidadMaximaAulas = 80, dniAlumno = 45868259;

		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaIngreso = LocalDate.of(2023, Month.MARCH, 27);
		LocalDate fechaNacimineto = LocalDate.of(2004, Month.MAY, 26);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.APRIL, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.APRIL, 30);

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dniAlumno, apellidoAlumno, nombreAlumno, fechaIngreso, fechaNacimineto);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		Materia materiaCorrelativa = new Materia(nombreDeMateriaCorrelativa, codigoMateriaCorrelativa, unlam);
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cursada, alumno);

		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarMateria(materiaCorrelativa);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);

		assertFalse(asignacion.inscripcionDentroDeFecha());
	}
}	