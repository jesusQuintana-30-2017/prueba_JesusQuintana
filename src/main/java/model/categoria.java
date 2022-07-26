package model;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class categoria {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "categoria_Sequence")
    @SequenceGenerator(name = "categoria_Sequence", sequenceName = "CATEGORIA_SEQ")
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
