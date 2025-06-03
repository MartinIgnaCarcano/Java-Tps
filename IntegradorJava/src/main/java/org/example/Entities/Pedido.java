package org.example.Entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Entities.Enums.Estado;
import org.example.Entities.Enums.FormaPago;
import org.example.Entities.Enums.TipoEnvio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido extends Base{
    private LocalTime horaEstimadaFinalizacion;
    private double total;
    private double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;
    private Factura factura;
    private List<DetallePedido> detallespedido = new ArrayList<>();
    private Sucursal sucursal;
    private Domicilio domicilio;

    public void agregarDetallePedido(DetallePedido detalle){
        this.detallespedido.add(detalle);
    }
}
