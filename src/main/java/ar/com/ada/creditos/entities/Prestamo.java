package ar.com.ada.creditos.entities;

import java.util.*;
import java.math.*;
import javax.persistence.*;

@Entity
@Table(name = "prestamos")
public class Prestamo {
    @Id
    @Column(name = "prestamo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENTAL
    private int prestamoId;

    @Column(name = "estado_id")
    private int estadoId; //Por ahora vamos a crear este como Int

    private BigDecimal Importe;

    private int Cuotas;

    @Temporal(TemporalType.DATE) // SOLO Poner esto si no queremos manejar HORA en el DB Server.
    private Date fecha;

    @Column(name = "Fecha_Alta")
    private Date fechaAlta;

    @ManyToOne // Los joinsColumns van donde llega la ForeingKey
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
    private Cliente cliente;

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public BigDecimal getImporte() {
        return Importe;
    }

    public void setImporte(BigDecimal importe) {
        this.Importe = importe;
    }

    public int getCuotas() {
        return Cuotas;
    }

    public void setCuotas(int cuotas) {
        Cuotas = cuotas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaalta) {
        fechaAlta = fechaalta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.cliente.agregarPrestamo(this); // RELACION BIDIRECCIONAL
    }

    // ENUMERADO
    
    public EstadoPrestamoEnum getEstadoId() {
        
        return EstadoPrestamoEnum.parse(this.estadoId);
    }
    
    public void setEstadoId(EstadoPrestamoEnum estadoId) {
        this.estadoId = estadoId.getValue();
    }
// enumerado
public enum EstadoPrestamoEnum {
    SOLICITADO(1),
    RECHAZADO(2),
    PENDIENTE_APROBACION(3),
    APROBADO(4),
    INCOBRABLE(5),
    CANCELADO(6),
    PREAPROBADO(100);

    private final int value;

//NOTE: Enum constructor tiene que estar en privado
    private EstadoPrestamoEnum (int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;

    }
        public static EstadoPrestamoEnum parse(int id) {
            EstadoPrestamoEnum status = null; //Default
            for (EstadoPrestamoEnum item : EstadoPrestamoEnum.values()) {
                if (item.getValue() == id) {
                    status = item;
                    break;
                }
            }
            return status;
        }
   
    }
}


