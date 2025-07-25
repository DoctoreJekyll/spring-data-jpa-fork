package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productos_gamas")
public class ProductosGama {
    @EmbeddedId
    private ProductosGamaId id;

    @MapsId("idGama")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_gama", nullable = false)
    private Gama idGama;

    @Column(name = "existencias")
    private Integer existencias;

}