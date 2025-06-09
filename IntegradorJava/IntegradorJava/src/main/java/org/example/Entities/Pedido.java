package org.example.Entities;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Enums.Estado;
import org.example.Entities.Enums.FormaPago;
import org.example.Entities.Enums.TipoEnvio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Pedido extends Base{
    private LocalTime horaEstimadaFinalizacion;
    private double total;
    private double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;
    private Factura factura;
    @Builder.Default
    private Set<DetallePedido> detallespedido = new HashSet<>();
    private Sucursal sucursal;
    private Domicilio domicilio;

    public void agregarDetallePedido(DetallePedido detalle){
        this.detallespedido.add(detalle);
    }
}
