import java.util.LinkedList;

public class Equipo {
	
	private  String nombreClub;
	private  String ciudad;
	private  LinkedList Jugadores;
	
	public Equipo(String nombreClub, String ciudad, LinkedList jugadores) {
		this.nombreClub = nombreClub;
		this.ciudad = ciudad;
		Jugadores = jugadores;
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

	public LinkedList getJugadores() {
		return Jugadores;
	}

	public void setJugadores(LinkedList jugadores) {
		Jugadores = jugadores;
	}

	@Override
	public String toString() {
		return "Equipo [nombreClub=" + nombreClub + ", ciudad=" + ciudad + ", Jugadores=" + Jugadores + "]";
	}
	
	
	
	
	
	
}
