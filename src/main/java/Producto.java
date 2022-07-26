

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import clases.HibernateProxyTypeAdapter;
import clases.MapDeserializerDoubleAsIntFix;
import clases.StringAdapter;
import model.producto;
import service.ProductoServiceImpl;

/**
 * Servlet implementation class Producto
 */
public class Producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Producto() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat("dd/MM/yyyy").create();
		ProductoServiceImpl ProductoService= new ProductoServiceImpl();
			
		gsonBuilder.registerTypeAdapter(new TypeToken<producto>(){}.getType(),  new MapDeserializerDoubleAsIntFix());
		gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		gsonBuilder.registerTypeAdapterFactory(StringAdapter.FACTORY);
		
		Gson gson = gsonBuilder.create();
		HashMap<String,Object> resultado = new HashMap<String,Object>();
		try {
			String accion = request.getParameter("accion");
			if(accion.equals("insertar"))
			{
				HashMap<String,Object> Producto = gson.fromJson(request.getParameter("producto"), new TypeToken<HashMap<String,Object>>() {}.getType());
				producto Prod =new producto(Integer.parseInt(Producto.get("id").toString()),Producto.get("descripcion").toString(),Double.parseDouble(Producto.get("precio").toString()),Double.parseDouble(Producto.get("cantidad").toString()),Producto.get("clave_unica").toString(),Integer.parseInt(Producto.get("categoria").toString()),Double.parseDouble(Producto.get("precio_unitario").toString()),Integer.parseInt(Producto.get("unidad_medida").toString().toString()));
				resultado = ProductoService.insertProducto(Prod);
			}
			else if(accion.equals("actulizar"))
			{
				HashMap<String,Object> Producto = gson.fromJson(request.getParameter("producto"), new TypeToken<HashMap<String,Object>>() {}.getType());
				producto Prod =new producto(Integer.parseInt(Producto.get("id").toString()),Producto.get("descripcion").toString(),Double.parseDouble(Producto.get("precio").toString()),Double.parseDouble(Producto.get("cantidad").toString()),Producto.get("clave_unica").toString(),Integer.parseInt(Producto.get("categoria").toString()),Double.parseDouble(Producto.get("precio_unitario").toString()),Integer.parseInt(Producto.get("unidad_medida").toString().toString()));
				resultado = ProductoService.UpdateProducto(Prod);
			}
			else if(accion.equals("eliminar"))
			{
				HashMap<String,Object> Producto = gson.fromJson(request.getParameter("producto"), new TypeToken<HashMap<String,Object>>() {}.getType());

				resultado = ProductoService.DeleteProducto(Producto.get("id").toString());
			}
			else if(accion.equals("consultar"))
			{
				HashMap<String,Object> Producto = gson.fromJson(request.getParameter("producto"), new TypeToken<HashMap<String,Object>>() {}.getType());
				Optional<producto> Prod = ProductoService.getByProductoClave_unica(Integer.parseInt(Producto.get("id").toString()));
				resultado.put("resultado",gson.toJson(Prod));
			}
			else if(accion.equals("venta"))
			{
				HashMap<String,Object> Producto = gson.fromJson(request.getParameter("producto"), new TypeToken<HashMap<String,Object>>() {}.getType());
				Optional<producto> Prod = ProductoService.getByProductoClave_unica(Integer.parseInt(Producto.get("id").toString()));
				resultado.put("resultado",gson.toJson(Prod));
			}
			
		}
		catch(Exception ex)
		{
			resultado.put("error",ex.getMessage());
		}
		finally
		{
			response.getWriter().append(gson.toJson(resultado));
		}
	}

	

}
