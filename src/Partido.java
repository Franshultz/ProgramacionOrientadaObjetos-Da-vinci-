import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Partido {

    private Equipo equipo1;
    private Equipo equipo2;
    private int goles1;
    private int goles2;
    private int penales1;
    private int penales2;
    private String fase;
    private LocalDate fecha;
    private String estado;
    private static int cantPartidos;

    public Partido(Equipo equipo1, Equipo equipo2, int goles1, int goles2, int penales1, int penales2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.goles1 = goles1;
        this.goles2 = goles2;
        this.penales1 = penales1;
        this.penales2 = penales2;
        this.fase = determinarFase();
        this.fecha = determinarFecha();
        this.estado = "Pendiente";
        cantPartidos++;
    }

    public Equipo getEquipo1() {
		return equipo1;
	}



	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}



	public Equipo getEquipo2() {
		return equipo2;
	}



	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}



	public int getGoles1() {
		return goles1;
	}



	public void setGoles1(int goles1) {
		this.goles1 = goles1;
	}



	public int getGoles2() {
		return goles2;
	}



	public void setGoles2(int goles2) {
		this.goles2 = goles2;
	}
	

	public int getPenales1() {
		return penales1;
	}

	public void setPenales1(int penales1) {
		this.penales1 = penales1;
	}

	public int getPenales2() {
		return penales2;
	}

	public void setPenales2(int penales2) {
		this.penales2 = penales2;
	}

	public String getFase() {
		return fase;
	}



	public void setFase(String fase) {
		this.fase = fase;
	}



	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public static int getCantPartidos() {
		return cantPartidos;
	}



	public static void setCantPartidos(int cantPartidos) {
		Partido.cantPartidos = cantPartidos;
	}



	@Override
    public String toString() {
        return "" + equipo1.getNombreClub() + " " + goles1 + " - " + goles2 + " " + equipo2.getNombreClub() + 
                 ", fase=" + fase + ", fecha=" + fecha + ", estado=" + estado + "\n";
    }
	

    public String determinarFase() {
        if (cantPartidos < 4) {
            return "Cuartos de final";
        } else if (cantPartidos < 6) {
            return "Semifinal";
        } else if (cantPartidos < 7) {
            return "Final";
        }
        return "null";
    }

    public LocalDate determinarFecha() {
        switch (fase.toLowerCase()) {
            case "cuartos de final":
                return LocalDate.of(2024, 6, 20);
            case "semifinal":
                return LocalDate.of(2024, 6, 27);
            case "final":
                return LocalDate.of(2024, 7, 4);
            default:
                return LocalDate.now();
        }
    }
    
    public Equipo DeterminarGanador() {
    	
    	if (this.getGoles1() > this.getGoles2()) {
    		this.setEstado("Jugado");
			return this.getEquipo1();
		} else if (this.getGoles1() < this.getGoles2()) {
			this.setEstado("Jugado");
			return this.getEquipo2();
		} else {
			if (this.getPenales1() > this.getPenales2()) {
				this.setEstado("Jugado");
				return this.getEquipo1();
			} else if (this.getPenales1() < this.getPenales2()){
				this.setEstado("Jugado");
				return this.getEquipo2();
			}
		}
    	return null;
    }
}
