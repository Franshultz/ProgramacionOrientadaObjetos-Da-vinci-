package listas;


import java.util.LinkedList;
import java.util.concurrent.ForkJoinPool;

import javax.swing.JOptionPane;

public class Main {
	 public static void main(String[] args) {
		
		LinkedList<Producto> ListaProductos = new LinkedList<Producto>();
		Producto nuevo = new Producto("Coca cola",200,10);
		
		ListaProductos.add(new Producto("Pepsi",150,10));
		
		ListaProductos.add(nuevo);
		String[] opciones = {
			"Guardar producto","Ver productos","Actualizar","Eliminar","Salir"	
		};
		int opcionElegida ;
		do {
			 opcionElegida = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones[0]);
			switch (opcionElegida) {
			case 0:
				String nombre;
				do {		
					nombre = JOptionPane.showInputDialog("Ingrese nobre del producto");
					if (!nombre.equals("no")) {
						double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio"));
						int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad"));
						//Producto nuevoCreadoPorUsuario = new Producto(nombre,precio,cantidad);
						//ListaProductos.add(nuevoCreadoPorUsuario);
						ListaProductos.add(new Producto(nombre,precio,cantidad));
					} else {
						JOptionPane.showMessageDialog(null, "Saliendo de carga de productos");
					}
				} while (!nombre.equals("no"));
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Productos:" + ListaProductos);
				break;
			case 2:
				Producto seleccionado=  seleccionarProducto(ListaProductos);
				
				for (Producto producto : ListaProductos) {
					if (producto == seleccionado) {
						producto.setCantidad(Integer.parseInt(JOptionPane.showInputDialog( "Ingrese la nueva cantidad del producto")));
						producto.setNombre(JOptionPane.showInputDialog("Elija un nuevo nombre para el producto "));
						producto.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto")));

					}
				}
				break;
			case 3: 
				ListaProductos.remove(seleccionarProducto(ListaProductos));
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Salir");
				break;
			default:
				break;
			}
		} while (opcionElegida!=4);
		

		
		
	}
	 public static Producto seleccionarProducto(LinkedList<Producto> ListaProductos) {
		 String[] productosarray = new String[ListaProductos.size()];
		 Producto seleccionado=null;
			
			for (int i = 0; i < ListaProductos.size(); i++) {
				productosarray[i] = ListaProductos.get(i).getNombre();
			}
			
			String productSelect =(String)JOptionPane.showInputDialog(null, 
					"Elija un producto", null, 0, 
					null, productosarray, productosarray[0]);
			
			JOptionPane.showMessageDialog(null, productSelect);
			for (Producto producto : ListaProductos) {
				if (producto.getNombre().equals(productSelect)) {
					seleccionado = producto;
					break;
				}
			}
			return seleccionado;
	 }
	 
	 
}
