package cajeroJAVA;

import javax.swing.JOptionPane;

public abstract class Usuario {
	
	private  String nombre;
	private  String dni;
	private  String pin;
	private  String rol;
	
	public Usuario(String nombre, String dni, String pin, String rol) {
		this.nombre = nombre;
		this.dni = dni;
		this.pin = pin;
		this.rol = rol;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}


	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", dni=" + dni + ", pin=" + pin + ", rol=" + rol + "]";
	}
	
	
	public boolean IngresarCajero(String dni, String pin) {
		
		if (this.getDni().equals(dni)) {
			
			if (this.getPin().equals(pin)) {
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Pin incorrecto");
				return false;
			}
			
		} else {
			
			JOptionPane.showMessageDialog(null, "dni incorrecto");
			return false;

		}
	}
	
	public void Menu(Cajero cajero) {
		
		
	}
	
	
	
}
