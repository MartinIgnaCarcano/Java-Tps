package org.example.Entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Sucursal extends Base{
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private List<Promocion> promociones = new ArrayList<>();
    private List<Categoria> categorias= new ArrayList<>();
    private Domicilio domicilio;

    public void agregarPromocion(Promocion promocion){
        this.promociones.add(promocion);
    }
    public void agregarCategoria(Categoria categoria){
        this.categorias.add(categoria);
    }
}
