package grupodamers.modelo;

public class ListaArticulos extends Lista<Articulo> {

	public void addElement(Articulo articulo) throws Exception{
		if (existe(articulo.getCodigo())) {
			throw new Exception("El articulo introducido ya existe en la BBDD.");
		} else {
			this.lista.add(articulo);
		}
	}
	
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

}
