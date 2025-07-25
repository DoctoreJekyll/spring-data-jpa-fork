package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "oficinas")
public class Oficina {
    @Id
    @Column(name = "codigo_oficina", nullable = false)
    private String codigoOficina;

    @Column(name = "ciudad", nullable = false, length = 30)
    private String ciudad;

    @Column(name = "pais", length = 50)
    private String pais;

    @ColumnDefault("NULL")
    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "codigo_postal", length = 10)
    private String codigoPostal;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "linea_direccion1", length = 50)
    private String lineaDireccion1;

    @ColumnDefault("NULL")
    @Column(name = "linea_direccion2", length = 50)
    private String lineaDireccion2;

    @OneToMany(mappedBy = "codigoOficina")
    private Set<Empleado> empleados = new LinkedHashSet<>();

}