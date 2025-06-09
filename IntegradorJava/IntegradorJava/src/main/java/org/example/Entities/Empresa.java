package org.example.Entities;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Empresa extends Base{
    private String nombre;
    private String razonSocial;
    private Integer cuil;
    @Builder.Default
    private Set<Sucursal> sucursales= new HashSet<>();

    public void agregarSucursal(Sucursal sucursal){
        this.sucursales.add(sucursal);
    }
}
