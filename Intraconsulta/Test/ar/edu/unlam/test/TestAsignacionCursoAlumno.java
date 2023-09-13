package ar.edu.unlam.test;

import static org.junit.Assert.*;

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
import ar.edu.unlam.interfaz.Profesor;
import ar.edu.unlam.interfaz.Universidad;

public class TestAsignacionCursoAlumno {

	@Test
	public void queSePuedaInscribirUnAlumno() {

		String nombre = "Juan", apellido = "Lopez", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer dni = 7869, año = 2023, comision = 64, cupoMaximoAlumnos = 10, numeroAula = 404,
				capacidadMaximaAulas = 100, codigoMateria = 1015, valorNota = 7;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		Evaluacion evaluacion = Evaluacion.PRIMER_PARCIAL;

		Universidad unlam = new Universidad(nombreUniversidad);
		Nota nota = new Nota(valorNota, evaluacion);
		Alumno alumno = new Alumno(dni, apellido, nombre);
		Materia materia = new Materia(nombreDeMateria, codigoMateria);
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(año, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, aula, cicloElectivo, cupoMaximoAlumnos);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(capacidadMaximaAulas, cursada, alumno, unlam);
		unlam.agregarCurso(cursada);
		unlam.agregarAlumno(alumno);
		unlam.agregarMateria(materia);
		unlam.agregarAula(aula);

		boolean resultado = asignacion.inscribirAlumno(alumno, cursada);

		assertTrue(resultado);
	}

	@Test
	public void queSePuedaInscribirDosAlumnos() {

		String nombre = "Juan", apellido = "Lopez", nombre2 = "Pedro", apellido2 = "Sanchez", nombreDeMateria = "pb2",
				nombreUniversidad = "Unlam";
		Integer dni = 7869, dni2 = 6852, año = 2023, comision = 64, cupoMaximoAlumnos = 10, numeroAula = 404,
				capacidadMaximaAulas = 10, codigoMateria = 1015, valorNota = 7;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		Evaluacion evaluacion = Evaluacion.PRIMER_PARCIAL;

		Universidad unlam = new Universidad(nombreUniversidad);
		Nota nota = new Nota(valorNota, evaluacion);
		Alumno alumno = new Alumno(dni, apellido, nombre);
		Alumno alumno2 = new Alumno(dni2, apellido2, nombre2);
		Materia materia = new Materia(nombreDeMateria, codigoMateria);
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(año, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, aula, cicloElectivo, cupoMaximoAlumnos);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(capacidadMaximaAulas, cursada, alumno, unlam);
		AsignacionAlumnoACurso asignacion2 = new AsignacionAlumnoACurso(capacidadMaximaAulas, cursada, alumno2, unlam);
		unlam.agregarCurso(cursada);
		unlam.agregarAlumno(alumno);
		unlam.agregarAlumno(alumno2);
		unlam.agregarMateria(materia);
		unlam.agregarAula(aula);
		asignacion.inscribirAlumno(alumno, cursada);
		asignacion2.inscribirAlumno(alumno2, cursada);
		Integer resultado = cursada.cantidadAlumnosAnotados();
		Integer resultadoEsperado = 2;

		assertEquals(resultadoEsperado, resultado);
	}

	@Test
	public void seApruebeUnaMateria() {

		String nombre = "Juan", apellido = "Lopez", nombre2 = "Pedro", apellido2 = "Sanchez", nombreDeMateria = "pb2",
				nombreUniversidad = "Unlam";
		Integer dni = 7869, dni2 = 6852, año = 2023, comision = 64, cupoMaximoAlumnos = 10, numeroAula = 404,
				capacidadMaximaAulas = 10, codigoMateria = 1015, valorNota = 7;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		Evaluacion evaluacion = Evaluacion.PRIMER_PARCIAL;

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dni, apellido, nombre);
		Materia materia = new Materia(nombreDeMateria, codigoMateria);
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(año, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, aula, cicloElectivo, cupoMaximoAlumnos);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(capacidadMaximaAulas, cursada, alumno, unlam);

		cursada.AgregarAula(aula);
		unlam.agregarAlumno(alumno);
		unlam.agregarCurso(cursada);
		unlam.agregarMateria(materia);

		Nota notaCorrelativa2 = new Nota(10, Evaluacion.SEGUNDO_PARCIAL);
		Materia materiaCorrelativa = new Materia("taller Web", 1234);
		Aula aulaCorrelativa = new Aula(789, 78);
		CicloElectivo cicloElectivoCorrelativa = new CicloElectivo(año, cuatrimestre);
		Cursada cursadaCorelativa = new Cursada(materiaCorrelativa, 78, horarios, dias, aula, cicloElectivoCorrelativa,
				cupoMaximoAlumnos);
		AsignacionAlumnoACurso asignacionCorrelativa = new AsignacionAlumnoACurso(8, cursadaCorelativa, alumno, unlam);
		// materia.agregarMateriasCorrelativas(1234);
		unlam.agregarMateria(materiaCorrelativa);
		unlam.agregarCurso(cursadaCorelativa);
		unlam.agregarAula(aulaCorrelativa);
		Nota notaPrimerParcial = new Nota(7, Evaluacion.PRIMER_PARCIAL);
		asignacionCorrelativa.AgregarNota(notaPrimerParcial);
		asignacionCorrelativa.AgregarNota(notaCorrelativa2);

		Boolean apruebaMateria = asignacionCorrelativa.apruebaPrimerParcial();
		assertTrue(apruebaMateria);

	}

	@Test
	public void queNOPuedaPromocionarUnaMateria() {

		String nombre = "Juan", apellido = "Lopez", nombre2 = "Pedro", apellido2 = "Sanchez", nombreDeMateria = "pb2",
				nombreUniversidad = "Unlam";
		Integer dni = 7869, dni2 = 6852, año = 2023, comision = 64, cupoMaximoAlumnos = 10, numeroAula = 404,
				capacidadMaximaAulas = 10, codigoMateria = 1015, valorNota = 7;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		Evaluacion evaluacion = Evaluacion.PRIMER_PARCIAL;

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dni, apellido, nombre);
		Materia materia = new Materia(nombreDeMateria, codigoMateria);
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(año, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, aula, cicloElectivo, cupoMaximoAlumnos);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(1, cursada, alumno, unlam);

		cursada.AgregarAula(aula);
		unlam.agregarAlumno(alumno);
		unlam.agregarCurso(cursada);
		unlam.agregarMateria(materia);

		Nota notaCorrelativa = new Nota(1, Evaluacion.PRIMER_PARCIAL);
		Nota notaCorrelativa2 = new Nota(10, Evaluacion.SEGUNDO_PARCIAL);
		Materia materiaCorrelativa = new Materia("taller Web", 1234);
		Aula aulaCorrelativa = new Aula(789, 78);
		CicloElectivo cicloElectivoCorrelativa = new CicloElectivo(año, cuatrimestre);
		Cursada cursadaCorelativa = new Cursada(materiaCorrelativa, 78, horarios, dias, aula, cicloElectivoCorrelativa,
				cupoMaximoAlumnos);
		AsignacionAlumnoACurso asignacionCorrelativa = new AsignacionAlumnoACurso(8, cursadaCorelativa, alumno, unlam);
		materia.agregarMateriasCorrelativas(1234);
		unlam.agregarMateria(materiaCorrelativa);
		unlam.agregarCurso(cursadaCorelativa);
		unlam.agregarAula(aulaCorrelativa);
		asignacionCorrelativa.AgregarNota(notaCorrelativa);
		asignacionCorrelativa.AgregarNota(notaCorrelativa2);

		Boolean promocionaMateria = asignacionCorrelativa.promocionaMateria();
		assertFalse(promocionaMateria);

	}

	@Test
	public void quePuedaAnotarseAUnaMateriaConLasCorrelativasAprobadas() {

		String nombre = "Juan", apellido = "Lopez", nombre2 = "Pedro", apellido2 = "Sanchez", nombreDeMateria = "pb2",
				nombreUniversidad = "Unlam";
		Integer dni = 7869, dni2 = 6852, año = 2023, comision = 64, cupoMaximoAlumnos = 10, numeroAula = 404,
				capacidadMaximaAulas = 10, codigoMateria = 1015, valorNota = 7;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		Evaluacion evaluacion = Evaluacion.PRIMER_PARCIAL;

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dni, apellido, nombre);
		Materia materia = new Materia(nombreDeMateria, codigoMateria);
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		Nota notaCorrelativa = new Nota(10, Evaluacion.PRIMER_PARCIAL);
		Nota notaCorrelativa2 = new Nota(10, Evaluacion.SEGUNDO_PARCIAL);
		Materia materiaCorrelativa = new Materia("taller Web", 1234);
		Aula aulaCorrelativa = new Aula(789, 78);
		CicloElectivo cicloElectivoCorrelativa = new CicloElectivo(año, cuatrimestre);
		Cursada cursadaCorelativa = new Cursada(materiaCorrelativa, 78, horarios, dias, aula, cicloElectivoCorrelativa,
				cupoMaximoAlumnos);

		AsignacionAlumnoACurso asignacionCorrelativa = new AsignacionAlumnoACurso(8, cursadaCorelativa, alumno, unlam);
		asignacionCorrelativa.inscribirAlumno(alumno, cursadaCorelativa);
		asignacionCorrelativa.inscribirAlumno(alumno, cursadaCorelativa);
		materia.agregarMateriasCorrelativas(1234);
		unlam.agregarMateria(materiaCorrelativa);
		unlam.agregarCurso(cursadaCorelativa);
		unlam.agregarAula(aulaCorrelativa);
		asignacionCorrelativa.AgregarNota(notaCorrelativa);
		asignacionCorrelativa.AgregarNota(notaCorrelativa2);
		asignacionCorrelativa.promocionaMateria();

		CicloElectivo cicloElectivo = new CicloElectivo(año, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, aula, cicloElectivo, cupoMaximoAlumnos);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(1, cursada, alumno, unlam);

		cursada.AgregarAula(aula);
		unlam.agregarAlumno(alumno);
		unlam.agregarCurso(cursada);
		unlam.agregarMateria(materia);

		Boolean seAnotaAMateria = asignacion.inscribirAlumno(alumno, cursada);

		assertTrue(seAnotaAMateria);

	}

	@Test
	public void queNoSePuedaAnotarseAUnaMateriaConLasCorrelativasDesaprobadas() {

		String nombre = "Juan", apellido = "Lopez", nombre2 = "Pedro", apellido2 = "Sanchez", nombreDeMateria = "pb2",
				nombreUniversidad = "Unlam";
		Integer dni = 7869, dni2 = 6852, año = 2023, comision = 64, cupoMaximoAlumnos = 10, numeroAula = 404,
				capacidadMaximaAulas = 10, codigoMateria = 1015, valorNota = 7;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		Evaluacion evaluacion = Evaluacion.PRIMER_PARCIAL;

		// materia principal
		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dni, apellido, nombre);
		Materia materia = new Materia(nombreDeMateria, codigoMateria);
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);

		unlam.agregarAlumno(alumno);

		// Materia correlativa numero 1
		Nota notaCorrelativa = new Nota(10, Evaluacion.PRIMER_PARCIAL);
		Nota notaCorrelativa2 = new Nota(1, Evaluacion.SEGUNDO_PARCIAL);
		Materia materiaCorrelativa = new Materia("taller Web", 1234);
		Aula aulaCorrelativa = new Aula(789, 78);
		CicloElectivo cicloElectivoCorrelativa = new CicloElectivo(año, cuatrimestre);
		Cursada cursadaCorelativa = new Cursada(materiaCorrelativa, 78, horarios, dias, aula, cicloElectivoCorrelativa,
				cupoMaximoAlumnos);

		AsignacionAlumnoACurso asignacionCorrelativa = new AsignacionAlumnoACurso(8, cursadaCorelativa, alumno, unlam);
		asignacionCorrelativa.inscribirAlumno(alumno, cursadaCorelativa);

		materia.agregarMateriasCorrelativas(1234);
		unlam.agregarMateria(materiaCorrelativa);
		unlam.agregarCurso(cursadaCorelativa);
		unlam.agregarAula(aulaCorrelativa);
		asignacionCorrelativa.AgregarNota(notaCorrelativa);
		asignacionCorrelativa.AgregarNota(notaCorrelativa2);
		asignacionCorrelativa.promocionaMateria();

		// materia correlativa numero 2
		Nota notaCorrelativaBD = new Nota(10, Evaluacion.PRIMER_PARCIAL);
		Nota notaCorrelativaBD2 = new Nota(10, Evaluacion.SEGUNDO_PARCIAL);
		Materia materiaCorrelativa2 = new Materia("Base de Datos", 1238);
		Aula aulaCorrelativa2 = new Aula(78, 98);
		CicloElectivo cicloElectivoCorrelativa2 = new CicloElectivo(año, cuatrimestre);
		Cursada cursadaCorelativa2 = new Cursada(materiaCorrelativa2, 78, horarios, dias, aula,
				cicloElectivoCorrelativa, cupoMaximoAlumnos);

		AsignacionAlumnoACurso asignacionCorrelativa2 = new AsignacionAlumnoACurso(6, cursadaCorelativa2, alumno,
				unlam);
		asignacionCorrelativa2.inscribirAlumno(alumno, cursadaCorelativa);

		materia.agregarMateriasCorrelativas(1238);
		unlam.agregarMateria(materiaCorrelativa2);
		unlam.agregarCurso(cursadaCorelativa2);
		unlam.agregarAula(aulaCorrelativa2);
		asignacionCorrelativa2.AgregarNota(notaCorrelativaBD2);
		asignacionCorrelativa2.AgregarNota(notaCorrelativaBD);
		asignacionCorrelativa2.promocionaMateria();

		CicloElectivo cicloElectivo = new CicloElectivo(año, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, aula, cicloElectivo, cupoMaximoAlumnos);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(1, cursada, alumno, unlam);

		cursada.AgregarAula(aula);
		unlam.agregarCurso(cursada);
		unlam.agregarMateria(materia);

		Boolean seAnotaAMateria = asignacion.inscribirAlumno(alumno, cursada);

		assertFalse(seAnotaAMateria);

	}

	@Test
	public void noApruebeElPrimerParcialYVallaARecuperatorio() {

		String nombre = "Juan", apellido = "Lopez", nombre2 = "Pedro", apellido2 = "Sanchez", nombreDeMateria = "pb2",
				nombreUniversidad = "Unlam";
		Integer dni = 7869, dni2 = 6852, año = 2023, comision = 64, cupoMaximoAlumnos = 10, numeroAula = 404,
				capacidadMaximaAulas = 10, codigoMateria = 1015, valorNota = 7;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		Evaluacion evaluacion = Evaluacion.PRIMER_PARCIAL;

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dni, apellido, nombre);
		Materia materia = new Materia(nombreDeMateria, codigoMateria);
		Aula aula = new Aula(numeroAula, capacidadMaximaAulas);
		CicloElectivo cicloElectivo = new CicloElectivo(año, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, aula, cicloElectivo, cupoMaximoAlumnos);
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(1, cursada, alumno, unlam);

		cursada.AgregarAula(aula);
		unlam.agregarAlumno(alumno);
		unlam.agregarCurso(cursada);
		unlam.agregarMateria(materia);

		Nota notaCorrelativa = new Nota(10, Evaluacion.PRIMER_PARCIAL);
		Nota notaCorrelativa2 = new Nota(0, Evaluacion.SEGUNDO_PARCIAL);
		Materia materiaCorrelativa = new Materia("taller Web", 1234);
		Aula aulaCorrelativa = new Aula(789, 78);
		CicloElectivo cicloElectivoCorrelativa = new CicloElectivo(año, cuatrimestre);
		Cursada cursadaCorelativa = new Cursada(materiaCorrelativa, 78, horarios, dias, aula, cicloElectivoCorrelativa,
				cupoMaximoAlumnos);
		AsignacionAlumnoACurso asignacionCorrelativa = new AsignacionAlumnoACurso(8, cursadaCorelativa, alumno, unlam);
		materia.agregarMateriasCorrelativas(1234);
		unlam.agregarMateria(materiaCorrelativa);
		unlam.agregarCurso(cursadaCorelativa);
		unlam.agregarAula(aulaCorrelativa);
		asignacionCorrelativa.AgregarNota(notaCorrelativa);
		asignacionCorrelativa.AgregarNota(notaCorrelativa2);

		asignacion.apruebaPrimerParcial();
		asignacion.apruebaSegundoParcial();
		Nota recuperatorio = new Nota(7, Evaluacion.RECUPERATORIO);

		asignacion.AgregarNota(recuperatorio);
		asignacion.recuperaPrimerParcial();
		asignacion.recuperaSegundoParcial();

		asignacion.aprobarRecuperatorio();

		Boolean promocionaMateria = asignacionCorrelativa.promocionaMateria();
		assertTrue(asignacion.recuperaPrimerParcial());

	}

}