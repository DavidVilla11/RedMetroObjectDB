package es.redmetro.dam2.dao.apoyoproc;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import es.redmetro.dam2.vo.Linea;

public class ListaLineas {
	
	@JacksonXmlProperty(localName = "linea")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<LineaApoyo> lineas;

	public ListaLineas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<LineaApoyo> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaApoyo> lineas) {
		this.lineas = lineas;
	}
	
	
	
}
