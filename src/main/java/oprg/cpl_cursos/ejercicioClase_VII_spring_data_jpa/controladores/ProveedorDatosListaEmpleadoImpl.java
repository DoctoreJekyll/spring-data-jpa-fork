package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.controladores;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Empleado;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.servicios.EmpleadoSrvc;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProveedorDatosListaEmpleadoImpl implements IProveedorDatosLista {

    private final EmpleadoSrvc empleadoSrvc;

    public ProveedorDatosListaEmpleadoImpl(EmpleadoSrvc empleadoSrvc) {
        this.empleadoSrvc = empleadoSrvc;
    }

    @Override
    public String getTitulo() {
        return "Lista de empleados";
    }

    @Override
    public List<String> getCabeceras() {
        return List.of("Codigo", "Nombre", "Apellidos", "Puesto");
    }

    @Override
    public List<Map<String, Object>> getFilas() {
        List<Empleado> empleados = empleadoSrvc.listarEmpleados();

        List<Map<String, Object>> filas = empleados.stream()
                .map(empleado -> {
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("id", empleado.getId());
                    map.put("nombre", empleado.getNombre());
                    map.put("Apellidos", empleado.getApellido1() + ", " + empleado.getApellido2());
                    map.put("Puesto", empleado.getPuesto());
                    return map;
                }).toList();

        return filas;
    }

    @Override
    public String getNombreEntidad() {
        return "empleado";
    }
}
