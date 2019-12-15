package controlador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import static java.util.stream.Collectors.toList;
import modelo.Aerolinea;
import modelo.Parada;

public class Lambda {

    private List<Aerolinea> lista = new ArrayList<>();

    public void cargarLista() {
        Parada p1 = new Parada();
        Parada p2 = new Parada();
        Parada p3 = new Parada();
        Parada p4 = new Parada();

        Aerolinea a1 = new Aerolinea();
        a1.setNombre("TM-01");
        a1.setNRuta("Ruta 1 ");
        p1.setX(-12.00);
        p1.setY(11.00);
        a1.getRuta().add(p1);
        p2.setX(-15.00);
        p2.setY(13.00);
        a1.getRuta().add(p2);
        p3.setX(-16.50);
        p3.setY(15.00);
        a1.getRuta().add(p3);
        p4.setX(16.00);
        p4.setY(20.30);
        a1.getRuta().add(p4);
        lista.add(a1);
        p1 = new Parada();
        p2 = new Parada();
        p3 = new Parada();
        p4 = new Parada();
        Aerolinea a2 = new Aerolinea();
        a2.setNombre("TM-02");
        a2.setNRuta("Ruta 2 ");
        p1.setX(0.00);
        p1.setY(21.50);
        a2.getRuta().add(p1);
        p2.setX(-12.00);
        p2.setY(13.50);
        a2.getRuta().add(p2);
        p3.setX(-15.00);
        p3.setY(15.00);
        a2.getRuta().add(p3);
        p4.setX(16.00);
        p4.setY(20.30);
        a2.getRuta().add(p4);
        lista.add(a2);
        p1 = new Parada();
        p2 = new Parada();
        p3 = new Parada();
        p4 = new Parada();
        Aerolinea a3 = new Aerolinea();
        a3.setNombre("TM-03");
        a3.setNRuta("Ruta 3 ");
        p1.setX(0.00);
        p1.setY(11.50);
        a3.getRuta().add(p1);
        p2.setX(-12.00);
        p2.setY(13.50);
        a3.getRuta().add(p2);
        p3.setX(-15.25);
        p3.setY(15.30);
        a3.getRuta().add(p3);
        p4.setX(16.00);
        p4.setY(20.30);
        a3.getRuta().add(p4);
        lista.add(a3);
    }

    private Double calcularDistancia(Double x1, Double y1, Double x2, Double y2) {
        DistanciaLambda dist = (a, b, c, d) -> {
            Double calculo = Math.pow((c - a), 2) + Math.pow((d - b), 2);
            return Math.sqrt(calculo);
        };
        return dist.distancia(x1, y1, x2, y2);
    }

    @FunctionalInterface
    public interface DistanciaLambda {

        public Double distancia(Double a, Double b, Double c, Double d);
    }

    private Double calcular(List<Parada> lista) {
        Double p1 = calcularDistancia(
                lista.get(0).getX(),
                lista.get(0).getY(),
                lista.get(1).getX(),
                lista.get(1).getY());
        Double p2 = calcularDistancia(
                lista.get(1).getX(),
                lista.get(1).getY(),
                lista.get(2).getX(),
                lista.get(2).getY());
        Double p3 = calcularDistancia(
                lista.get(2).getX(),
                lista.get(2).getY(),
                lista.get(3).getX(),
                lista.get(3).getY());
        return p1 + p2 + p3;
    }

    public void asignar() {
        lista.get(0).setDistancia(calcular(lista.get(0).getRuta()));
        lista.get(1).setDistancia(calcular(lista.get(1).getRuta()));
        lista.get(2).setDistancia(calcular(lista.get(2).getRuta()));
    }

    public Optional<Aerolinea> minimo() {
        return lista.stream()
      .min(Comparator.comparing(Aerolinea::getDistancia));
       // return 0.00;
    }

    public void min() {
        lista.stream().min(Comparator.comparing(Aerolinea::getDistancia));
    }

    public List<Aerolinea> getLista() {
        return lista;
    }

    public void ordenar() {
        lista.sort((a, b) -> a.getDistancia().compareTo(b.getDistancia()));
        System.out.println("La ruta mas corta es: " + lista.get(0).getDistancia());

    }
}
