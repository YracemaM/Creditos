package ar.com.ada.creditos.excepciones;

import ar.com.ada.creditos.entities.*;

public class ClienteNombreException extends ClienteInfoException {

    private Cliente Cliente;
    
    public ClienteNombreException(Cliente cliente, String mensaje) {
        super(cliente, mensaje);
        this.Cliente = cliente;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente cliente) {
        Cliente = cliente;
    }
    

}
