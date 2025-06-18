package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.controladores;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Producto;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.servicios.ProductoSrvc;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProveedorDatosListaProductoImpl implements IProveedorDatosLista{

    private final ProductoSrvc productoSrvc;

    public ProveedorDatosListaProductoImpl(ProductoSrvc productoSrvc) {
        this.productoSrvc = productoSrvc;
    }


    @Override
    public String getTitulo() {
        return "Lista Productos";
    }

    @Override
    public List<String> getCabeceras() {
        return List.of("Codigo", "Nombre", "proveedor", "precio venta");
    }

    @Override
    public List<Map<String, Object>> getFilas() {
        List<Producto> productos = productoSrvc.listarProductos();
        List<Map<String, Object>> filas = new ArrayList<>();
        for (Producto producto : productos) {
            Map<String, Object> fila = new LinkedHashMap<>();
            fila.put("id", producto.getCodigoProducto());
            fila.put("nombre", producto.getNombre());
            fila.put("proveedor", producto.getProveedor());
            fila.put("precio venta", producto.getPrecioVenta());
            filas.add(fila);
        }

        return filas;
    }

    @Override
    public String getNombreEntidad() {
        return "Producto";
    }
}
