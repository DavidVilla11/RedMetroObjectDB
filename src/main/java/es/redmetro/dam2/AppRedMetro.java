package es.redmetro.dam2;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.redmetro.dam2.dao.IBaseGeneralDao;
import es.redmetro.dam2.dao.IColorDao;
import es.redmetro.dam2.dao.ILineaDao;
import es.redmetro.dam2.dao.apoyoproc.LineaApoyo;
import es.redmetro.dam2.dao.jpa.ColorDaoJPA;
import es.redmetro.dam2.dao.jpa.LineaDaoJPA;
import es.redmetro.dam2.excepciones.RedMetroException;
import es.redmetro.dam2.procesos.ConvertirUrlAImagen;
import es.redmetro.dam2.utilidades.UtilidadHibernate;
import es.redmetro.dam2.utilidades.UtilidadJackson;
import es.redmetro.dam2.vo.Color;
import es.redmetro.dam2.vo.Linea;

public class AppRedMetro {
	
	private static IColorDao ColorDao = null;
	private static ILineaDao LineaDao = null;
	
	public static void main(String[] args) throws RedMetroException{
				
		
		/*try {
			ColorDao = new ColorDaoJPA();
			List<Color> listaColores = UtilidadJackson.XmlToColor();
			
			for(Color item: listaColores) {
		    	Color colorxml = new Color();
		    	colorxml.setCodigoColor(item.getCodigoColor());
		    	colorxml.setCodigoHexadecimal(item.getCodigoHexadecimal());
		    	colorxml.setNombre(item.getNombre());
		    	ColorDao.crear(colorxml);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
		ColorDao = new ColorDaoJPA();
		LineaDao = new LineaDaoJPA();
		List<LineaApoyo> listaLineas = UtilidadJackson.XmlToLinea();
		
			for(LineaApoyo item: listaLineas) {
		    	Linea lineaxml = new Linea();
			    lineaxml.setCodigoLinea(item.getCodigoLinea());
			    lineaxml.setNombreCorto(item.getNombreCorto());
			    lineaxml.setNombreLargo(item.getNombreLargo());
			    lineaxml.setKilometros(item.getKilometros());
			    lineaxml.setColor(ColorDao.getEntirdadPorID(item.getColor()));
			    lineaxml.setImagenLinea(ConvertirUrlAImagen.getBytesFromURL(item.getUrl()));
			    LineaDao.crear(lineaxml);
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		/*List<Tren> Trenes = new ArrayList<Tren>();
		List<Acceso> Accesos = new ArrayList<Acceso>();
		List<Estacion> Estaciones = new ArrayList<Estacion>();
		
		TrenHibernateDao tren = new TrenHibernateDao();
		AccesoHibernateDao acceso = new AccesoHibernateDao();
		EstacionHibernateDao estacion = new EstacionHibernateDao();
		
		
		APPPruebaFTP.LecturaFilezillaAcceso(Accesos);
		APPPruebaFTP.LecturaFilezillaEstaciones(Estaciones);
		APPPruebaFTP.LecturaFilezillaTrenes(Trenes);
		
		for(Tren item : Trenes) {
			tren.crear(item);
		}
		
		for(Acceso item : Accesos) {
			acceso.crear(item);
		}
		
		for(Estacion item : Estaciones) {
			estacion.crear(item);
		}*/
	}

}

