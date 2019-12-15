/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author PotatoPower
 */
@Getter
@Setter
public class Parada {
    public Double x;
    public Double y;

    @Override
    public String toString() {
        return " Coordenadas: "+x+", "+y;
    }
    
    
}
