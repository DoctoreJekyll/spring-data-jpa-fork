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
public class LineasPedidoId implements Serializable {

    @Column(name = "id_pedido", nullable = false)
    private Integer idPedido;

    @Column(name = "id_producto", nullable = false)
    private String idProducto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LineasPedidoId entity = (LineasPedidoId) o;
        return Objects.equals(this.idProducto, entity.idProducto) &&
                Objects.equals(this.idPedido, entity.idPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, idPedido);
    }

}