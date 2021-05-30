package ar.com.ada.creditos.entities;

import java.util.*;
import java.math.*;
import javax.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "prestamos" )
public class Prestamo {
   
    @Id
    @Column (name = "prestamo_id" )
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTOINCREMENTAL
    private int prestamoId;
    
    private BigDecimal Importe;

    private int Cuotas;

    @Temporal(TemporalType.DATE) //SOLO Poner esto si no queremos manejar HORA en el DB Server.
    private Date fecha;

    @Column (name = "Fecha_Alta")
    private Date fechaAlta;

    @ManyToOne // Los joinsColumns van donde llega la ForeingKey
    @JoinColumn (name = "cliente_id", referencedColumnName = "cliente_id")
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
        this.cliente.agregarPrestamo(this); //RELACION BIDIRECCIONAL
    }

    

}
