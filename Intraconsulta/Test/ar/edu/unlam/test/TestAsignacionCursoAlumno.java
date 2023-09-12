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
				capacidadMaximaAulas = 10, codigoMateria = 1015, valorNota = 7;
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
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(capacidadMaximaAulas, cursada, alumno, unlam,
				nota);

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
		AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(capacidadMaximaAulas, cursada, alumno, unlam,
				nota);

		asignacion.inscribirAlumno(alumno, cursada);
		asignacion.inscribirAlumno(alumno2, cursada);
		Integer resultado = cursada.cantidadAlumnosAnotados();
		Integer resultadoEsperado = 2;

		assertEquals(resultadoEsperado, resultado);
	}
}
