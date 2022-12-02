package com.practica.genericas;

import java.time.LocalDate;

import com.practica.excecption.EmsInvalidNumberOfDataException;


public class Persona {

	private static final int NOMBRE_POSICION = 2;
	private static final int APELLIDO_POSICION = 3;
	private static final int FECHA_NACIMIENTO_POSICION = 7;
	private static final int DOCUMENTO_POSICION = 1;
	private static final int EMAIL_POSICION = 4;
	private static final int DIRECCION_POSICION = 5;
	private static final int CP_POSICION = 6;
	
	private String nombre, apellidos, documento, email, direccion, cp;
	private LocalDate fechaNacimiento;

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

	public Persona(String[] datos) throws EmsInvalidNumberOfDataException {
		if (datos.length != Constantes.MAX_DATOS_PERSONA) {
			throw new EmsInvalidNumberOfDataException("El número de datos para PERSONA es menor de 8");
		}
		
		this.nombre = datos[NOMBRE_POSICION];
		this.apellidos = datos[APELLIDO_POSICION];
		this.documento = datos[DOCUMENTO_POSICION];
		this.email = datos[EMAIL_POSICION];
		this.direccion = datos[DIRECCION_POSICION];
		this.cp = datos[CP_POSICION];
		this.fechaNacimiento = FechaHora.parsearFecha(datos[FECHA_NACIMIENTO_POSICION]);
	}

	public Persona(String nombre, String apellidos, String documento, String email, String direccion, String cp, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.documento = documento;
		this.email = email;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.cp = cp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		
		String cadena = "";
		// Documento
		cadena += String.format("%s;", getDocumento());
		// Nombre y apellidos
		cadena += String.format("%s,%s;", getApellidos(), getNombre());
		// correo electrónico
		cadena += String.format("%s;", getEmail());
        // Direccion y código postal
		cadena += String.format("%s,%s;", getDireccion(), getCp());
        // Fecha de nacimiento
		cadena+= FechaHora.formatFecha(getFechaNacimiento());

		return cadena;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Persona other = (Persona) obj;
		return this.documento.equals(other.documento);
	}
}
