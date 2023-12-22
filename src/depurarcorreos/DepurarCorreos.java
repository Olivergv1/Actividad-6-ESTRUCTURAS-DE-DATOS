package depurarcorreos;

import java.util.LinkedHashSet;
import java.util.Set;



public class DepurarCorreos {
    public static void main(String[] args) {
        String servidorA = "usuario1@dominio.com;usuario2@dominio.com;gabriel@dominio.com;gabriel@protonmail.com;gm@grupofmo.com;kevinmitnick@mnsecurity.com;rms@gnu.org;linus@kernel.org;jamesgosling@cmu.edu;dennisritchie@harvard.edu;kenthompson@berkeley.edu";
        String servidorB = "usuario1@dominio.com;usuario2@dominio.com;usuario3@dominio.com;darksoul@protonmail.com;rcd@rcd.com;davek@mnsecurity.com;rms@gnu.org;mdeicaza@gnome.org;alan.turing@ieee.org;gabriel.morejon@presidencia.gob.ec;user1000@berkeley.edu";

        
        // crear conjuntos para cada servidor
        
        Set<String> conjuntoA = new LinkedHashSet<>();
        Set<String> conjuntoB = new LinkedHashSet<>();

        
        // dividir las cadenas y agregar elementos a los conjuntos
        
        agregarCorreosAlConjunto(servidorA, conjuntoA);
        agregarCorreosAlConjunto(servidorB, conjuntoB);

        
        // muestra los elementos del conjunto A
        
        System.out.println("ELEMENTOS DEL CONJUNTO A:\n");
        mostrarConjunto(conjuntoA);
        
        // muestra los elementos del conjunto B
        
        System.out.println("\nELEMENTOS DEL CONJUNTO B:\n");
        mostrarConjunto(conjuntoB);
        System.out.println("_____________________________________________");

        
        // crear un nuevo conjunto con la opercaion de union
        
        Set<String> conjuntoDepurado = new LinkedHashSet<>(conjuntoA);
        conjuntoDepurado.addAll(conjuntoB);
        System.out.println("\nELEMENTOS DEL NUEVO CONJUNTO USANDO LA OPERACION DE UNION:\n");
        mostrarConjunto(conjuntoDepurado);
        System.out.println("_____________________________________________");
        
        
        // operacion de interseccion
        
        Set<String> interseccion = new LinkedHashSet<>(conjuntoA);
        interseccion.retainAll(conjuntoB);
        System.out.println("\nELEMENTOS DEL NUEVO CONJUNTO USANDO LA OPERACION DE INTERSECCION:\n");
        mostrarConjunto(interseccion);
        System.out.println("_____________________________________________");

        
        // operacion de diferencia
        
        Set<String> diferenciaAB = new LinkedHashSet<>(conjuntoA);
        diferenciaAB.removeAll(conjuntoB);
        System.out.println("\nELEMENTOS DE LA DIFERENCIA (A - B): \n" );
        mostrarConjunto(diferenciaAB);
   
    }

    // metodo para agregar correos a un conjunto
    
    private static void agregarCorreosAlConjunto(String cadenaCorreos, Set<String> conjunto) {
        String[] correos = cadenaCorreos.split(";");  // divide la cadena de correos electrónicos 
        for (String correo : correos) {
            conjunto.add(correo.trim());
        }
    }

    // metodo para mostrar los elementos de un conjunto
    
    private static void mostrarConjunto(Set<String> conjunto) {
        for (String elemento : conjunto) {
            System.out.println(elemento);
        }
    }
}


