package org.example.Entities;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Enums.TipoPromocion;

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
public class Promocion extends Base{
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private double precioPromocional;
    private TipoPromocion tipoPromocion;
    @Builder.Default
    private Set<Imagen> imagenes= new HashSet<>();
    private Set<Articulo> articulos = new HashSet<>();

    public void agregarArticulo(Articulo articulo){
        this.articulos.add(articulo);
    }

    public void agregarImagen(Imagen imagen){
        this.imagenes.add(imagen);
    }
}
