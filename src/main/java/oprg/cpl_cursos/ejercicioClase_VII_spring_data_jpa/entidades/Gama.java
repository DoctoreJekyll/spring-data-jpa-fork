package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "gamas")
public class Gama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "gama", nullable = false)
    private String gama;

    @Column(name = "descripcion_texto", length = Integer.MAX_VALUE)
    private String descripcionTexto;

    @Column(name = "descripcion_html", length = Integer.MAX_VALUE)
    private String descripcionHtml;

    @Column(name = "imagen", length = 256)
    private String imagen;

    @OneToMany(mappedBy = "idGama")
    private Set<Producto> productos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idGama")
    private Set<ProductosGama> productosGamas = new LinkedHashSet<>();

}