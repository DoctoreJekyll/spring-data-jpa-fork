package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.servicios;

import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.DTOs.ClienteDTO;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades.Cliente;
import oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.repositorios.ClienteRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteSrvc {

    private final ClienteRepo clienteRepo;

    public ClienteSrvc(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    public List<Cliente> listarTodos(){
        return clienteRepo.findAll();
    }

    public ClienteDTO toDTO(Cliente cliente){
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNombreCliente(),
                cliente.getTelefono(),
                cliente.getCiudad(),
                cliente.getCodigoPostal()
        );
    }
}
