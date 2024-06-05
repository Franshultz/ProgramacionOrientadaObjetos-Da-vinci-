package cajeroJAVA;

import java.time.LocalDateTime;

import javax.swing.JOptionPane;

public class Cliente extends Usuario{
	
	private int nroCuenta;
	private Cuenta cuenta;
	
	public Cliente(String nombre, String dni, String pin, String rol, int nroCuenta, Cuenta cuenta) {
		super(nombre, dni, pin, rol);
		this.nroCuenta = nroCuenta;
		this.cuenta = cuenta;
	}

	
	public int getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	
	
	public Cuenta getCuenta() {
		return cuenta;
	}


	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	
	@Override
	public String toString() {
		return "Cliente [nroCuenta=" + nroCuenta + ", cuenta=" + cuenta + ", toString()=" + super.toString() + "]";
	}


	//REESCRIBO ESTE METODO PERO CON OTRO CONTEXTO EN CLIENTE
	@Override
	public void Menu(Cajero cajero) {
		String[] operacion = {
				"Retirar Dinero",
				"Depositar Dinero",
				"Mostrar Operaciones",
				"Salir"
		};
		int operacionElegida = 0;
		
		do {
			
			operacionElegida = JOptionPane.showOptionDialog(null, "Elija operacion:", "Cliente", 0, 0, null, operacion, operacion[0]);
			
			switch (operacionElegida) {
			case 0:
				int montoRetirar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese monto a retirar"));
				this.RetirarDinero(montoRetirar, cajero);
				break;
			case 1:
				int montoDepositar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese monto a depositar"));
				this.DepositarDinero(montoDepositar, cajero);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Cuenta " + this.nroCuenta + "\n Operaciones: "+ this.cuenta.getOperaciones() + " Saldo: " + cuenta.getSaldo() + "\n");
				break;

			case 3:
				JOptionPane.showMessageDialog(null, "No se ha realizado ninguna operacion mas");
				break;
			}
			
		} while (operacionElegida !=3);
	}
	
	
	
	public void RetirarDinero(int monto, Cajero cajero) {
		if (monto > 0 && monto <= this.cuenta.getSaldo()) {
			if (monto <= cajero.getSaldo()) {
				cajero.setSaldo(cajero.getSaldo() - monto); 
				this.cuenta.setSaldo(this.cuenta.getSaldo() - monto);
				cuenta.setOperaciones(cuenta.getOperaciones() + "Retire dinero: Fecha: " + LocalDateTime.now() + " Monto a retirar: " + monto + "\n");
			} else {
				JOptionPane.showMessageDialog(null, "No hay suficiente dinero en el cajero");
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay suficiente dinero en la cuenta");
		}
	}
	
	public void DepositarDinero(int monto, Cajero cajero) {
		if (monto > 0) {
			cajero.setSaldo(cajero.getSaldo() + monto); 
			this.cuenta.setSaldo(this.cuenta.getSaldo() + monto);
			cuenta.setOperaciones(cuenta.getOperaciones() + "Deposite dinero: Fecha: " + LocalDateTime.now() + " Monto a depositar: " + monto + "\n");
		} else {
			JOptionPane.showMessageDialog(null, "No hay suficiente dinero en la cuenta");
		}
		
	}
	
	
}
