package org.example.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Articulo extends Base{
    protected String denominacion;
    protected double previoVenta;
    private UnidadMedida unidadMedida;
    private Set<Imagen> imagenes;
}
