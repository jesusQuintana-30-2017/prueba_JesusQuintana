package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.producto;
import repository.ProductoRepository;

@CrossOrigin(origins = "http://localhost:8082/prueba")
@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@GetMapping("/productos")
	public ResponseEntity<List<producto>> getAllproductos(@RequestParam(required = false) int id) 
	{
		try 
		{
			List<producto> productos = new ArrayList<producto>();
			if (id == 0)
				productoRepository.findAll().forEach(productos::add);
			else
				productoRepository.getByProductoCategoria(id).forEach(productos::add);
			if (productos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(productos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/productos/{id}")
	public ResponseEntity<producto> getproductoById(@PathVariable("id") long id) {
		Optional<producto> productoData = productoRepository.findById((int) id);
		if (productoData.isPresent()) {
			return new ResponseEntity<producto>(productoData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<producto>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/productos")
	public ResponseEntity<producto> createproducto(@RequestBody producto producto) {
		try {
			producto _producto = productoRepository.save(new producto(producto.getId(), producto.getDescripcion(),producto.getPrecio(), producto.getCantidad(),producto.getClave_unica(),producto.getCategoria(),producto.getPrecio_unitario(),producto.getUnidad_medida()));
			return new ResponseEntity<producto>(_producto, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<producto>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/productos/{id}")
	public ResponseEntity<producto> updateproducto(@PathVariable("id") int id, @RequestBody producto producto) {
		Optional<producto> productoData = productoRepository.findById(id);
		if (productoData.isPresent()) {
			producto _producto = productoData.get();
			_producto.setId(producto.getId());
			_producto.setDescripicion(producto.getDescripcion());
			_producto.setPrecio(producto.getPrecio());
			_producto.setCantidad(producto.getCantidad());
			_producto.setClave_unica(producto.getClave_unica());
			_producto.setCategoria(producto.getCategoria());
			_producto.setPrecio_unitario(producto.getPrecio_unitario());
			_producto.setUnidad_medida(producto.getUnidad_medida());
			return new ResponseEntity<producto>(productoRepository.save(_producto), HttpStatus.OK);
		} else {
			return new ResponseEntity<producto>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<producto> deleteproducto(@PathVariable("id") int id) {
		try {
			productoRepository.deleteById(id);
			return new ResponseEntity<producto>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<producto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/productos")
	public ResponseEntity<HttpStatus> deleteAllproductos() {
		try {
			productoRepository.deleteAll();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/productos/getByid")
	public ResponseEntity<producto> getByProductoClave_unica(int id) {
		try {
			producto productos = productoRepository.getByProductoClave_unica(id);
			if (productos!= null) {
				return new ResponseEntity<producto>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<producto>(productos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<producto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
