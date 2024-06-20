 import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class GestorEquipos {
	
	private LinkedList<Equipo> equipos;
	private LinkedList<Partido> partidos = new LinkedList<Partido>();

	public GestorEquipos(LinkedList<Equipo> equipos) {
        this.equipos = equipos;
        this.partidos = new LinkedList<>();
    }


	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}




	public void setEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
	}




	public LinkedList<Partido> getPartidos() {
		return partidos;
	}




	public void setPartidos(LinkedList<Partido> partidos) {
		this.partidos = partidos;
	}




	@Override
	public String toString() {
		return "GestorEquipos [equipos=" + equipos + ", partidos=" + partidos + "\n]";
	}


	//METODO PARA AGREGAR UN EQUIPO CON SUS RESPECTIVOS JUGADORES
	public boolean AgregarEquipo() {
		
		boolean flag = false;
		String nombreClub;
		String ciudad;
		do {
			nombreClub = JOptionPane.showInputDialog("Ingrese nombre del club que desea agregar a la liga");
			if (nombreClub.equals("")) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un nombre para el club");
				flag = false;
			} else {
				JOptionPane.showMessageDialog(null, "El nombre del club es valido");
				flag = true; 
			}
		} while (flag != true);
				
		do {
			ciudad = JOptionPane.showInputDialog("Ingrese nombre de la ciudad del club que desea agregar a la liga");
			if (ciudad.equals("")) {	
				JOptionPane.showMessageDialog(null, "El nombre de la ciudad no es valido");
				flag = false;
			} else {
				JOptionPane.showMessageDialog(null, "El nombre de la ciudad es valido");
				flag = true; 
			}
		} while (flag != true);  
		
		Equipo nuevoEquipo = new Equipo(nombreClub, ciudad);

        LinkedList<Jugador> ListaJugadores = new LinkedList<>();
        for (int i = 0; i < 11; i++) {
        	String nombre;
        	do {
        		nombre = JOptionPane.showInputDialog("Ingrese nombre de Jugador: ");
        		if (nombre.equals("")) {
					JOptionPane.showMessageDialog(null, "El nombre del jugador es invalido");
					flag = false;
				} else {
					JOptionPane.showMessageDialog(null, "El nombre del jugador es valido");
					flag = true;
				}
			} while (flag != true);
        	
            String[] posiciones = {"Portero", "Defensor", "Mediocampista", "Delantero"};
            String posicion = (String) JOptionPane.showInputDialog(null, "Ingrese nombre de Posicion: ", "Posicion", JOptionPane.QUESTION_MESSAGE, null, posiciones, posiciones[0]);;
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

        nuevoEquipo.AgregarListaJugadores(ListaJugadores);
        if (this.equipos.add(nuevoEquipo)) {
        	return true;		
		} else {
			return false;
		}
    }
	
	
	
	//METODO PARA ELIMINAR UN EQUIPO COMPLETO
	public boolean EliminarEquipo() {
		 String[] nombresEquiposEliminar = new String[equipos.size()];
	        int i = 0;
	        for (Equipo equipo : equipos) {
	            nombresEquiposEliminar[i] = equipo.getNombreClub();
	            i++;
	        }

	        String seleccionEquipoEliminar = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:", "Menú", JOptionPane.QUESTION_MESSAGE, null, nombresEquiposEliminar, nombresEquiposEliminar[0]);
	        if (seleccionEquipoEliminar != null) {
	            for (int index = 0; index < equipos.size(); index++) {
	                if (equipos.get(index).getNombreClub().equals(seleccionEquipoEliminar)) {
	                    equipos.remove(index);
	                    break;
	                }
	            }
	            setEquipos(equipos);
	            return true;
	        } else {
	            return false;
	        }
	}

	
	
	//RETORNO CANTIDAD DE EQUIPOS
	public int CantidadEquipos() {
		return equipos.size();
	};
	
	
	//RETORNO LISTA DE EQUIPOS
	public String[] ObtenerListaEquipos() {
		String[] nombresEquipos = new String[equipos.size()];
		for (int i = 0; i < equipos.size(); i++) {
			nombresEquipos[i] = equipos.get(i).getNombreClub();
		}
		return nombresEquipos;
	}
	
	
	public Partido JugarPartido(Equipo equipo1, Equipo equipo2) {
	    if (equipo1 == equipo2) {
	        JOptionPane.showMessageDialog(null, "No se puede jugar partido entre ambos equipos iguales");
	        return null;
	    } else {
	        if (equipo1.getJugadores().size() < 7 || equipo2.getJugadores().size() < 7) {
	            JOptionPane.showMessageDialog(null, "No se puede jugar el partido por falta de jugadores");
	            return null;
	        } else {
	            JOptionPane.showMessageDialog(null, "Se enfrentan " + equipo1.getNombreClub() + " y " + equipo2.getNombreClub());
	            int goles1;
	            int goles2;
	            int goleador1;
	            int goleador2;
	            do {
	                goles1 = (int)(Math.random() * 5);
	                goles2 = (int)(Math.random() * 5);
	                if (goles1 == goles2) {
	                    JOptionPane.showMessageDialog(null, "Hay penales");
	                }
	            } while (goles1 == goles2);

	           
	            goleador1 = (int)(Math.random() * equipo1.getJugadores().size());
	            goleador2 = (int)(Math.random() * equipo2.getJugadores().size());

	            
	            Jugador jugadorGoleador1 = equipo1.getJugadores().get(goleador1);
	            Jugador jugadorGoleador2 = equipo2.getJugadores().get(goleador2);

	            jugadorGoleador1.setGol(jugadorGoleador1.getGol() + goles1);
	            jugadorGoleador2.setGol(jugadorGoleador2.getGol() + goles2);

	            
	            System.out.println("Jugador goleador del equipo 1: " + jugadorGoleador1.getNombre() + " con " + goles1 + " goles.");
	            System.out.println("Jugador goleador del equipo 2: " + jugadorGoleador2.getNombre() + " con " + goles2 + " goles.");

	            return new Partido(equipo1, equipo2, goles1, goles2);
	        }
	    }
	}

	
	public String VerGoleador() {
	    int maxGoles = 0; 
	    String goleadorNombre = "No hay goleador registrado";

	    for (Equipo equipo : equipos) {
	        for (Jugador jugador : equipo.getJugadores()) {
	            if (jugador.getGol() > maxGoles) {
	                maxGoles = jugador.getGol();
	                goleadorNombre = jugador.getNombre();
	            }
	        }
	    }

	    return goleadorNombre;
	}
	
	
}
