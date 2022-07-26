package service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import model.producto;
import model.venta;
import repository.ProductoRepository;

@Service
public class ProductoServiceImpl  implements ProductoService {
	
	@Autowired
    private ProductoRepository ProductoRepository;

	public HashMap<String,Object> insertProducto(producto Producto) {
		HashMap<String,Object> resultado =new HashMap<String, Object>();
		try
		{
			ProductoRepository.save(Producto);
			resultado.put("resultado", "ok");
		}
		catch(Exception ex)
		{
			resultado.put("Error", ex.getMessage());
		}
		return resultado;
		
	}

	public HashMap<String,Object> UpdateProducto(producto Producto) {
		HashMap<String,Object> resultado =new HashMap<String, Object>();
		try
		{
			ProductoRepository.save(Producto);
			resultado.put("resultado", "ok");
		}
		catch(Exception ex)
		{
			resultado.put("Error", ex.getMessage());
		}
		return resultado;
		
	}

	public HashMap<String,Object> DeleteProducto(String Clave_unica) {
		HashMap<String,Object> resultado =new HashMap<String, Object>();
		try
		{
			//ProductoRepository.delete(Producto);
			resultado.put("resultado", "ok");
		}
		catch(Exception ex)
		{
			resultado.put("Error", ex.getMessage());
		}
		return resultado;
		
	}


	public List<producto> getByProductoCategoria(int Categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<producto> getByProductoClave_unica(Integer Clave_unica) {
		Optional<producto> prod = ProductoRepository.findById(Clave_unica);
		return prod;
	}
	
	public  HashMap<String,Object> getVenta(venta Venta) {
		HashMap<String,Object> prod = ProductoRepository.getVenta(Venta);
		return prod;
	}

}
