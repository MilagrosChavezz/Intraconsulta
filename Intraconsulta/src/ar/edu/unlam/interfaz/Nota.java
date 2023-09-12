package ar.edu.unlam.interfaz;

public class Nota {

private Integer valor;
private Evaluacion evaluacion;
	
	public Nota () {
		this.valor=0;}



	public Evaluacion getEvaluacion() {
		return evaluacion;

	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}



	public Integer getValor() {
		// TODO Auto-generated method stub
		return this.valor;
	}

	public void asignarValor(Integer valor) {

		if (valor >= 1 && valor <= 10)
			this.valor = valor;
	}

	public Nota(Integer valor, Evaluacion evaluacion) {
		super();
		this.valor = valor;
		this.evaluacion = evaluacion;
	}

}
