package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import ar.edu.unlam.interfaz.Alumno;
import ar.edu.unlam.interfaz.AsignacionAlumnoACurso;
import ar.edu.unlam.interfaz.AsignacionProfeACurso;
import ar.edu.unlam.interfaz.Aula;
import ar.edu.unlam.interfaz.CicloElectivo;
import ar.edu.unlam.interfaz.Cuatrimestre;
import ar.edu.unlam.interfaz.Cursada;
import ar.edu.unlam.interfaz.Dia;
import ar.edu.unlam.interfaz.Horario;
import ar.edu.unlam.interfaz.Materia;
import ar.edu.unlam.interfaz.Profesor;
import ar.edu.unlam.interfaz.Universidad;

public class CursadaTest {

	@Test
	public void pruebaParaQueUnProfesorEsteDisponibleYPuedaSerAsignadoACurso() {

		String nombre = "Martin", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigo = 1225, idAsignacionDeCursada = 1415, codigoMateria = 1918, comision = 64, numeroAula = 404,
				cupoMaximoAlumnos = 35;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Profesor profesor = new Profesor(nombre, codigo);
		Materia materia = new Materia(nombreDeMateria, codigoMateria);
		Aula aula = new Aula(numeroAula, cupoMaximoAlumnos);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, aula, cicloElectivo, cupoMaximoAlumnos);
		Universidad unlam = new Universidad(nombreUniversidad);
		AsignacionProfeACurso nuevaAsignacion = new AsignacionProfeACurso(profesor, cursada, idAsignacionDeCursada,
				unlam);

		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		unlam.ingresarProfesorALaUniversidad(profesor);

		Boolean resultado = nuevaAsignacion.asignarProfesorACurso(profesor, cursada);

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueUnProfesorNoEsteDisponibleNoPuedaAsignarseleUnaCursada() {
		String nombre = "Martin", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigo = 1225, idAsignacionDeCursada = 1415, codigoMateria = 1918, comision = 64, numeroAula = 404,
				cupoMaximoAlumnos = 35;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Profesor profesor = new Profesor(nombre, codigo);
		Materia materia = new Materia(nombreDeMateria, codigoMateria);
		Aula aula = new Aula(numeroAula, cupoMaximoAlumnos);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, aula, cicloElectivo, cupoMaximoAlumnos);
		Universidad unlam = new Universidad(nombreUniversidad);
		AsignacionProfeACurso nuevaAsignacion = new AsignacionProfeACurso(profesor, cursada, idAsignacionDeCursada,
				unlam);

		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		unlam.ingresarProfesorALaUniversidad(profesor);

		nuevaAsignacion.asignarProfesorACurso(profesor, cursada);

		nuevaAsignacion.asignarProfesorACurso(profesor, cursada);

		String nombreDeMateria2 = "pb2";
		Integer codigoMateria2 = 1918;
		Integer comision2 = 457;
		Integer idAsignacionDeCursada2 = 145;
		Integer numeroAula2 = 89;
		Horario horarios2 = Horario.Mañana;
		Dia dias2 = Dia.Miercoles;

		Integer cupoMaximoAlumnos2 = 10;

		cursada.setCantidadAlumnosAnotados(5);

		Materia materia2 = new Materia(nombreDeMateria2, codigoMateria2);
		Aula aula2 = new Aula(numeroAula2, cupoMaximoAlumnos2);
		CicloElectivo cicloElectivo2 = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada2 = new Cursada(materia2, comision2, horarios2, dias2, aula2, cicloElectivo2,
				cupoMaximoAlumnos2);

		unlam.agregarMateria(materia2);
		unlam.agregarCurso(cursada2);
		unlam.agregarAula(aula2);

		AsignacionProfeACurso nuevaAsignacion2 = new AsignacionProfeACurso(profesor, cursada2, idAsignacionDeCursada2,
				unlam);

		Boolean resultado = nuevaAsignacion2.asignarProfesorACurso(profesor, cursada2);

		assertFalse(resultado);
	}

	@Test
	public void pruebaParaQueNoSePuedaAsignarUnAulaSiLaCapacidadDeLaMismaEsMenorQueElCupoDeAlumnos() {
		String nombre = "Martin", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigo = 1225, idAsignacionDeCursada = 1415, codigoMateria = 1918, comision = 64, numeroAula = 404,
				cupoMaximoAlumnos = 55, capacidadMaximaAulas = 40;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Profesor profesor = new Profesor(nombre, codigo);
		Materia materia = new Materia(nombreDeMateria, codigoMateria);
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cicloElectivo, cupoMaximoAlumnos);
		Universidad unlam = new Universidad(nombreUniversidad);
		AsignacionProfeACurso nuevaAsignacion = new AsignacionProfeACurso(profesor, cursada, idAsignacionDeCursada,
				unlam);

		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		unlam.ingresarProfesorALaUniversidad(profesor);

		nuevaAsignacion.asignarProfesorACurso(profesor, cursada);

		cursada.AgregarAula(aula);

		Aula seLeAsignoAula = cursada.getAula();

		assertNull(seLeAsignoAula);
	}

	@Test
	public void pruebaParaQueUnProfesorNoSePuedaAsignarAUnaCursadaSiNOSeCumpleLaRegla20ProfesPorAlumno() {
		String nombre = "Martin", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigo = 1225, idAsignacionDeCursada = 1415, codigoMateria = 1918, comision = 64, numeroAula = 404,
				cupoMaximoAlumnos = 100, capacidadMaximaAulas = 100;
		;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Profesor profesor = new Profesor(nombre, codigo);
		Materia materia = new Materia(nombreDeMateria, codigoMateria);
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, aula, cicloElectivo, cupoMaximoAlumnos);
		Universidad unlam = new Universidad(nombreUniversidad);
		AsignacionProfeACurso nuevaAsignacion = new AsignacionProfeACurso(profesor, cursada, idAsignacionDeCursada,
				unlam);
		cursada.setCantidadAlumnosAnotados(10);
		nuevaAsignacion.asignarProfesorACurso(profesor, cursada);

		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		unlam.ingresarProfesorALaUniversidad(profesor);

		Profesor profesor2 = new Profesor("PAblo", 23);
		unlam.ingresarProfesorALaUniversidad(profesor2);

		AsignacionProfeACurso nuevaAsignacion2 = new AsignacionProfeACurso(profesor2, cursada, 7, unlam);
		Boolean seAsignaProfesor2 = nuevaAsignacion2.asignarProfesorACurso(profesor2, cursada);

		assertFalse(seAsignaProfesor2);
	}

	@Test
	public void pruebaParaQueSePuedaBuscarUnAlumnoPorSuDNI() {
		String nombre = "Martin", apellido = "Perez", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigoMateria = 1918, comision = 64, numeroAula = 404, cupoMaximoAlumnos = 100,
				capacidadMaximaAulas = 100, dni = 45369851;

		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaIngreso = LocalDate.of(2023, Month.MARCH, 27);
		LocalDate fechaNacimineto = LocalDate.of(2004, Month.MAY, 26);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);

		Alumno alumno = new Alumno(dni, apellido, nombre, fechaIngreso, fechaNacimineto);
		Materia materia = new Materia(nombreDeMateria, codigoMateria);
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, aula, cicloElectivo, cupoMaximoAlumnos);
		Universidad unlam = new Universidad(nombreUniversidad);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(cupoMaximoAlumnos, cursada, alumno, unlam);

		unlam.agregarAlumno(alumno);
		unlam.agregarCurso(cursada);
		asignacion.inscribirAlumno(alumno, cursada);

		Integer dniAlumno = alumno.getDni();

		assertNotNull(cursada.buscarAlumnoPorDni(dniAlumno));
	}
}