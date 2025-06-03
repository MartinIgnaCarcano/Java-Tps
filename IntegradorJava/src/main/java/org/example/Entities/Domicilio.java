package org.example.Entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Domicilio extends Base{
    private String calle;
    private int numero;
    private int cp;
    private Localidad localidad;
}
