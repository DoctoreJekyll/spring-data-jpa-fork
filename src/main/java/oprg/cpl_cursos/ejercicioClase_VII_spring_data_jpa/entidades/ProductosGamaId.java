package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ProductosGamaId implements Serializable {
    private static final long serialVersionUID = -5350646199405945021L;
    @Column(name = "id_gama", nullable = false)
    private Integer idGama;

    @Column(name = "id_producto", nullable = false)
    private Integer idProducto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductosGamaId entity = (ProductosGamaId) o;
        return Objects.equals(this.idGama, entity.idGama) &&
                Objects.equals(this.idProducto, entity.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGama, idProducto);
    }

}