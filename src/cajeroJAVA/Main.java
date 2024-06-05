package cajeroJAVA;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		Cajero cajero1 = new Cajero("San luis 3308", 25000.50);
		Cuenta cuenta1 = new Cuenta(2500.50);
		Cuenta cuenta2 = new Cuenta(5500.50);
		Cliente cliente1 = new Cliente("Franco Aparicio", "43917664", "04042002", "cliente", 1, cuenta1);
		Empleado empleado1 = new Empleado("Gamaliel Quiroz", "43917665", "12345678", "empleado",
				"Mantenimiento", "Higiene y Desinfeccion", 3500, cuenta2);
		
		
		String[] rol = {
				"Cliente",
				"Empleado",
				"Salir"
		};		
		int rolElegido = 0;
		
		
		String dni = "";
		String pin = "";
		
		
		do {			
			rolElegido = JOptionPane.showOptionDialog(null, "Elija rol:", "Menu", 0, 0, null, rol, rol[0]);
			
			if (rolElegido != 2) {				
				dni = JOptionPane.showInputDialog("Ingrese su dni para iniciar sesion");
				pin = JOptionPane.showInputDialog("Ingrese su pin para iniciar sesion");
			}
			
			switch (rolElegido) {
			case 0:
				
				if (cliente1.IngresarCajero(dni, pin)) {
					cliente1.Menu(cajero1);
				} else {
					JOptionPane.showMessageDialog(null, "No se pudo ingresar");
				}
				break;
				
			case 1:
				
				if (empleado1.IngresarCajero(dni, pin)) {
					empleado1.Menu(cajero1);
				} else {
					JOptionPane.showMessageDialog(null, "No se pudo ingresar");
				}
				break;
				
			case 2:
				JOptionPane.showMessageDialog(null, "Salir");
				break;
				
			default:
				break;
			}
			
		} while (rolElegido != 2);
		
		
		
	}

}
