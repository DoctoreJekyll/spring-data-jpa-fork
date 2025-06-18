package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.controladores;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class FactoriaVistaLista {
    // Esta variable contiene el proveedor de datos -tipo ProveedorLista***Impl- para la vista de lista
    private final Map<String, IProveedorDatosLista> mapProveedorLista;

    public FactoriaVistaLista(List<IProveedorDatosLista> proveedorDatosParaLista) {
        // Creamos un mapa donde la clave es el nombre de la entidad y el valor es el proveedor.
        this.mapProveedorLista = proveedorDatosParaLista.stream()
                .collect(Collectors.toMap(IProveedorDatosLista::getNombreEntidad, Function.identity()));
    }

    public Optional<IProveedorDatosLista> getProveedorDatosLista(String nombreEntidad) {
        return Optional.ofNullable(mapProveedorLista.get(nombreEntidad));
    }
}
