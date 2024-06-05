package cajeroJAVA;

public class Cuenta {
	
	
	private  double saldo;
	private  String operaciones = "";
	
	public Cuenta(double saldo) {
		this.saldo = saldo;
		this.operaciones = operaciones;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(String operaciones) {
		this.operaciones = operaciones;
	}

	
	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + ", operaciones=" + operaciones + "]";
	}
	
	
	
	
	
	
}
