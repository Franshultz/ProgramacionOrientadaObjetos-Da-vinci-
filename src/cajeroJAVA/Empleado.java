package cajeroJAVA;

public class Empleado extends Usuario{
	
	private  String puesto;
	private  String departamento;
	private  int sueldo;
	
	public Empleado(String nombre, String dni, String pin, String rol, String puesto, String departamento, int sueldo) {
		super(nombre, dni, pin, rol);
		this.puesto = puesto;
		this.departamento = departamento;
		this.sueldo = sueldo;
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
	
	
	
	
}
