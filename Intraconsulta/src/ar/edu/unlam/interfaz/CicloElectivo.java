package ar.edu.unlam.interfaz;

public class CicloElectivo {
	private Integer fechaInicioCicloLectivo;
	private Integer fechaFinalizacionCicloLectivo;
	private Integer fechaInicioInscripcion;
	private Integer fechaFinalizacionInscripcion;
	private Cuatrimestre cuatrimestre;
	private Integer id;

	public CicloElectivo(Integer fechaInicioCicloLectivo, Integer fechaFinalizacionCicloLectivo,
			Integer fechaInicioInscripcion, Integer fechaFinalizacionInscripcion, Integer id,
			Cuatrimestre cuatrimestre) {
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
		this.cuatrimestre = cuatrimestre;
		this.id = id;
	}

	public Integer getFechaFinalizacionCicloLectivo() {
		return fechaFinalizacionCicloLectivo;
	}

	public void setFechaFinalizacionCicloLectivo(Integer fechaFinalizacionCicloLectivo) {
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
	}

	public Integer getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}

	public void setFechaInicioInscripcion(Integer fechaInicioInscripcion) {
		this.fechaInicioInscripcion = fechaInicioInscripcion;
	}

	public Integer getFechaFinalizacionInscripcion() {
		return fechaFinalizacionInscripcion;
	}

	public void setFechaFinalizacionInscripcion(Integer fechaFinalizacionInscripcion) {
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
	}

	public Integer getfechaInicioCicloLectivo() {
		return fechaInicioCicloLectivo;
	}

	public void setfechaInicioCicloLectivo(Integer año) {
		this.fechaInicioCicloLectivo = año;
	}

	public Cuatrimestre getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(Cuatrimestre cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
