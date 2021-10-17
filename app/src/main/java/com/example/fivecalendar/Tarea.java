package com.example.fivecalendar;

import java.util.Calendar;

public class Tarea extends Evento {

	private Calendar fecha;
	
	public Tarea(String nombre, String descripcion, Calendar fecha, Calendar horaInicio, Calendar horaFin) {
		super(nombre, descripcion, horaInicio, horaFin);
		this.fecha = fecha;
	}

	public Tarea(String nombre, Calendar fecha, Calendar horaInicio, Calendar horaFin) {
		super(nombre, "", horaInicio, horaFin);
		this.fecha = fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public boolean before(Tarea tarea) {
		return fecha.before(tarea.fecha) && super.before(tarea);
	}



}
