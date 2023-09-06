package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class Cursada {
	
	private ArrayList<Alumno>alumnos;
	private ArrayList<Profesor>profesores;
	private Materia materia;
	private Integer comision;
	private Horario horarios;
	private Integer cicloLectivo;
	private Dia dias;
	private Aula aula;
	private CicloElectivo cicloElectivo;
	

	public Cursada( Materia materia,Integer comision,Horario horarios,Dia dias,Aula aula,CicloElectivo cicloElectivo, Integer cicloLectivo) {
		this.alumnos = new ArrayList<Alumno>();
		this.materia=materia;
		this.comision=comision;
		this.profesores=new ArrayList<Profesor>();
		this.aula=aula;
		this.cicloLectivo=cicloLectivo;
		this.dias=dias;
		this.horarios=horarios;
	}

	

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	
/*
	public void calificar(Integer valor) {
		
		nota.asignarValor(valor);
		
		
	}*/

	public Integer getComision() {
		return comision;
	}

	public void setComision(Integer comision) {
		this.comision = comision;
	}
	

	

}

