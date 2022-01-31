package es.redmetro.dam2.dao;

import java.util.List;

import es.redmetro.dam2.excepciones.RedMetroException;
import es.redmetro.dam2.vo.Linea;

public interface ILineaDao {
	
	public void crear(Linea entidad) throws RedMetroException;
	public void borrar(Linea entidad) throws RedMetroException;
	public void actualizar(Linea entidad) throws RedMetroException;
	public Linea getEntirdadPorID(int idEntidad) throws RedMetroException;
	public List<Linea> getListaEntidades() throws RedMetroException;
	
}
