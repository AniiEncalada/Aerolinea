package vista;

import controlador.Lambda;

public class Principal {
    public static void main(String[] args) {
        Lambda lam = new Lambda();
        lam.cargarLista();
        lam.asignar();
        System.out.println(lam.getLista());
        System.out.println("Minimo: "+lam.minimo());
       // lam.ordenar();
       // System.out.println(lam.getLista());
       
        
    }
}
