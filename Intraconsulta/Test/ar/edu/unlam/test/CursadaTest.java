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

public class CursadaTest {

	@Test
	public void pruebaParaQueUnProfesorEsteDisponible() {
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
		AsignacionProfeACurso nuevaAsignacion = new AsignacionProfeACurso(profesor, cursada, idAsignacionDeCursada);
		
		Boolean resultado = nuevaAsignacion.asignarProfesorACurso(profesor, cursada);
		
		assertTrue(resultado);
	}

}
