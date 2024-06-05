import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Equipo {
	
	private  String nombreClub;
	private  String ciudad;
	private LinkedList<Jugador> jugadores;
	
	public Equipo(String nombreClub, String ciudad) {
		this.nombreClub = nombreClub;
		this.ciudad = ciudad;
		this.jugadores = new LinkedList<>();
	}

	public String getNombreClub() {
		return nombreClub;
	}

	public void setNombreClub(String nombreClub) {
		this.nombreClub = nombreClub;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public LinkedList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(LinkedList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

	

	
	@Override
	public String toString() {
		return "Equipo [nombreClub=" + nombreClub + ", ciudad=" + ciudad + ", jugadores=" + jugadores +"]";
	}

	//AGREGO EQUIPO ENTERO
	public void AgregarListaJugadores(LinkedList<Jugador> ListaJugadores) {
        this.setJugadores(ListaJugadores);
    }
	
	
	//AGREGO JUGADOR ESPECIFICO
	public boolean AgregarJugador() {
		 String nombre = JOptionPane.showInputDialog("Ingrese nombre del jugador nuevo");
		 String posicion = JOptionPane.showInputDialog("Ingrese posicion del jugador nuevo");
		 String numeroCamiseta = JOptionPane.showInputDialog("Ingrese el numero de camiseta del jugador nuevo");
		 String edadJugador = JOptionPane.showInputDialog("Ingrese la edad del jugador nuevo");
		 Jugador jugadorNuevo = new Jugador(nombre, posicion, numeroCamiseta, edadJugador);
		    
		 LinkedList<Jugador> ListaJugadores = getJugadores();	    
		 if (ListaJugadores.add(jugadorNuevo)) {
			 setJugadores(ListaJugadores);
			 return true;
		} else {
			return false;
		}
	}
	
	
	//ELIMINO JUGADOR ESPECIFICO
	public boolean EliminarJugador() {
        String[] nombresJugadoresEliminar = new String[jugadores.size()];
        int i = 0;
        for (Jugador jugador : jugadores) {
            nombresJugadoresEliminar[i] = jugador.getNombre();
            i++;
        }

        String seleccionJugadorEliminar = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:", "Menú", JOptionPane.QUESTION_MESSAGE, null, nombresJugadoresEliminar, nombresJugadoresEliminar[0]);
        if (seleccionJugadorEliminar != null) {
            for (int index = 0; index < jugadores.size(); index++) {
                if (jugadores.get(index).getNombre().equals(seleccionJugadorEliminar)) {
                    jugadores.remove(index);
                    break;
                }
            }
            setJugadores(jugadores); // Actualizar la lista de jugadores del equipo después de la eliminación
            return true;
        } else {
            return false;
        }
    }
	
	
	public int CantidadJugadores() {
		int cantidadJugadores = getJugadores().size();
		return cantidadJugadores;
	}     
	
	
}
