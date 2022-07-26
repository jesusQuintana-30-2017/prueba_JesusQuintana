package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "venta")
public class venta {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "venta_Sequence")
    @SequenceGenerator(name = "venta_Sequence", sequenceName = "VENTA_SEQ")
	private int id;
    
    @Column(name="fecha")
	private String fecha;
    
    @Column(name="vendedor")
   	private String vendedor;
    
    @Column(name="subtotal")
   	private double subtotal;
    
    @Column(name="impuesto")
   	private double impuesto;
    
    @Column(name="total")
   	private double total;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private producto PrOducto;
    
    public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String Fecha) {
		this.fecha = Fecha;
	}
	
	public String getVendedor() {
		return vendedor;
	}

	public void setVendero(String vendedor) {
		this.vendedor = vendedor;
	}
	
	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
