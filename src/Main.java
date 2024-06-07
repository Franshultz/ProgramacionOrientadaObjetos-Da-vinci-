import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		Equipo[] equipo = new Equipo[7]; 
        LinkedList<Equipo> ListaEquipos = new LinkedList<Equipo>();
        
        String[] clubes = {
            "River Plate",
            "Boca Juniors",
            "Independiente",
            "Racing Club",
            "San Lorenzo",
            "Estudiantes de La Plata",
            "Vélez Sarsfield"
        };

        String[] barrios = {
            "Núñez",           
            "La Boca",         
            "Avellaneda",      
            "Avellaneda",      
            "Boedo",           
            "La Plata",        
            "Liniers"          
        };
        
        String[][] jugadores = {
            {"Franco Armani", "Milton Casco", "Leandro González Pirez", "Paulo Díaz", "Enzo Díaz", "Franco Mastantuono", "Claudio Echeverri ", "Ezequiel Barco", "Ignacio Fernández", "Facundo Colidio", "Miguel Borja"},
            {"Sergio Romero", "Marcelo Weigandt", "Bruno Valdez", "Nicolás Figal", "Frank Fabra", "Guillermo Fernández", "Alan Varela", "Cristian Medina", "Exequiel Zeballos", "Darío Benedetto", "Sebastián Villa"},
            {"Rodrigo Rey", "Patricio Ostachuk", "Sergio Barreto", "Edgar Elizalde", "Damián Pérez", "Iván Marcone", "Lucas Romero", "Juan Cazares", "Tomás Pozzo", "Leandro Benegas", "Martín Cauteruccio"},
            {"Gabriel Arias", "Facundo Mura", "Leonardo Sigali", "Emiliano Insúa", "Gonzalo Piovi", "Juan Nardoni", "Aníbal Moreno", "Jonathan Gómez", "Matías Rojas", "Maximiliano Romero", "Gabriel Hauche"},
            {"Augusto Batalla", "Gino Peruzzi", "Federico Gattoni", "Cristian Zapata", "Nicolás Fernández Mercau", "Jalil Elías", "Néstor Ortigoza", "Nahuel Barrios", "Ezequiel Cerutti", "Adam Bareiro", "Nicolás Blandi"},
            {"Mariano Andújar", "Leonardo Godoy", "Fabián Noguera", "Agustín Rogel", "Emmanuel Mas", "Jorge Rodríguez", "Fernando Zuqui", "Manuel Castro", "Pablo Piatti", "Leandro Díaz", "Mauro Boselli"},
            {"Leonardo Burián", "Tomás Guidara", "Miguel Brizuela", "Matías De Los Santos", "Francisco Ortega", "Santiago Cáseres", "Nicolás Garayalde", "Luca Orellano", "Luca Robertone", "Lucas Janson", "Lucas Pratto"}
        };
        
        String[] posiciones = {"Portero", "Defensor", "Mediocampista", "Delantero"};
        
        
        for (int i = 0; i < 7; i++) {
            equipo[i] = new Equipo(clubes[i], barrios[i]);
            LinkedList<Jugador> ListaJugadores = new LinkedList<Jugador>();

            for (int j = 0; j < 11; j++) {
                String nombre = jugadores[i][j];
                String posicion = "";
               				
                if (jugadores[i][j].equals(jugadores[i][0])) {
            		posicion = posiciones[0];
				} else if (jugadores[i][j].equals(jugadores[i][1]) || 
						jugadores[i][j].equals(jugadores[i][2]) ||
						jugadores[i][j].equals(jugadores[i][3]) ||
						jugadores[i][j].equals(jugadores[i][4])) {
					posicion = posiciones[1];
				} else if (jugadores[i][j].equals(jugadores[i][5]) || 
						jugadores[i][j].equals(jugadores[i][6]) ||
						jugadores[i][j].equals(jugadores[i][7]) ||
						jugadores[i][j].equals(jugadores[i][8])) {
					posicion = posiciones[2];
				} else if(jugadores[i][j].equals(jugadores[i][9]) || 
						jugadores[i][j].equals(jugadores[i][10])) {
					posicion = posiciones[3];
				}    	
                	
                
                int numeroCamiseta = (int)(Math.random() * 98 + 1);
                int edadJugador = (int)(Math.random() * 25 + 15);

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
			
			
			String[] opcionesEquipo = new String[7];
	        for (int i = 0; i < 7; i++) {
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
