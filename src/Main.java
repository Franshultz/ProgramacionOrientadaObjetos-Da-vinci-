import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Equipo[] equipos = new Equipo[8];
        LinkedList<Equipo> listaEquipos = new LinkedList<>();
        LinkedList<Equipo> listaEquiposSemifinalistas = new LinkedList<>();
        LinkedList<Equipo> listaEquiposFinalistas = new LinkedList<>();

        String[] clubes = {
            "River Plate",
            "Boca Juniors",
            "Independiente",
            "Racing Club",
            "San Lorenzo",
            "Estudiantes de La Plata",
            "Vélez Sarsfield",
            "Newell's Old Boys"
        };

        String[] barrios = {
            "Núñez",
            "La Boca",
            "Avellaneda",
            "Avellaneda",
            "Boedo",
            "La Plata",
            "Liniers",
            "Rosario"
        };

        String[][] jugadores = {
            {"Franco Armani", "Milton Casco", "Leandro González Pirez", "Paulo Díaz", "Enzo Díaz", "Franco Mastantuono", "Claudio Echeverri ", "Ezequiel Barco", "Ignacio Fernández", "Facundo Colidio", "Miguel Borja"},
            {"Sergio Romero", "Marcelo Weigandt", "Bruno Valdez", "Nicolás Figal", "Frank Fabra", "Guillermo Fernández", "Alan Varela", "Cristian Medina", "Exequiel Zeballos", "Darío Benedetto", "Sebastián Villa"},
            {"Rodrigo Rey", "Patricio Ostachuk", "Sergio Barreto", "Edgar Elizalde", "Damián Pérez", "Iván Marcone", "Lucas Romero", "Juan Cazares", "Tomás Pozzo", "Leandro Benegas", "Martín Cauteruccio"},
            {"Gabriel Arias", "Facundo Mura", "Leonardo Sigali", "Emiliano Insúa", "Gonzalo Piovi", "Juan Nardoni", "Aníbal Moreno", "Jonathan Gómez", "Matías Rojas", "Maximiliano Romero", "Gabriel Hauche"},
            {"Augusto Batalla", "Gino Peruzzi", "Federico Gattoni", "Cristian Zapata", "Nicolás Fernández Mercau", "Jalil Elías", "Néstor Ortigoza", "Nahuel Barrios", "Ezequiel Cerutti", "Adam Bareiro", "Nicolás Blandi"},
            {"Mariano Andújar", "Leonardo Godoy", "Fabián Noguera", "Agustín Rogel", "Emmanuel Mas", "Jorge Rodríguez", "Fernando Zuqui", "Manuel Castro", "Pablo Piatti", "Leandro Díaz", "Mauro Boselli"},
            {"Leonardo Burián", "Tomás Guidara", "Miguel Brizuela", "Matías De Los Santos", "Francisco Ortega", "Santiago Cáseres", "Nicolás Garayalde", "Luca Orellano", "Luca Robertone", "Lucas Janson", "Lucas Pratto"},
            {"Alan Aguerre", "Facundo Nadalín", "Manuel Guanini", "Juan Manuel Requena", "Franco Negri", "Pablo Pérez", "Mauro Formica","Maxi Rodríguez", "Jerónimo Cacciabue", "Ignacio Scocco", "Nicolás Castro"}
        };

        String[] posiciones = {"Portero", "Defensor", "Mediocampista", "Delantero"};

        for (int i = 0; i < 8; i++) {
            equipos[i] = new Equipo(clubes[i], barrios[i]);
            LinkedList<Jugador> listaJugadores = new LinkedList<>();

            for (int j = 0; j < 11; j++) {
                String nombre = jugadores[i][j];
                String posicion = "";

                if (j == 0) {
                    posicion = posiciones[0];
                } else if (j >= 1 && j <= 4) {
                    posicion = posiciones[1];
                } else if (j >= 5 && j <= 8) {
                    posicion = posiciones[2];
                } else {
                    posicion = posiciones[3];
                }

                int numeroCamiseta = (int) (Math.random() * 98 + 1);
                int edadJugador = (int) (Math.random() * 25 + 15);

                Jugador jugador = new Jugador(nombre, posicion, numeroCamiseta, edadJugador);
                listaJugadores.add(jugador);
            }

            equipos[i].setJugadores(listaJugadores);
            listaEquipos.add(equipos[i]);
        }

        GestorEquipos torneo = new GestorEquipos(listaEquipos);
        
        
        
        
        
        //COMIENZO CON LOS METODOS Y FUNCIONES DE MAIN

        
        
        int eleccionOperacionTorneo = 4;   
        int eleccionOperacionEquipo = 4;
        do {
        	do {
        		String[] opcionOperacionesTorneo = {"Agregar equipo", "Eliminar equipo", "Ver cantidad de equipos", "Ver lista de equipos", "Salir"};
        		eleccionOperacionTorneo = JOptionPane.showOptionDialog(null, "¿Desea realizar alguna operacion de algun equipo del torneo?", "Partidos", 0, 0, null, opcionOperacionesTorneo, opcionOperacionesTorneo[0]);
        		
        		switch (eleccionOperacionTorneo) {
        		case 0:
        			
        			if (torneo.AgregarEquipo()) {
        				JOptionPane.showMessageDialog(null, "Se agrego correctamente el equipo nuevo a la liga");
        			} else {
        				JOptionPane.showMessageDialog(null, "No se agrego el equipo nuevo a la liga");
        			}
        			break;
        			
        		case 1:
        			
        			if (torneo.EliminarEquipo()) {
        				JOptionPane.showMessageDialog(null, "Se elimino correctamente de la liga");
        			} else {
        				JOptionPane.showMessageDialog(null, "No se elimino el equipo de la liga");
        			}
        			break;
        			
        		case 2:
        			
        			JOptionPane.showMessageDialog(null, "La liga tiene " + torneo.CantidadEquipos() + " equipos");
        			break;
        			
        		case 3:
        			
        			String[] listaEquiposVer = torneo.ObtenerListaEquipos();
        			JOptionPane.showMessageDialog(null, listaEquiposVer);
        			break;
        			
        		case 4:
        			
        			JOptionPane.showMessageDialog(null, "No se quiere realizar ninguna operacion");
        			break;
        			
        		default:
        			break;
        		}
				
			} while (eleccionOperacionTorneo != 4);
            
            

            
            Equipo eleccionEquipo = null;
            do {
                eleccionEquipo = SeleccionarEquipo(torneo.getEquipos(), "operaciones");

                if (eleccionEquipo != null) {
                    String[] operacion = {"Agregar Jugador", "Eliminar Jugador", "Ver cantidad de jugadores", "Obtener lista de jugadores", "Salir"};
                    eleccionOperacionEquipo = JOptionPane.showOptionDialog(null, "Elija una opcion", "Menu", 0, 0, null, operacion, operacion[0]);

                    switch (eleccionOperacionEquipo) {
                        case 0:

                            if (eleccionEquipo.AgregarJugador()) {
                                JOptionPane.showMessageDialog(null, "Se agrego exitosamente el jugador al equipo");
                                JOptionPane.showMessageDialog(null, eleccionEquipo.toString());
                            } else {
                                JOptionPane.showMessageDialog(null, "No se agrego ningun jugador al equipo");
                            }
                            break;

                        case 1:

                            if (eleccionEquipo.EliminarJugador()) {
                                JOptionPane.showMessageDialog(null, "Se elimino exitosamente el jugador del equipo");
                                JOptionPane.showMessageDialog(null, eleccionEquipo.toString());
                            } else {
                                JOptionPane.showMessageDialog(null, "No se elimino ningun jugador del equipo");
                            }
                            break;

                        case 2:

                            JOptionPane.showMessageDialog(null, "El " + eleccionEquipo.getNombreClub() +
                                    " tiene " + eleccionEquipo.CantidadJugadores() + " jugadores");
                            break;

                        case 3:

                            JOptionPane.showMessageDialog(null, "Lista de jugadores: \n" + eleccionEquipo.ObtenerListaJugadores());
                            break;

                        case 4:

                            JOptionPane.showMessageDialog(null, "No se realizo ninguna modificacion en " + eleccionEquipo.getNombreClub());
                            break;

                        default:

                            break;

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No se modifico ningun equipo");
                    eleccionOperacionEquipo = 4;
                }
            } while (eleccionOperacionEquipo != 4);
            
            

        } while (eleccionOperacionTorneo != 4 && eleccionOperacionEquipo != 4);
        
        

        int eleccion = 0;
        do {	
        	String[] opciones = {"Comenzar partido", "Ver partidos", "Ver Goleador", "Salir"};
        	eleccion = JOptionPane.showOptionDialog(null, "Elija una opcion", "Partidos", 0, 0, null, opciones, opciones[0]);
        	switch (eleccion) {
			case 0:
				
				if(Partido.getCantPartidos() > 6){
        			Partido jugado = torneo.JugarPartido(SeleccionarEquipo(listaEquiposFinalistas, "partidos"), SeleccionarEquipo(listaEquiposFinalistas, "partidos"));
        			torneo.getPartidos().add(jugado);
        			JOptionPane.showMessageDialog(null, "Partido finalizado: " + jugado);
        			JOptionPane.showMessageDialog(null, "Ganador de la final es: " + jugado.DeterminarGanador().getNombreClub());	
        			
        		} else if (Partido.getCantPartidos() > 4 ) {
					Partido jugado = torneo.JugarPartido(SeleccionarEquipo(listaEquiposSemifinalistas, "partidos"), SeleccionarEquipo(listaEquiposSemifinalistas, "partidos"));
					torneo.getPartidos().add(jugado);
					listaEquiposFinalistas.add(jugado.DeterminarGanador());
					JOptionPane.showMessageDialog(null,"Partido finalizado: " + jugado);
					JOptionPane.showMessageDialog(null,"Ganador de la semifinal es: " + jugado.DeterminarGanador().getNombreClub());	

				} else {
					Partido jugado = torneo.JugarPartido(SeleccionarEquipo(torneo.getEquipos(), "partidos"), SeleccionarEquipo(torneo.getEquipos(), "partidos"));
					torneo.getPartidos().add(jugado);
					listaEquiposSemifinalistas.add(jugado.DeterminarGanador());
					JOptionPane.showMessageDialog(null,"Partido finalizado: " + jugado);
					JOptionPane.showMessageDialog(null,"Ganador de los cuartos de final es: " + jugado.DeterminarGanador().getNombreClub());	
					
				}
				break;
				
			case 1:
				JOptionPane.showMessageDialog(null, "Lista de Partidos: " + torneo.getPartidos());        	
				break;
				
			case 2:
				JOptionPane.showMessageDialog(null, "El goleador es: " + torneo.VerGoleador());
				break;
				
			case 3:
				JOptionPane.showMessageDialog(null, "Se ha terminado el toreno");
				break;

			default:
				break;
				
			}
        	
		} while (eleccion != 3);

    }
     
    public static Equipo SeleccionarEquipo(LinkedList<Equipo> equipos, String llamado) {

    	String[] equiposArray  = new String[equipos.size()]; 
    	if ("operaciones".equals(llamado)) {
    		String[] equiposArray2 = new String[equiposArray.length + 1];
    		for (int i = 0; i < equipos.size(); i++) {
    			equiposArray2[i] = equipos.get(i).getNombreClub();
			}
    		equiposArray2[equiposArray2.length -1] = "Salir";
    		
    		int opcion = JOptionPane.showOptionDialog(null, "Seleccione equipo que desea modificar o ver jugadores", "Gestion de equipos", 0, 0, null, equiposArray2, equiposArray2[0]);
    		if (opcion == 8) {
				return null;
				
			} else {
				Equipo seleccionado = equipos.get(opcion);
				return seleccionado;
				
			}
    		
		} else if ("partidos".equals(llamado)) {
			
	    	for (int i = 0; i < equipos.size(); i++) {
				equiposArray[i] = equipos.get(i).getNombreClub();
			}
			int opcion = JOptionPane.showOptionDialog(null, "Seleccione equipo", "Partidos", 0, 0, null, equiposArray, equiposArray[0]);
			Equipo seleccionado = equipos.get(opcion);
			equipos.remove(opcion);
			return seleccionado;
	    }
    	return null;
    	
    }
}
