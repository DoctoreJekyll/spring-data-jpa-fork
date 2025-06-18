package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.controladores;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Gama;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.servicios.GamaSrvc;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProveedorDatosListaGamaImpl implements IProveedorDatosLista{

    private final GamaSrvc gamaSrvc;
    public ProveedorDatosListaGamaImpl(GamaSrvc gamaSrvc) {
        this.gamaSrvc = gamaSrvc;
    }

    @Override
    public String getTitulo() {
        return "Lista de gamas";
    }

    @Override
    public List<String> getCabeceras() {
        return List.of("id", "gama", "descripcion");
    }

    @Override
    public List<Map<String, Object>> getFilas() {
        List<Gama> gamas = gamaSrvc.listarGamas();
        List<Map<String, Object>> filas = gamas.stream()
                .map(gama -> {
                    Map<String, Object> fila = new LinkedHashMap<>();
                    fila.put("id", gama.getId());
                    fila.put("gama", gama.getGama());
                    fila.put("descripcion", gama.getDescripcionTexto());
                    return fila;
                }).toList();
        return filas;
    }

    @Override
    public String getNombreEntidad() {
        return "gamas";
    }
}
