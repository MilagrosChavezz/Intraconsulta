package ar.edu.unlam.interfaz;

public class Nota {
	private Integer valor;
	private Evaluacion evaluacion;
	private static Integer id = 0;

	public Nota(Integer valor, Evaluacion evaluacion) {
		this.valor = valor;
		this.evaluacion = evaluacion;
		id++;
	}

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
		return this.valor;
	}

	public void asignarValor(Integer valor) {

		if (valor >= 1 && valor <= 10)
			this.valor = valor;
	}
}
