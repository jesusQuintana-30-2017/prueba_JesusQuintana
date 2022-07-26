package model;
import javax.persistence.*;

@Entity
@Table(name = "producto")
public class producto {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "producto_Sequence")
    @SequenceGenerator(name = "producto_Sequence", sequenceName = "PRODUCTO_SEQ")
	private int id;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="precio")
	private double precio;
	
	@Column(name="cantidad")
	private double cantidad;
	
	@Column(name="clave_unica")
	private String clave_unica;
	
	@Column(name="categoria")
	private int categoria;
	
	@Column(name="precio_unitario")
	private double precio_unitario;
	
	@Column(name="unidad_medida")
	private int unidad_medida;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripicion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	} 
	
	public String getClave_unica() {
		return clave_unica;
	}

	public void setClave_unica(String clave_unica) {
		this.clave_unica = clave_unica;
	} 
	
	public int getCategoria() {
		return categoria;
	}
	
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	public double getPrecio_unitario() {
		return precio_unitario;
	}
	
	public void setPrecio_unitario(double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	
	public int getUnidad_medida() {
		return unidad_medida;
	}
	
	public void setUnidad_medida(int unidad_medida) {
		this.unidad_medida = unidad_medida;
	}
	
	public producto() {
		this.id=0;
		this.descripcion = "";
		this.precio = 0;
		this.cantidad = 0;
		this.clave_unica = "";
		this.categoria = 1;
		this.precio_unitario=0;
		this.unidad_medida=1;
	
	}

	public producto(int id, String descripcion, double precio,
			double cantidad, String clave_unica, int categoria,double precio_unitario,int unidad_medida) 
	{
		this.id=id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.clave_unica = clave_unica;
		this.categoria = categoria;
		this.precio_unitario=precio_unitario;
		this.unidad_medida=unidad_medida;
	}

	

}
