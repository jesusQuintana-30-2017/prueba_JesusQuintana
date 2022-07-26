package repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.producto;
import model.venta;

@Repository
public interface ProductoRepository extends JpaRepository<producto, Integer>{
	
	producto getByProductoClave_unica(int producto);
	List<producto> getByProductoCategoria(int Categoria);
	HashMap<String,Object> getVenta(venta Venta);

}
