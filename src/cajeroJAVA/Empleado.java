package cajeroJAVA;

import javax.swing.JOptionPane;

public class Empleado extends Usuario{
	
	private  String puesto;
	private  String departamento;
	private  int sueldo;
	private Cuenta cuenta;
	
	public Empleado(String nombre, String dni, String pin, String rol, String puesto, String departamento, int sueldo, Cuenta cuenta) {
		super(nombre, dni, pin, rol);
		this.puesto = puesto;
		this.departamento = departamento;
		this.sueldo = sueldo;
		this.cuenta = cuenta;
	}

	
	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
	
	public Cuenta getCuenta() {
		return cuenta;
	}


	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}


	@Override
	public String toString() {
		return "Empleado [puesto=" + puesto + ", departamento=" + departamento + ", sueldo=" + sueldo + ", cuenta="
				+ cuenta + ", toString()=" + super.toString() + "]";
	}


	//REESCRIBO ESTE METODO PERO CON OTRO CONTEXTO EN EMPLEADO
	@Override
	public void Menu(Cajero cajero) {
		JOptionPane.showMessageDialog(null, "Bienvenido empleado");
	}
	
	
	public void AgregarDinero() {
		
	}
}
