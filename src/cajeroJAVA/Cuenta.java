package cajeroJAVA;

public class Cuenta {
	
	
	private  double saldo;
	private  Cliente cliente;
	private  String operaciones;
	
	public Cuenta(double saldo, Cliente cliente, String operaciones) {
		this.saldo = saldo;
		this.cliente = cliente;
		this.operaciones = operaciones;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(String operaciones) {
		this.operaciones = operaciones;
	}

	
	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + ", cliente=" + cliente + ", operaciones="
				+ operaciones + "]";
	}
	
	
	
	
	
	
}
