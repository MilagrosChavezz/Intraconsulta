package ar.edu.unlam.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.interfaz.Alumno;
import ar.edu.unlam.interfaz.Cuatrimestre;
import ar.edu.unlam.interfaz.Dia;
import ar.edu.unlam.interfaz.Evaluacion;
import ar.edu.unlam.interfaz.Horario;
import ar.edu.unlam.interfaz.Materia;
import ar.edu.unlam.interfaz.Universidad;

public class MeteriaTest {

	@Test
	public void sePuedeAgregarCorrelativas() {
		Materia materiaCorrelativa = new Materia("taller Web", 1234);
	 String nombreDeMateria = "pb2";
				
		Integer codigoMateria = 1015;
		Horario horarios = Horario.Mañana;
		Dia dias = Dia.Miercoles;
		Cuatrimestre cuatrimestre = Cuatrimestre.Primer_Cuatrimestre;
		Evaluacion evaluacion = Evaluacion.PRIMER_PARCIAL;

		Materia materia = new Materia(nombreDeMateria, codigoMateria, null);
		
	Boolean seAgrego=	materia.agregarMateriasCorrelativas(1234);
	
	assertTrue(seAgrego);
		
	}

}
