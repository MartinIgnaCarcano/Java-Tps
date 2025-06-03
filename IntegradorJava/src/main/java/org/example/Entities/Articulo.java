package org.example.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Articulo extends Base{
    protected String denominacion;
    protected double previoVenta;
    private UnidadMedida unidadMedida;
    private List<Imagen> imagenes;
}
