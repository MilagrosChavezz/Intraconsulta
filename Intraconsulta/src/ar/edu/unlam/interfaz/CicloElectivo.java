package ar.edu.unlam.interfaz;

public class CicloElectivo {
private Integer año;
private Cuatrimestre cuatrimestre;

public CicloElectivo(Integer año, Cuatrimestre cuatrimestre) {
	super();
	this.año = año;
	this.cuatrimestre = cuatrimestre;
}

public Integer getAño() {
	return año;
}

public void setAño(Integer año) {
	this.año = año;
}

public Cuatrimestre getCuatrimestre() {
	return cuatrimestre;
}

public void setCuatrimestre(Cuatrimestre cuatrimestre) {
	this.cuatrimestre = cuatrimestre;
}


}
