package oprg.cpl_cursos.ejercicioClase_VII_spring_data_jpa.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @Column(name = "codigo_producto", nullable = false, length = 15)
    private String codigoProducto;

    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;

    @Column(name = "gama", nullable = false, length = 50)
    private String gama;

    @Column(name = "dimensiones", length = 25)
    private String dimensiones;

    @ColumnDefault("NULL")
    @Column(name = "proveedor", length = 50)
    private String proveedor;

    @Column(name = "descripcion", length = Integer.MAX_VALUE)
    private String descripcion;

    @Column(name = "cantidad_en_stock", nullable = false)
    private Short cantidadEnStock;

    @Column(name = "precio_venta", nullable = false, precision = 15, scale = 2)
    private BigDecimal precioVenta;

    @ColumnDefault("NULL")
    @Column(name = "precio_proveedor", precision = 15, scale = 2)
    private BigDecimal precioProveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gama")
    private Gama idGama;

    @OneToMany(mappedBy = "idProducto")
    private Set<LineasPedido> lineasPedidos = new LinkedHashSet<>();

}