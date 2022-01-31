package es.redmetro.dam2.utilidades;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import es.redmetro.dam2.dao.apoyoproc.LineaApoyo;
import es.redmetro.dam2.dao.apoyoproc.ListaColores;
import es.redmetro.dam2.dao.apoyoproc.ListaLineas;
import es.redmetro.dam2.vo.Color;

public class UtilidadJackson {
	
	public static List<Color> XmlToColor(){
		
		List<Color> coloresLista = null;
		
		try {
		    XmlMapper xmlMapper = new XmlMapper();
		    String readContent = new String(Files.readAllBytes(Paths.get(GestorConfiguracion.getInfoConfiguracion("ruta.colores.xml"))));
		    ListaColores colores = xmlMapper.readValue(readContent, ListaColores.class);
		    
		    coloresLista = colores.getColores();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return coloresLista;
	}
	
	public static List<LineaApoyo> XmlToLinea(){
		
		List<LineaApoyo> lineaLista = null;
		
		try {
			 XmlMapper xmlMapper = new XmlMapper();
			 String readContent = new String(Files.readString(Paths.get(GestorConfiguracion.getInfoConfiguracion("ruta.lineas_metro.xml")), StandardCharsets.UTF_8));
			 ListaLineas lineas = xmlMapper.readValue(readContent, ListaLineas.class);
			    
			 lineaLista = lineas.getLineas();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return lineaLista;
	}

}
