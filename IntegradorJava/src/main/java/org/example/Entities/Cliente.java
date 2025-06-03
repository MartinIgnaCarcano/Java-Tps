package org.example.Entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Base{
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;
    private Usuario usuario;
    private Imagen imagen;
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Domicilio> domicilios = new ArrayList<>();

    public void agregarDomicilio(Domicilio domicilio){
        this.domicilios.add(domicilio);
    }

    public void agregarPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }
}
