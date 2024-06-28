
public class Jugador {

	private  String nombre;
	private  String posicion;
	private  int numeroCamiseta;
	private  int edad;
	private  int gol;
	
    public Jugador(String nombre, String posicion, int numeroCamiseta, int edad) {
		this.nombre = nombre;
		this.posicion = posicion;
		this.numeroCamiseta = numeroCamiseta;
		this.edad = edad;
		this.gol=0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	
	public int getNumeroCamiseta() {
		return numeroCamiseta;
	}

	public void setNumeroCamiseta(int numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	public int getGol() {
        return gol;
    }

    public void setGol(int gol) {
        this.gol = gol;
    }

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", posicion=" + posicion + ", numeroCamiseta=" + numeroCamiseta + ", edad="
				+ edad + ", gol=" + gol + "\n]";
	}

	
	
	
	
	
	
	
}
