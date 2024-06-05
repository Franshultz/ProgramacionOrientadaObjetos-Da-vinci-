import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		LinkedList<Jugador> ListaJugadores = new LinkedList<Jugador>();
		for (int i = 0; i < 4; i++) {
			String nombreClub = JOptionPane.showInputDialog("Ingrese nombre del Club: ");
			String ciudad = JOptionPane.showInputDialog("Ingrese nombre de la Ciudad del club: ");
			
			Equipo equipo = new Equipo(nombreClub, ciudad);
			for (int index= 0; index < 11; index++) {
				String nombre = JOptionPane.showInputDialog("Ingrese nombre de Jugador: ");
				String posicion = JOptionPane.showInputDialog("Ingrese nombre de Poscicion: ");
				String numeroCamiseta = JOptionPane.showInputDialog("Ingrese Numero de camiseta: ");
				String edadJugador = JOptionPane.showInputDialog("Ingrese Edad de jugador: ");
			
				Jugador jugador = new Jugador(nombre, posicion, numeroCamiseta, edadJugador);
				ListaJugadores.add(jugador);
		    }
			equipo.AgregarListaJugadores(ListaJugadores);
			
		
	    }
	}

}
