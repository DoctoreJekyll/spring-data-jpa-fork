package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pagos")
public class Pago {
    @EmbeddedId
    private PagoId id;

    @MapsId("codigoCliente")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_cliente", nullable = false)
    private Cliente codigoCliente;

    @Column(name = "forma_pago", nullable = false, length = 40)
    private String formaPago;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @Column(name = "total", nullable = false, precision = 15, scale = 2)
    private BigDecimal total;

}