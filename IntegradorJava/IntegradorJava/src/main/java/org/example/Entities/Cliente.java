package org.example.Entities;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Cliente extends Base{
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;
    private Usuario usuario;
    private Imagen imagen;
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();
    @Builder.Default
    private Set<Domicilio> domicilios = new HashSet<>();

    public void agregarDomicilio(Domicilio domicilio){
        this.domicilios.add(domicilio);
    }

    public void agregarPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }
}
