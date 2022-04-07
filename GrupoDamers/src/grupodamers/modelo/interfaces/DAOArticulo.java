package grupodamers.modelo.interfaces;

import grupodamers.modelo.Articulo;

public interface DAOArticulo {

	public void addArticulo(Articulo articulo) throws Exception;
	public void deleteArticulo(Articulo articulo) throws Exception;
	public void getNumeroArticulos() throws Exception;
	public void existeArticulo(Articulo articulo) throws Exception;
	public void getArticuloByCodigo(String codigo) throws Exception;
	public void getListaArticulos() throws Exception;
	
}
