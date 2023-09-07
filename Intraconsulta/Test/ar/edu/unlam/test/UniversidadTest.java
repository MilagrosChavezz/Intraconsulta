package ar.edu.unlam.test;

import static org.junit.Assert.*;

import org.junit.Test;

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

public class UniversidadTest {

	@Test
	public void pruebaParaVerSiUNAulaPuedeSerIngresadaALAFacultad() {
		String nombre = "Martin", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigo = 1225, idAsignacionDeCursada = 1415, codigoMateria = 1918, comision = 64, numeroAula = 404,
				año = 2023, cupoMaximoAlumnos = 35;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;

		Profesor profesor = new Profesor(nombre, codigo);
		Materia materia = new Materia(nombreDeMateria, codigoMateria);
		Aula aula = new Aula(numeroAula);
		CicloElectivo cicloElectivo = new CicloElectivo(año, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, aula, cicloElectivo, cupoMaximoAlumnos);
		Universidad unlam = new Universidad(nombreUniversidad);
		AsignacionProfeACurso nuevaAsignacion = new AsignacionProfeACurso(profesor, cursada, idAsignacionDeCursada, unlam);
		unlam.agregarAlumno(null);
		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);

		Boolean resultado = unlam.agregarAula(aula);

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueUnCursoSePuedaAgregar() {
		String nombre = "Martin", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigo = 1225, idAsignacionDeCursada = 1415, codigoMateria = 1918, comision = 64, numeroAula = 404,
				año = 2023, cupoMaximoAlumnos = 35;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;

		
		Materia materia = new Materia(nombreDeMateria, codigoMateria);
		Aula aula = new Aula(numeroAula);
		CicloElectivo cicloElectivo = new CicloElectivo(año, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, aula, cicloElectivo, cupoMaximoAlumnos);
		Universidad unlam = new Universidad(nombreUniversidad);

		unlam.agregarMateria(materia);

		Boolean resultado = unlam.agregarCurso(cursada);

		assertTrue(resultado);
	}

	@Test
	public void pruebaParaQueUnProfesorsePuedaIngresarALaUniversidad() {
		String nombre = "Martin", nombreDeMateria = "pb2", nombreUniversidad = "Unlam";
		Integer codigo = 1225, idAsignacionDeCursada = 1415, codigoMateria = 1918, comision = 64, numeroAula = 404,
				año = 2023, cupoMaximoAlumnos = 35;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;

		Profesor profesor = new Profesor(nombre, codigo);
		Materia materia = new Materia(nombreDeMateria, codigoMateria);
		Aula aula = new Aula(numeroAula);
		CicloElectivo cicloElectivo = new CicloElectivo(año, cuatrimestre);
		Cursada cursada = new Cursada(materia, comision, horarios, dias, aula, cicloElectivo, cupoMaximoAlumnos);
		Universidad unlam = new Universidad(nombreUniversidad);
		AsignacionProfeACurso nuevaAsignacion = new AsignacionProfeACurso(profesor, cursada, idAsignacionDeCursada, unlam);

		unlam.agregarMateria(materia);
		unlam.agregarCurso(cursada);
		unlam.agregarAula(aula);
		Boolean resultado = unlam.ingresarProfesorALaUniversidad(profesor);

		assertTrue(resultado);
	}

	
	

}
