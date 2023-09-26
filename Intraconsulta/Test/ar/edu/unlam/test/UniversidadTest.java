package ar.edu.unlam.test;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import org.junit.Test;
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
		Integer idAula = aula.getId();

		unlam.agregarAula(aula);
		Aula resultado = unlam.buscarAula(idAula);

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

		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);

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
		Integer idComision = cursada.getId();

		unlam.agregarAlumno(alumno1);
		unlam.agregarAlumno(alumno2);
		unlam.agregarAlumno(alumno3);
		unlam.agregarAula(aula);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		cursada.AgregarAula(aula);

		unlam.inscribirAlumnoACursada(dniAlumno1, idComision);
		unlam.inscribirAlumnoACursada(dniAlumno2, idComision);
		unlam.inscribirAlumnoACursada(dniAlumno3, idComision);

		Integer valor = unlam.cantidadAlumnosAnotados(idComision);
		Integer valorEsperado = 3;

		assertEquals(valorEsperado, valor);
	}

	@Test
	public void pruebaParaQueSePuedaInscribirUnAlumnoAMasDeUnaCursada() {

		String nombreUniversidad = "Unlam", nombreAlumno = "Javier", apellidoAlumno = "Perez", nombreDeMateria = "pb2",
				nombreDeMateriaCorrelativa = "pw";
		Integer dniAlumno = 7896, codigoMateria = 1718, codigoMateriaCorrelativa = 1719, comision = 64,
				cupoMaximoAlumnos = 70, nroAula = 404, cantidadMaximaAlumnos = 100;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Horario horariosCorrelativa = Horario.Noche;
		Dia diasCorrelativa = Dia.Lunes;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
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
		Materia materiaCorrelativa = new Materia(nombreDeMateriaCorrelativa, codigoMateriaCorrelativa, unlam);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		Cursada cursadaCorrelativa = new Cursada(materiaCorrelativa, comision, horariosCorrelativa, diasCorrelativa,
				cupoMaximoAlumnos, unlam, cicloElectivo);
		Integer idComision = cursada.getId();
		Integer idComisionCorrelativa = cursadaCorrelativa.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarAula(aula);
		unlam.agregarMateria(materia);
		unlam.agregarMateria(materiaCorrelativa);
		unlam.agregarCurso(cursada);
		unlam.agregarCurso(cursadaCorrelativa);
		cursada.AgregarAula(aula);

		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		Boolean resultado = unlam.inscribirAlumnoACursada(dniAlumno, idComisionCorrelativa);

		assertTrue(resultado);
	}
	
	@Test
	public void pruebaParaQueNoSePuedaInscribirUnAlumnoAMasDeUnaCursada() {

		String nombreUniversidad = "Unlam", nombreAlumno = "Javier", apellidoAlumno = "Perez", nombreDeMateria = "pb2",
				nombreDeMateriaCorrelativa = "pw";
		Integer dniAlumno = 7896, codigoMateria = 1718, codigoMateriaCorrelativa = 1719, comision = 64,
				cupoMaximoAlumnos = 70, nroAula = 404, cantidadMaximaAlumnos = 100;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Horario horariosCorrelativa = Horario.Noche;
		Dia diasCorrelativa = Dia.Lunes;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
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
		Materia materiaCorrelativa = new Materia(nombreDeMateriaCorrelativa, codigoMateriaCorrelativa, unlam);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		Cursada cursadaCorrelativa = new Cursada(materiaCorrelativa, comision, horariosCorrelativa, diasCorrelativa,
				cupoMaximoAlumnos, unlam, cicloElectivo);
		Integer idComision = cursada.getId();
		Integer idComisionCorrelativa = cursadaCorrelativa.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarAula(aula);
		unlam.agregarMateria(materia);
		unlam.agregarMateria(materiaCorrelativa);
		unlam.agregarCurso(cursada);
		unlam.agregarCurso(cursadaCorrelativa);
		cursada.AgregarAula(aula);

		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		Boolean resultado = unlam.inscribirAlumnoACursada(dniAlumno, idComisionCorrelativa);

		assertTrue(resultado);
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
		Alumno alumno2 = new Alumno(123, "Llombart", "kevin", fechaIngreso, fechaNacimineto);
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
		Alumno alumno2 = new Alumno(123, "Llombart", "kevin", fechaIngreso, fechaNacimineto);
		Aula aula = new Aula(nroAula, cantidadMaximaAlumnos);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		Nota nota1 = new Nota(valorNota, evaluacion1);
		Nota nota2 = new Nota(valorNota, evaluacion2);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		Integer idComision = cursada.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarAula(aula);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		cursada.AgregarAula(aula);

		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		unlam.registrarNota(idComision, dniAlumno, nota1);
		unlam.registrarNota(idComision, dniAlumno, nota2);

		unlam.agregarAlumno(alumno2);

		unlam.inscribirAlumnoACursada(123, idComision);
		unlam.registrarNota(idComision, 123, nota1);
		unlam.registrarNota(idComision, 123, nota2);

		Integer resultado = unlam.cantidadAlumnosAFinal(idComision);
		Integer resultadoEsperado = 2;

		assertEquals(resultadoEsperado, resultado);

	}

	@Test
	public void pruebaParaQueSePuedaObtenerLaCantidadDeAlumnosDesaprobados() {

		String nombreUniversidad = "Unlam", nombreAlumno = "Javier", apellidoAlumno = "Perez", nombreDeMateria = "pb2";
		Integer dniAlumno = 7896, codigoMateria = 1718, comision = 64, cupoMaximoAlumnos = 2, valorNota = 1,
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
		Alumno alumno2 = new Alumno(123, "Llombart", "Oablo", fechaIngreso, fechaNacimineto);
		Aula aula = new Aula(nroAula, cantidadMaximaAlumnos);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		Nota nota1 = new Nota(valorNota, evaluacion1);
		Nota nota2 = new Nota(valorNota, evaluacion2);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		Integer idComision = cursada.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarAula(aula);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		cursada.AgregarAula(aula);
		unlam.asignarAulaAlaComision(idComision, aula.getId());
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		unlam.registrarNota(idComision, dniAlumno, nota1);
		unlam.registrarNota(idComision, dniAlumno, nota2);

		unlam.agregarAlumno(alumno2);

		unlam.inscribirAlumnoACursada(123, idComision);
		unlam.registrarNota(idComision, 123, nota1);
		unlam.registrarNota(idComision, 123, nota2);

		Integer resultado = unlam.cantidadAlumnosReprobados(idComision);
		Integer resultadoEsperado = 2;

		assertEquals(resultadoEsperado, resultado);

	}

	@Test
	public void pruebaParaQueUnProfesorNoSePuedaAsignarAUnaCursadaSiNOSeCumpleLaRegla20ProfesPorAlumno() {

		String nombreProfesor1 = "Pablo", apellidoProfesor1 = "Chavez", nombreProfesor2 = "Martin",
				apellidoProfesor2 = "Zapata", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigoProfesor1 = 1225, codigoProfesor2 = 1226, idAsignacionDeCursada = 1415, codigoMateria = 1918,
				comision = 64, numeroAula = 404, cupoMaximoAlumnos = 100, capacidadMaximaAulas = 100;

		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, Month.MARCH, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, Month.JULY, 15);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, Month.MARCH, 6);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, Month.MARCH, 30);
		Universidad unlam = new Universidad(nombreUniversidad);
		Profesor profesor = new Profesor(nombreProfesor1, apellidoProfesor1, codigoProfesor1);
		Materia materia = new Materia(nombreDeMateria, codigoMateria, unlam);
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);

		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);

		unlam.cantidadAlumnosAnotados(idAsignacionDeCursada);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		unlam.ingresarProfesorALaUniversidad(profesor);

		Profesor profesor2 = new Profesor(nombreProfesor2, apellidoProfesor2, codigoProfesor2);
		unlam.ingresarProfesorALaUniversidad(profesor);
		unlam.asignarProfesorAlaComision(comision, codigoProfesor1);
		unlam.ingresarProfesorALaUniversidad(profesor2);

		Boolean seAsignaProfesor = unlam.asignarProfesorAlaComision(comision, codigoProfesor2);

		assertFalse(seAsignaProfesor);
	}

	@Test
	public void pruebaParaQueSePuedaAsignarUnAulaSiLaCapacidadDeLaMismaEsMayorQueElCupoDeAlumnos() {

		String nombreProfesor = "Martin", apellidoProfesor = "Suarez", nombreDeMateria = "pb2",
				nombreUniversidad = "Unlam";
		Integer codigoProfesor = 1225, codigoMateria = 1918, comision = 64, numeroAula = 404, cupoMaximoAlumnos = 55,
				capacidadMaximaAulas = 60;
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
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);
		Integer idCursada = cursada.getId();
		Integer idAula = aula.getId();
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		unlam.ingresarProfesorALaUniversidad(profesor);
		unlam.agregarAula(aula);
		unlam.asignarAulaAlaComision(idCursada, idAula);

		assertNotNull(unlam.BuscarCursada(idCursada).getAula());
	}

	@Test
	public void pruebaParaQueNoSePuedaAsignarUnAulaSiLaCapacidadDeLaMismaEsMenorQueElCupoDeAlumnos() {

		String nombreProfesor = "Martin", apellidoProfesor = "Suarez", nombreDeMateria = "pb2",
				nombreUniversidad = "Unlam";
		Integer codigoProfesor = 1225, codigoMateria = 1918, comision = 64, numeroAula = 404, cupoMaximoAlumnos = 55,
				capacidadMaximaAulas = 40;
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
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, cupoMaximoAlumnos, unlam, cicloElectivo);

		Integer idCursada = cursada.getId();
		Integer idAula = aula.getId();
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		unlam.ingresarProfesorALaUniversidad(profesor);
		unlam.agregarAula(aula);
		unlam.asignarAulaAlaComision(idCursada, idAula);

		assertNull(unlam.BuscarCursada(idCursada).getAula());
	}

	@Test
	public void pruebaParaQueSePromocioneUnaMateria() {

		String nombreAlumno = "Martin", apellidoAlumno = "Suarez", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigoMateria = 1918, comision = 64, numeroAula = 404, cupoMaximoAlumnos = 55,
				capacidadMaximaAulas = 80, dniAlumno = 45868259, notaPrimerparcial = 10, notaSegundoParcial = 10;
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
		Nota notaDelSegundoParcial = new Nota(notaSegundoParcial, Evaluacion.SEGUNDO_PARCIAL);
		Integer idComision = cursada.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		unlam.registrarNota(idComision, dniAlumno, notaDelPrimerParcial);
		unlam.registrarNota(idComision, dniAlumno, notaDelSegundoParcial);

		assertTrue(unlam.promociono(dniAlumno, idComision));
	}

	@Test
	public void pruebaParaQueVayaARecuperatorioYPromocione() {

		String nombreAlumno = "Martin", apellidoAlumno = "Suarez", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigoMateria = 1918, comision = 64, numeroAula = 404, cupoMaximoAlumnos = 55,
				capacidadMaximaAulas = 80, dniAlumno = 45868259, notaPrimerparcial = 3, notaSegundoParcial = 10,
				notaRecuperatorio = 10;
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
		Nota notaDelSegundoParcial = new Nota(notaSegundoParcial, Evaluacion.SEGUNDO_PARCIAL);
		Nota notaDelRecuperatorio = new Nota(notaRecuperatorio, Evaluacion.RECUPERATORIO);
		Integer idComision = cursada.getId();
		Integer idAula = aula.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		unlam.asignarAulaAlaComision(idComision, idAula);
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		unlam.registrarNota(idComision, dniAlumno, notaDelPrimerParcial);
		unlam.registrarNota(idComision, dniAlumno, notaDelSegundoParcial);
		unlam.registrarNota(idComision, dniAlumno, notaDelRecuperatorio);

		Boolean resultado = unlam.promociono(dniAlumno, idComision);

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueVayaAFinalYPromocione() {

		String nombreAlumno = "Martin", apellidoAlumno = "Suarez", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigoMateria = 1918, comision = 64, numeroAula = 404, cupoMaximoAlumnos = 55,
				capacidadMaximaAulas = 80, dniAlumno = 45868259, notaPrimerparcial = 4, notaSegundoParcial = 4,
				notaFinal = 10;
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
		unlam.registrarNota(idComision, dniAlumno, notaDelFinal);

		Boolean resultado = unlam.promociono(dniAlumno, idComision);

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueNoSePuedanHacerDosRecuperatorios() {

		String nombreAlumno = "Martin", apellidoAlumno = "Suarez", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigoMateria = 1918, comision = 64, numeroAula = 404, cupoMaximoAlumnos = 55,
				capacidadMaximaAulas = 80, dniAlumno = 45868259, notaPrimerparcial = 10, notaSegundoParcial = 3,
				notaRecuperatorio = 10;
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
		Nota notaDelOtroRecuperatorio = new Nota(notaRecuperatorio, Evaluacion.RECUPERATORIO);
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
		boolean resultado = unlam.registrarNota(idComision, dniAlumno, notaDelOtroRecuperatorio);

		assertFalse(resultado);
	}

	@Test
	public void pruebaParaQueAlCargarLaNotaFinalEstaDebeTenerAprobadasLosParciales() {

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
		Integer resultado = unlam.obtenerNota(dniAlumno, codigoMateria, idComision);

		assertNull(resultado);
	}

	@Test
	public void pruebaParaQueNoSePuedaAsignarUnaNotaMayorOIgualA7siNoEstánTodasLasCorrelativasAprobadas() {

		String nombreAlumno = "Martin", apellidoAlumno = "Suarez", nombreDeMateria = "pb2",
				nombreDeMateriaCorrelativa = "pw", nombreUniversidad = "Unlam";
		Integer codigoMateria = 1918, codigoMateriaCorrelativa = 1919, comision = 64, numeroAula = 404,
				cupoMaximoAlumnos = 55, capacidadMaximaAulas = 80, dniAlumno = 45868259, notaPrimerparcial = 7,
				notaSegundoParcial = 7;

		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Horario horariosCorrelatica = Horario.Noche;
		Dia diasCorrelativa = Dia.Lunes;
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
		Cursada cursadaCorrelativa = new Cursada(materiaCorrelativa, comision, horariosCorrelatica, diasCorrelativa,
				cupoMaximoAlumnos, unlam, cicloElectivo);
		Nota notaDelPrimerParcial = new Nota(notaPrimerparcial, Evaluacion.PRIMER_PARCIAL);
		Nota notaDelSegundoParcial = new Nota(notaSegundoParcial, Evaluacion.SEGUNDO_PARCIAL);
		Nota notaDelPrimerParcialCorrelativa = new Nota(5, Evaluacion.PRIMER_PARCIAL);
		Nota notaDelSegundoParcialCorrelativa = new Nota(4, Evaluacion.SEGUNDO_PARCIAL);
		Integer idComision = cursada.getId();
		Integer idComisionCorrelativa = cursadaCorrelativa.getId();
		Integer idAula = aula.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarMateria(materiaCorrelativa);
		unlam.agregarCorrelatividad(codigoMateria, idComisionCorrelativa);
		unlam.agregarCurso(cursada);
		unlam.agregarCurso(cursadaCorrelativa);

		unlam.inscribirAlumnoACursada(dniAlumno, idComisionCorrelativa);
		unlam.registrarNota(idComisionCorrelativa, dniAlumno, notaDelPrimerParcialCorrelativa);
		unlam.registrarNota(idComisionCorrelativa, dniAlumno, notaDelSegundoParcialCorrelativa);
		unlam.promociono(dniAlumno, idComisionCorrelativa);

		unlam.agregarAula(aula);

		unlam.asignarAulaAlaComision(idComision, idAula);
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		Boolean resultado = unlam.registrarNota(idComision, dniAlumno, notaDelPrimerParcial);
		unlam.registrarNota(idComision, dniAlumno, notaDelSegundoParcial);

		assertFalse(resultado);
	}

	@Test
	public void pruebaParaQueNoSePuedaAsignarCorrelativasSiTieneMismosHorarios() {

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
		Cursada cursadaCorrelativa = new Cursada(materiaCorrelativa, comision, horarios, dias, cupoMaximoAlumnos, unlam,
				cicloElectivo);
		Integer idComision = cursada.getId();
		Integer idComisionCorrelativa = cursadaCorrelativa.getId();
		Integer idAula = aula.getId();

		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarMateria(materiaCorrelativa);
		unlam.agregarCurso(cursada);
		unlam.agregarCurso(cursadaCorrelativa);
		unlam.inscribirAlumnoACursada(dniAlumno, idComision);
		unlam.inscribirAlumnoACursada(dniAlumno, idComisionCorrelativa);
		unlam.agregarAula(aula);
		unlam.asignarAulaAlaComision(idComision, idAula);

		Boolean resultado = unlam.agregarCorrelatividad(codigoMateria, idComisionCorrelativa);

		assertFalse(resultado);
	}
}