package cajeroJAVA;

public class Cliente extends Usuario{
	
	private int nroCuenta;
	
	public Cliente(String nombre, String dni, String pin, String rol, int nroCuenta) {
		super(nombre, dni, pin, rol);
		this.nroCuenta = nroCuenta;
	}

	
	public int getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	
	@Override
	public String toString() {
		return "Cliente [nroCuenta=" + nroCuenta + ", toString()=" + super.toString() + "]";
	}
	
	
}
