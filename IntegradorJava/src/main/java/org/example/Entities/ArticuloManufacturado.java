package org.example.Entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloManufacturado extends Articulo{
    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;
    private List<ArticuloManufacturadoDetalle> detalles = new ArrayList<>();

    public void agregarArticuloManufacturadoDetalle(ArticuloManufacturadoDetalle articuloManufacturadoDetalle){
        this.detalles.add(articuloManufacturadoDetalle);
    }
}
