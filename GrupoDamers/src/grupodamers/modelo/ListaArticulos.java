package grupodamers.modelo;

public class ListaArticulos extends Lista<Articulo> {
	
	/**
	 * Metodo que añade un articulo a la lista de articulos
	 */

	public void addElement(Articulo articulo) throws Exception{
		if (existe(articulo.getCodigo())) {
			throw new Exception("\n*** El articulo introducido ya existe en la BBDD. ***\n");
		} else {
			this.lista.add(articulo);
		}
	}
	
	/**
	 * Metodo que comprueba si existe un articulo
	 * @return boolean existe
	 */
	
	public boolean existe(String codigoArt) {
		boolean existe = false;
		
		for (Articulo articulo: this.lista) {
			if (articulo.getCodigo().equals(codigoArt)) {
				existe = true;
				return existe;
			}
		}
		return existe;
	}
	
	/**
	 * Metodo que devuelve un articulo dado un codigo de articulo
	 * @return articulo
	 */
	
	public Articulo getArticuloByCodigo(String codigo) {
		Articulo articulo = new Articulo();
		
		for (Articulo a: this.lista) {
			if (a.getCodigo().equals(codigo)) {
				articulo = a;
				break;
			}
		}
		return articulo;
	}

}
