import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		//CREO EQUIPOS Y JUGADORES
		
		Equipo[] equipo = new Equipo[2];
		LinkedList<Equipo> ListaEquipos = new LinkedList<Equipo>();
		
		for (int i = 0; i < 2; i++) {
			
            String nombreClub = JOptionPane.showInputDialog("Ingrese nombre del Club: ");
            String ciudad = JOptionPane.showInputDialog("Ingrese nombre de la Ciudad del club: ");
            equipo[i] = new Equipo(nombreClub, ciudad);

            LinkedList<Jugador> ListaJugadores = new LinkedList<Jugador>(); 
            for (int index = 0; index < 2; index++) {
                String nombre = JOptionPane.showInputDialog("Ingrese nombre de Jugador: ");
                String posicion = JOptionPane.showInputDialog("Ingrese nombre de Poscicion: ");
                String numeroCamiseta = JOptionPane.showInputDialog("Ingrese Numero de camiseta: ");
                String edadJugador = JOptionPane.showInputDialog("Ingrese Edad de jugador: ");

                Jugador jugador = new Jugador(nombre, posicion, numeroCamiseta, edadJugador);
                ListaJugadores.add(jugador);
            }
            equipo[i].AgregarListaJugadores(ListaJugadores);

            ListaEquipos.add(equipo[i]);
        }
		GestorEquipos liga = new GestorEquipos(ListaEquipos);
		
		
		
		
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
				
				JOptionPane.showMessageDialog(null, "El " + equipo[eleccionEquipo].getNombreClub() +
						" tiene " +  equipo[eleccionEquipo].CantidadJugadores() + " jugadores"); 				
				break;
				
			case 3:
				
				JOptionPane.showMessageDialog(null, "Lista de jugadores: \n" + equipo[eleccionEquipo].getJugadores());
				break;
				
			case 4:
				
				JOptionPane.showMessageDialog(null, "No se realizo ninguna operacion");
				break;
				
			default:
				
				break;
				
			}
			
			
		} while (eleccionOperacion != 4);
		

		
		
		
		int eleccionEquipos = 0;
		do {
			String[] opciones= {"Agregar equipo", "Eliminar equipo", "Ver cantidad de equipos", "Ver lista de equipos", "Salir"};
			eleccionEquipos = JOptionPane.showOptionDialog(null, "¿Desea comenzar los partidos?", "Partidos", 0, 0, null, opciones, opciones[0]);
			
			switch (eleccionEquipos) {
			case 0:
				
				if (liga.AgregarEquipo()) {
					JOptionPane.showMessageDialog(null, "Se agrego correctamente el equipo nuevo a la liga");
				} else {
					JOptionPane.showMessageDialog(null, "No se agrego el equipo nuevo a la liga");
				}
				break;
				
			case 1:
				
				if (liga.EliminarEquipo()) {
					JOptionPane.showMessageDialog(null, "Se elimino correctamente de la liga");
				} else {
					JOptionPane.showMessageDialog(null, "No se elimino el equipo de la liga");
				}
				break;
				
			case 2:
				
				JOptionPane.showMessageDialog(null, "La liga tiene " +  liga.CantidadEquipos() + " equipos");
				break;
				
			case 3:
				
				JOptionPane.showMessageDialog(null, "Lista de equipos: \n" +  liga.ObtenerListaEquipos());
				break;
				
			case 4:
				
				JOptionPane.showMessageDialog(null, "No se realizo ninguna operacion");
				break;

			default:
				break;
			}
			
		} while (eleccionEquipos != 4);
		
		
		
		
		
		int eleccion = 0;
		do {
			String[] opciones= {"Si", "No"};
			eleccion = JOptionPane.showOptionDialog(null, "¿Desea comenzar los partidos?", "Partidos", 0, 0, null, opciones, opciones[0]);
			if (eleccion == 0) {
				JOptionPane.showMessageDialog(null, liga.JugarPartido());
				JOptionPane.showMessageDialog(null, liga.toString());			
			}
			
		} while (eleccion != 1);
		
	}
}
