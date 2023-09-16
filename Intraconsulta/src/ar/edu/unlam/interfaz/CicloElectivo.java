package ar.edu.unlam.interfaz;

<<<<<<< Updated upstream
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
=======
import java.time.LocalDate;

public class CicloElectivo {
	
	private LocalDate fechaInicioCicloLectivo;
	private LocalDate fechaFinalizacionCicloLectivo;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinalizacionInscripcion;
	private Cuatrimestre cuatrimestre;
	private static Integer id = 0;

	public CicloElectivo(LocalDate fechaInicioCicloLectivo, LocalDate fechaFinalizacionCicloLectivo,
			LocalDate fechaInicioInscripcion, LocalDate fechaFinalizacionInscripcion, Cuatrimestre cuatrimestre) {
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
		this.cuatrimestre = cuatrimestre;
		id++;
>>>>>>> Stashed changes
	}
	

<<<<<<< Updated upstream
	public void setAño(Integer año) {
		this.año = año;
=======
	public LocalDate getFechaFinalizacionCicloLectivo() {
		return fechaFinalizacionCicloLectivo;
	}

	public void setFechaFinalizacionCicloLectivo(LocalDate fechaFinalizacionCicloLectivo) {
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
	}

	public LocalDate getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}

	public void setFechaInicioInscripcion(LocalDate fechaInicioInscripcion) {
		this.fechaInicioInscripcion = fechaInicioInscripcion;
	}

	public LocalDate getFechaFinalizacionInscripcion() {
		return fechaFinalizacionInscripcion;
	}

	public void setFechaFinalizacionInscripcion(LocalDate fechaFinalizacionInscripcion) {
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
	}

	public LocalDate getfechaInicioCicloLectivo() {
		return fechaInicioCicloLectivo;
	}

	public void setfechaInicioCicloLectivo(LocalDate fechaInicioCicloLectivo) {
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
>>>>>>> Stashed changes
	}

	public Cuatrimestre getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(Cuatrimestre cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

}
