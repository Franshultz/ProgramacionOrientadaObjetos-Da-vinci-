import java.util.LinkedList;

import javax.swing.JOptionPane;

public class GestorEquipos {
	
	private LinkedList<Equipo> equipos;

	public GestorEquipos(LinkedList<Equipo> equipos) {
        this.equipos = equipos;
    }

	
	public LinkedList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(LinkedList<Equipo> equipos) {
        this.equipos = equipos;
    }
    
    
	
	@Override
	public String toString() {
		return "GestorEquipos [Equipos=" + equipos + "]";
	}


	
	//METODO PARA JUGAR PARTIDO ENTRE 2 CLUEBS
	public String JugarPartido() {
		
		boolean flag = false;
		int equipoRandom1 = 0;
        int equipoRandom2 = 0;
		while (!flag) {
			 
	        equipoRandom1 = (int) (Math.random() * equipos.size());
	        equipoRandom2 = (int) (Math.random() * equipos.size());

	        if (equipoRandom1 != equipoRandom2) {
	            flag = true;
	        }
	            
	    }

	    Equipo equipo1 = equipos.get(equipoRandom1);
	    Equipo equipo2 = equipos.get(equipoRandom2);
	    
		int golesRandom1 = (int)(Math.random()*4);
		int golesRandom2 = (int)(Math.random()*4);
		
		equipo1.setGoles(equipo1.getGoles() + golesRandom1);
		equipo2.setGoles(equipo2.getGoles() + golesRandom2);
		
		if (golesRandom1 > golesRandom2) {
			equipo1.setPuntos(equipo1.getPuntos() + 3);
		} else if (golesRandom2 > golesRandom1){
			equipo2.setPuntos(equipo2.getPuntos() + 3);
		} else {
			equipo1.setPuntos(equipo1.getPuntos() + 1);
			equipo2.setPuntos(equipo2.getPuntos() + 1);
		}
		
		return "El partido termino: \n" +
		equipo1.getNombreClub() + " " + golesRandom1  + "   " + golesRandom2 + " " + equipo2.getNombreClub();
	}
	
	
	
	//METODO PARA AGREGAR UN EQUIPO CON SUS RESPECTIVOS JUGADORES
	public boolean AgregarEquipo() {
        String nombreClub = JOptionPane.showInputDialog("Ingrese nombre del club que desea agregar a la liga");
        String ciudad = JOptionPane.showInputDialog("Ingrese nombre de la ciudad del club que desea agregar a la liga");
        Equipo nuevoEquipo = new Equipo(nombreClub, ciudad);

        LinkedList<Jugador> ListaJugadores = new LinkedList<>();
        for (int i = 0; i < 11; i++) {
        	boolean flag = false;
            String nombre = JOptionPane.showInputDialog("Ingrese nombre de Jugador: ");
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
	public LinkedList<Equipo> ObtenerListaEquipos() {
		return equipos;
	}
	
	
	
	
	
	
}
