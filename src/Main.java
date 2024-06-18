import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Equipo[] equipos = new Equipo[8];
        LinkedList<Equipo> listaEquipos = new LinkedList<>();
        LinkedList<Equipo> listaEquiposGanadores = new LinkedList<>();
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

        GestorEquipos liga = new GestorEquipos(listaEquipos);

        int eleccionEquipo = 0;
        int eleccionOperacion = 0;

        LinkedList<String> listaOpcionesEquipo = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            listaOpcionesEquipo.add(equipos[i].getNombreClub());
        }
        listaOpcionesEquipo.add("No modificar equipo");

        String[] opcionesEquipo = listaOpcionesEquipo.toArray(new String[0]);

        do {
            eleccionEquipo = JOptionPane.showOptionDialog(null, "Elija un equipo para modificar o ver jugadores", "Menu", 0, 0, null, opcionesEquipo, opcionesEquipo[0]);

            if (eleccionEquipo != 8) {
                String[] operacion = {"Agregar Jugador", "Eliminar Jugador", "Ver cantidad de jugadores", "Obtener lista de jugadores", "Salir"};
                eleccionOperacion = JOptionPane.showOptionDialog(null, "Elija una opcion", "Menu", 0, 0, null, operacion, operacion[0]);

                switch (eleccionOperacion) {
                    case 0:

                        if (equipos[eleccionEquipo].AgregarJugador()) {
                            JOptionPane.showMessageDialog(null, "Se agrego exitosamente el jugador al equipo");
                            JOptionPane.showMessageDialog(null, equipos[eleccionEquipo].toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "No se agrego ningun jugador al equipo");
                        }
                        break;

                    case 1:

                        if (equipos[eleccionEquipo].EliminarJugador()) {
                            JOptionPane.showMessageDialog(null, "Se elimino exitosamente el jugador del equipo");
                            JOptionPane.showMessageDialog(null, equipos[eleccionEquipo].toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "No se elimino ningun jugador del equipo");
                        }
                        break;

                    case 2:

                        JOptionPane.showMessageDialog(null, "El " + equipos[eleccionEquipo].getNombreClub() +
                                " tiene " + equipos[eleccionEquipo].CantidadJugadores() + " jugadores");
                        break;

                    case 3:

                        JOptionPane.showMessageDialog(null, "Lista de jugadores: \n" + equipos[eleccionEquipo].ObtenerListaJugadores());
                        break;

                    case 4:

                        JOptionPane.showMessageDialog(null, "No se realizo ninguna modificacion en " + equipos[eleccionEquipo].getNombreClub());
                        break;

                    default:

                        break;

                }

            } else {
                JOptionPane.showMessageDialog(null, "No se modifico ningun equipo");

            }
        } while (eleccionEquipo != 8);

        int eleccionEquipos = 0;
        do {
            String[] opciones = {"Agregar equipo", "Eliminar equipo", "Ver cantidad de equipos", "Ver lista de equipos", "Salir"};
            eleccionEquipos = JOptionPane.showOptionDialog(null, "¿Desea agregar algun equipo a la liga?", "Partidos", 0, 0, null, opciones, opciones[0]);

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

                    JOptionPane.showMessageDialog(null, "La liga tiene " + liga.CantidadEquipos() + " equipos");
                    break;

                case 3:

                    JOptionPane.showMessageDialog(null, "Lista de equipos: \n" + liga.ObtenerListaEquipos());
                    break;

                case 4:

                    JOptionPane.showMessageDialog(null, "No se realizo ninguna operacion");
                    break;

                default:
                    break;
            }

        } while (eleccionEquipos != 4);

        int eleccion = 0;

        String[] opciones = {"Comenzar partidos", "Ver partidos", "Ver Goleador", "Salir"};
        do {	
        	eleccion = JOptionPane.showOptionDialog(null, "Elija una opcion", "Partidos", 0, 0, null, opciones, opciones[0]);
        	if (eleccion == 0) {
        		if(Partido.getCantPartidos() >= 6){
        			Partido jugado = liga.JugarPartido(seleccionarEquipo(listaEquiposFinalistas), seleccionarEquipo(listaEquiposFinalistas));
        			JOptionPane.showMessageDialog(null,"Ganador: " + jugado.DeterminarGanador());	
        			liga.getPartidos().add(jugado);
        			JOptionPane.showMessageDialog(null, "El ganador de la final es: " + jugado);
        		} else if (Partido.getCantPartidos() >= 4 ) {
					Partido jugado = liga.JugarPartido(seleccionarEquipo(listaEquiposGanadores), seleccionarEquipo(listaEquiposGanadores));
					liga.getPartidos().add(jugado);
					JOptionPane.showMessageDialog(null,"Se jugo el partido: " + jugado);
					JOptionPane.showMessageDialog(null,"Ganador: " + jugado.DeterminarGanador());	
					listaEquiposFinalistas.add(jugado.DeterminarGanador());

				} else {
					Partido jugado = liga.JugarPartido(seleccionarEquipo(liga.getEquipos()), seleccionarEquipo(liga.getEquipos()));
					liga.getPartidos().add(jugado);
					JOptionPane.showMessageDialog(null,"Se jugo el partido: " + jugado);
					JOptionPane.showMessageDialog(null,"Ganador: " + jugado.DeterminarGanador());	
					listaEquiposGanadores.add(jugado.DeterminarGanador());
				}
        			
        	} else if (eleccion == 1) {
        		JOptionPane.showMessageDialog(null, "Lista de Partidos: " + liga.getPartidos());
        		JOptionPane.showMessageDialog(null, "Lista de Ganadores: " + listaEquiposGanadores);
        		JOptionPane.showMessageDialog(null, "Lista de Finalistas: " + listaEquiposFinalistas);
        	} else if (eleccion == 2) {
        		JOptionPane.showMessageDialog(null, "El goleador es: " + liga.VerGoleador());
        	}
		} while (eleccion != 3);

    }
    
    public static Equipo seleccionarEquipo(LinkedList<Equipo> equipos) {
    	String[] equiposArray  = new String[equipos.size()];   
    	for (int i = 0; i < equipos.size(); i++) {
			equiposArray[i] = equipos.get(i).getNombreClub();
		}
    	int opcion = JOptionPane.showOptionDialog(null, "Seleccione equipo", "Partidos", 0, 0, null, equiposArray, equiposArray[0]);
    	Equipo seleccionado = equipos.get(opcion);
    	equipos.remove(opcion);
    	return seleccionado;
    }
}
