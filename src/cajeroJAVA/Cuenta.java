package cajeroJAVA;

public class Cuenta {
	
	
	private  int nroCliente;
	private  double saldo;
	private  Cliente cliente;
	private  String operaciones;
	
	public Cuenta(int nroCliente, double saldo, Cliente cliente, String operaciones) {
		this.nroCliente = nroCliente;
		this.saldo = saldo;
		this.cliente = cliente;
		this.operaciones = operaciones;
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
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
		return "Cuenta [nroCliente=" + nroCliente + ", saldo=" + saldo + ", cliente=" + cliente + ", operaciones="
				+ operaciones + "]";
	}
	
	
	
	
	
	
}
