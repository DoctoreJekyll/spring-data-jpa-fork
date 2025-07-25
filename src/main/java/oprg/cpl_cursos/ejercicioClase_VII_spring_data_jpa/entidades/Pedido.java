package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @Column(name = "codigo_pedido", nullable = false)
    private Integer id;

    @Column(name = "fecha_pedido", nullable = false)
    private Instant fechaPedido;

    @Column(name = "fecha_esperada", nullable = false)
    private LocalDate fechaEsperada;

    @Column(name = "fecha_entrega")
    private Instant fechaEntrega;

    @Column(name = "estado", nullable = false, length = 15)
    private String estado;

    @Column(name = "comentarios", length = Integer.MAX_VALUE)
    private String comentarios;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_cliente", nullable = false)
    private Cliente codigoCliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id")
    private EstadoPedido estado1;

    @OneToMany(mappedBy = "idPedido")
    private Set<LineasPedido> lineasPedidos = new LinkedHashSet<>();

}