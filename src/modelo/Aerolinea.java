/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author PotatoPower
 */
@Getter
@Setter
public class Aerolinea {
    private String nombre;
    private Double distancia;
    private List<Parada> ruta = new ArrayList<>();
    private String nRuta;
    @Override
    public String toString() {
        String cord = " ";
        for (Parada parada : ruta) {
            cord += parada;
        }
        return nombre + " " + distancia +" "+ nRuta+ " \n" + cord + "\n"; 
    }
    
    
}
