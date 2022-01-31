package es.redmetro.dam2.dao;

import java.util.List;

import es.redmetro.dam2.excepciones.RedMetroException;
import es.redmetro.dam2.vo.Color;

public interface IColorDao {
	
	public void crear(Color entidad) throws RedMetroException;
	public void borrar(Color entidad) throws RedMetroException;
	public void actualizar(Color entidad) throws RedMetroException;
	public Color getEntirdadPorID(int idEntidad) throws RedMetroException;
	public List<Color> getListaEntidades() throws RedMetroException;

}
