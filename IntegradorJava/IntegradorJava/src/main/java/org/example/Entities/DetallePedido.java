package org.example.Entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DetallePedido extends Base{
    private int cantidad;
    private double subtotal;
    private Articulo articulo;
}
