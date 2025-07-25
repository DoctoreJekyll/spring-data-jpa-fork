package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.smartcardio.CardNotPresentException;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @Column(name = "codigo_cliente", nullable = false)
    private Integer id;

    @Column(name = "nombre_cliente", nullable = false, length = 50)
    private String nombreCliente;

    @ColumnDefault("NULL")
    @Column(name = "nombre_contacto", length = 30)
    private String nombreContacto;

    @ColumnDefault("NULL")
    @Column(name = "apellido_contacto", length = 30)
    private String apellidoContacto;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "fax", length = 15)
    private String fax;

    @Column(name = "linea_direccion1", length = 50)
    private String lineaDireccion1;

    @ColumnDefault("NULL")
    @Column(name = "linea_direccion2", length = 50)
    private String lineaDireccion2;

    @Column(name = "ciudad", length = 50)
    private String ciudad;

    @ColumnDefault("NULL")
    @Column(name = "region", length = 50)
    private String region;

    @ColumnDefault("NULL")
    @Column(name = "pais", length = 50)
    private String pais;

    @ColumnDefault("NULL")
    @Column(name = "codigo_postal", length = 10)
    private String codigoPostal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_empleado_rep_ventas")
    private Empleado codigoEmpleadoRepVentas;

    @ColumnDefault("NULL")
    @Column(name = "limite_credito", precision = 15, scale = 2)
    private BigDecimal limiteCredito;

    @OneToMany(mappedBy = "codigoCliente")
    private Set<Pago> pagos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "codigoCliente")
    private Set<Pedido> pedidos = new LinkedHashSet<>();

}