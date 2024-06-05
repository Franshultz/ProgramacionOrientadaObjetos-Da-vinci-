import java.util.LinkedList;

public class GestorEquipos {
	
	private  LinkedList Equipos;

	public GestorEquipos(LinkedList equipos) {
		Equipos = equipos;
	}

	public LinkedList getEquipos() {
		return Equipos;
	}

	public void setEquipos(LinkedList equipos) {
		Equipos = equipos;
	}

	@Override
	public String toString() {
		return "GestorEquipos [Equipos=" + Equipos + "]";
	}
	
	
	
	
	
	
}
