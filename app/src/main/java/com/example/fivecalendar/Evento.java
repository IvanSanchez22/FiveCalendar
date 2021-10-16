package com.example.fivecalendar;

import java.util.Calendar;
import java.util.Objects;

public abstract class Evento {

	private Calendar horaInicio, horaFin;
	private String nombre;
	private String descripcion;

	private void updateHour(Calendar hora) {
		Calendar auxCal = Calendar.getInstance();
		hora.set(auxCal.get(Calendar.YEAR), auxCal.get(Calendar.MONTH), auxCal.get(Calendar.DATE));
	}

	public Evento(String nombre, String descripcion, Calendar horaInicio, Calendar horaFin) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		updateHour(horaInicio);
		updateHour(horaFin);
		setHoras(horaInicio, horaFin);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setHoras(Calendar horaInicio, Calendar horaFin) {
		updateHour(horaInicio);
		updateHour(horaFin);
		if(horaInicio.before(horaFin)) {
			this.horaInicio = horaInicio;
			this.horaFin = horaFin;
		} else {
			throw new RuntimeException("Hora final menor que hora inicio");
		}
	}

	public void setHoraInicio(Calendar hora) {
		setHoras(hora, horaFin);
	}

	public void setHoraFin(Calendar hora) {
		setHoras(horaInicio, hora);
	}

	public Calendar getHoraInicio() {
		return horaInicio;
	}

	public Calendar getHoraFin() {
		return horaFin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Evento evento = (Evento) o;
		return horaInicio.equals(evento.horaInicio) && horaFin.equals(evento.horaFin) && nombre.equals(evento.nombre);
	}

}
