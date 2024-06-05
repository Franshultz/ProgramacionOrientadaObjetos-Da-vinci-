import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		//CREO EQUIPOS Y JUGADORES
		Equipo[] equipo = new Equipo[2];
		for (int i = 0; i < 2; i++) {
			LinkedList<Jugador> ListaJugadores = new LinkedList<Jugador>();
			String nombreClub = JOptionPane.showInputDialog("Ingrese nombre del Club: ");
			String ciudad = JOptionPane.showInputDialog("Ingrese nombre de la Ciudad del club: ");
			
			equipo[i] = new Equipo(nombreClub, ciudad);
			Jugador[] jugador = new Jugador[2];
			for (int index= 0; index < 2; index++) {
				String nombre = JOptionPane.showInputDialog("Ingrese nombre de Jugador: ");
				String posicion = JOptionPane.showInputDialog("Ingrese nombre de Poscicion: ");
				String numeroCamiseta = JOptionPane.showInputDialog("Ingrese Numero de camiseta: ");
				String edadJugador = JOptionPane.showInputDialog("Ingrese Edad de jugador: ");
			
				jugador[i] = new Jugador(nombre, posicion, numeroCamiseta, edadJugador);
				ListaJugadores.add(jugador[i]);
		    }
			equipo[i].AgregarListaJugadores(ListaJugadores);
	    }
		
		int eleccionEquipo = 0;
		int eleccionOperacion = 0;
		do {
			
			String[] opcionesEquipo = new String[2];
	        for (int i = 0; i < 2; i++) {
	            opcionesEquipo[i] = equipo[i].getNombreClub();
	        }
	        eleccionEquipo = JOptionPane.showOptionDialog(null, "Elija una opcion", "Menu", 0, 0, null, opcionesEquipo, opcionesEquipo[0]);
			
			String[] operacion= {"Agregar Jugador", "Eliminar Jugador", "Ver cantidad de jugadores", "Obtener lista de jugadores", "Salir"};
			eleccionOperacion = JOptionPane.showOptionDialog(null, "Elija una opcion", "Menu", 0, 0, null, operacion, operacion[0]);
			
			
			switch (eleccionOperacion) {
			case 0:
				if(equipo[eleccionEquipo].AgregarJugador()) {
					JOptionPane.showMessageDialog(null, "Se agrego exitosamente el jugador al equipo");
					JOptionPane.showMessageDialog(null, equipo[eleccionEquipo].toString());
				} else {		
					JOptionPane.showMessageDialog(null, "No se agrego ningun jugador al equipo");
				}
				break;
			case 1:
				if(equipo[eleccionEquipo].EliminarJugador()) {
					JOptionPane.showMessageDialog(null, "Se elimino exitosamente el jugador del equipo");
					JOptionPane.showMessageDialog(null, equipo[eleccionEquipo].toString());
				} else {		
					JOptionPane.showMessageDialog(null, "No se elimino ningun jugador del equipo");
				}
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
				
			default:
				break;
			}
			
			
		} while (eleccionOperacion != 4);
	}

}
