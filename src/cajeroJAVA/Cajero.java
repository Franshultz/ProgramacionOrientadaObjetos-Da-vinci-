package cajeroJAVA;

public class Cajero {
	
	private  String ubicaion;
	private  double saldo;
	
	public Cajero(String ubicaion, double saldo) {		
		this.ubicaion = ubicaion;
		this.saldo = saldo;
	}

	
	public String getUbicaion() {
		return ubicaion;
	}

	public void setUbicaion(String ubicaion) {
		this.ubicaion = ubicaion;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
	@Override
	public String toString() {
		return "Cajero [ubicaion=" + ubicaion + ", saldo=" + saldo + "]";
	}
	
	
	
	
}
