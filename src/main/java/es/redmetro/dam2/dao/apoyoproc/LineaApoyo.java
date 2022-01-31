package es.redmetro.dam2.dao.apoyoproc;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@Entity
@Table(name="T_LINEA")
@JacksonXmlRootElement(localName = "t_linea")
public class LineaApoyo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cod_linea")
	@JacksonXmlProperty(localName ="cod_linea")
	private int codigoLinea;
	
	@Column(name="nombre_corto")
	@JacksonXmlProperty(localName ="nombre_corto")
	private String nombreCorto;
	
	@Column(name="nombre_largo")
	@JacksonXmlProperty(localName ="nombre_largo")
	private String nombreLargo;
	
//	@OneToMany(mappedBy = "codigoEstacion")
//	private Set<Estacion> estaciones;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_color", foreignKey = @ForeignKey(name = "FK_COLORLINEA"))
	@JacksonXmlProperty(localName ="cod_color")
	private int color;
	
	@Column(name="kilometros")
	@JacksonXmlProperty(localName ="kilometros")
	private float kilometros;
	
	@JacksonXmlProperty(localName ="url_img_tmp")
	private String url;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "imagen_linea")
	private byte[] imagenLinea;
	
	
	public int getCodigoLinea() {
		return codigoLinea;
	}
	public void setCodigoLinea(int codigoLinea) {
		this.codigoLinea = codigoLinea;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public String getNombreLargo() {
		return nombreLargo;
	}
	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public float getKilometros() {
		return kilometros;
	}
	public void setKilometros(float kilometros) {
		this.kilometros = kilometros;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public byte[] getImagenLinea() {
		return imagenLinea;
	}
	public void setImagenLinea(byte[] imagenLinea) {
		this.imagenLinea = imagenLinea;
	}
	
	
	
//	public Set<Estacion> getEstaciones() {
//		return estaciones;
//	}
//	public void setEstaciones(Set<Estacion> estaciones) {
//		this.estaciones = estaciones;
//	}
}
