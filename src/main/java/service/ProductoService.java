package service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import model.producto;

public interface ProductoService {
	
    public HashMap<String,Object> insertProducto(producto Producto);
    public HashMap<String,Object> UpdateProducto(producto Producto);
    public HashMap<String,Object> DeleteProducto(String Clave_unica);
	public Optional<producto> getByProductoClave_unica(Integer Clave_unica);
	public List<producto> getByProductoCategoria(int  Categoria);


}
