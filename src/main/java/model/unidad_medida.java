package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "unidad_medida")
public class unidad_medida {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "unidad_medida_Sequence")
    @SequenceGenerator(name = "unidad_medida_Sequence", sequenceName = "UNIDAD_MEDIA_SEQ")
	private Integer id;
	
	@Column(name="descripcion")
	private String descripcion;
	
	public Integer getId() {
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

}
