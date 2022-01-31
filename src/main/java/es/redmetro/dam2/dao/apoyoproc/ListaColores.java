package es.redmetro.dam2.dao.apoyoproc;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import es.redmetro.dam2.vo.Color;

public class ListaColores {
	
	@JacksonXmlProperty(localName = "color")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Color> colores;

	public ListaColores() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Color> getColores() {
		return colores;
	}

	public void setColores(List<Color> colores) {
		this.colores = colores;
	}
	
	
	
}
