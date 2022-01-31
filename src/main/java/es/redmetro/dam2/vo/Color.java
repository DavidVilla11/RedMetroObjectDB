package es.redmetro.dam2.vo;

import javax.persistence.*;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Entity
@Table(name="T_COLOR")
@JacksonXmlRootElement(localName = "t_color")
public class Color {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cod_color")
	@JacksonXmlProperty(localName ="cod_color")
	private int codigoColor;
	
	@Column(name="nombre")
	@JacksonXmlProperty(localName ="nombre")
	private String nombre;
	
	@Column(name="cod_hexadecimal")
	@JacksonXmlProperty(localName ="cod_hexadecimal")
	private String codigoHexadecimal;
	
//	@OneToOne(mappedBy = "color")
//	private Linea linea;
	
	public int getCodigoColor() {
		return codigoColor;
	}
	public void setCodigoColor(int codigoColor) {
		this.codigoColor = codigoColor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoHexadecimal() {
		return codigoHexadecimal;
	}
	public void setCodigoHexadecimal(String codigoHexadecimal) {
		this.codigoHexadecimal = codigoHexadecimal;
	}
//	public Linea getLinea() {
//		return linea;
//	}
//	public void setLinea(Linea linea) {
//		this.linea = linea;
//	}
	
	@Override
	public String toString() {
		return "Color [codigoColor=" + codigoColor + ", nombre=" + nombre + ", codigoHexadecimal=" + codigoHexadecimal
				+ "]";
	}
	

	
}
