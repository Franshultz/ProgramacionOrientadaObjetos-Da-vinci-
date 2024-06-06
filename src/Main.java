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
            	boolean flag = false;
            	
                String nombre = JOptionPane.showInputDialog("Ingrese nombre de Jugador: ");
                
                String[] posiciones = {"Portero", "Defensor", "Mediocampista", "Delantero"};
                String posicion = (String) JOptionPane.showInputDialog(null, "Ingrese nombre de Posicion: ", "Posicion", JOptionPane.QUESTION_MESSAGE, null, posiciones, posiciones[0]);
                
                int numeroCamiseta = 0;
                do {	
                	numeroCamiseta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Numero de camiseta: "));
                	if (numeroCamiseta < 100 && numeroCamiseta > 0) {
						JOptionPane.showMessageDialog(null, "El numero de camiseta es valido");
						flag = true;
					} else {
						JOptionPane.showMessageDialog(null, "El numero de camiseta es invalido");
						flag = false;
					}
				} while (flag != true);
                
                int edadJugador = 0;
                do {
                    edadJugador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Edad de jugador: "));
                    if (edadJugador < 40 && edadJugador > 15) {
						JOptionPane.showMessageDialog(null, "La edad del jugador es valida");
						flag = true;
					} else {
						JOptionPane.showMessageDialog(null, "La edad del jugador es invalida");
						flag = false;
					}
				} while (flag != true);

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
				
				JOptionPane.showMessageDialog(null, "Lista de jugadores: \n" + equipo[eleccionEquipo].ObtenerListaJugadores());
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
				LinkedList<Equipo> fixture = liga.ObtenerListaEquipos();
				
				String puntuaciones = "" ;
				for (Equipo i : fixture) {
					puntuaciones = puntuaciones +  "\nEl club " + i.getNombreClub() + " tiene " + i.getPuntos() +" puntos y " + i.getGoles() + " goles";
		        }
				JOptionPane.showMessageDialog(null, puntuaciones);
			}
			
		} while (eleccion != 1);
		
	}
}
