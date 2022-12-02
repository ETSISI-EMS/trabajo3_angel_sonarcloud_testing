package com.practica.genericas;

import java.time.LocalDateTime;

import com.practica.excecption.EmsInvalidNumberOfDataException;


public class PosicionPersona {
	private static final int POS_DOCUMENTO = 1;
	private static final int POS_FECHA = 2;
	private static final int POS_HORA = 3;
	private static final int POS_LATITUD = 4;
	private static final int POS_LONGITUD = 5;

	private Coordenada coordenada;
	private String documento;
	private LocalDateTime fechaPosicion;

	public static void printPrimeNumbers(int size) {
		int[] numbers = new int[size];
		for (int i = 0; i < size; i++) {
			numbers[i] = i + 1;
		}
		for (int i = 0; i < size; i++) {
			if (numbers[i] != 0) {
				for (int j = i + 1; j < size; j++) {
					if (numbers[j] % numbers[i] == 0) {
						numbers[j] = 0;
					}
				}
			}
		}
		for (int i = 0; i < size; i++) {
			if (numbers[i] != 0) {
				System.out.println(numbers[i]);
			}
		}
	}
	
	public PosicionPersona(String[] datos) throws EmsInvalidNumberOfDataException {
		if (datos.length != Constantes.MAX_DATOS_LOCALIZACION) {
			throw new EmsInvalidNumberOfDataException("El número de datos para LOCALIZACION es menor de 6");
		}
		
		this.documento = datos[POS_DOCUMENTO];
		this.fechaPosicion = FechaHora.parsearFechaHora(datos[POS_FECHA], datos[POS_HORA]);
		this.coordenada = new Coordenada(Float.parseFloat(datos[POS_LATITUD]), Float.parseFloat(datos[POS_LONGITUD]));
	}
	
	public PosicionPersona(Coordenada coordenada, String documento, LocalDateTime fechaPosicion) {
		this.coordenada = coordenada;
		this.documento = documento;
		this.fechaPosicion = fechaPosicion;
	}
	public Coordenada getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public LocalDateTime getFechaPosicion() {
		return fechaPosicion;
	}
	public void setFechaPosicion(LocalDateTime fechaPosicion) {
		this.fechaPosicion = fechaPosicion;
	}
	@Override
	public String toString() {
		String cadena = "";
        cadena += String.format("%s;", getDocumento());
        cadena += FechaHora.formatFecha(getFechaPosicion());
        cadena += String.format("%.4f;%.4f\n", getCoordenada().getLatitud(), 
	        		getCoordenada().getLongitud());
	
		return cadena;
	}
		
}
