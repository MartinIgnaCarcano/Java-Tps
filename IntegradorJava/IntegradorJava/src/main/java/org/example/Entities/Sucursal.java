package org.example.Entities;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
public class Sucursal extends Base{
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    @Builder.Default
    private Set<Promocion> promociones = new HashSet<>();
    @Builder.Default
    private Set<Categoria> categorias= new HashSet<>();
    private Domicilio domicilio;

    public void agregarPromocion(Promocion promocion){
        this.promociones.add(promocion);
    }
    public void agregarCategoria(Categoria categoria){
        this.categorias.add(categoria);
    }
}
