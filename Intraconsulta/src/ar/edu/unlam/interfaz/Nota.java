package ar.edu.unlam.interfaz;

public class Nota {
private Integer valor;
private Evaluacion evaluacion;
	

	public Nota (Integer valor, Evaluacion evaluacion) {
		this.valor=valor;
		this.evaluacion=evaluacion;
	}
	



	public void setValor(Integer valor) {
		this.valor = valor;
	}




	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}




	public Evaluacion getEvaluacion() {
		return evaluacion;

	}

	public Integer getValor() {
		// TODO Auto-generated method stub
		return this.valor;
	}

	public void asignarValor(Integer valor) {
	
		if(valor >=1 && valor<=10)
		     this.valor=valor;
	}
	
}
