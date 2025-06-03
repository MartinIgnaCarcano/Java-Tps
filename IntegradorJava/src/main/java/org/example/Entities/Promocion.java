package org.example.Entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Entities.Enums.TipoPromocion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Promocion extends Base{
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private double precioPromocional;
    private TipoPromocion tipoPromocion;
    private List<Imagen> imagenes= new ArrayList<>();
    private List<Articulo> articulos = new ArrayList<>();

    public void agregarArticulo(Articulo articulo){
        this.articulos.add(articulo);
    }

    public void agregarImagen(Imagen imagen){
        this.imagenes.add(imagen);
    }
}
