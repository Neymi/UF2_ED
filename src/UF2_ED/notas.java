package UF2_ED;
import java.util.Scanner;

/**
* @author Marina Sainz
* @version 1.0
 */

/**
 * La clase 'notas' permite calcular la nota definitiva de un estudiante
 * a partir de las notas de tres unidades formativas.
 */
public class notas {
    double nota1, nota2, nota3; // Variables para las notas de las tres unidades formativas
    double sum1, sum2, sum3, def; // Variables para los acumulados y la nota definitiva
    Scanner entrada = new Scanner(System.in); // Utilizado para la entrada de datos

    /**
     * Método para ingresar las notas del estudiante.
     * Este método solicita al usuario que introduzca las notas de tres unidades formativas.
     */
    public void IngresaNotas() {
        System.out.println("Introduzca las notas del estudiante");
        
        System.out.print("Introduzca nota 1: ");
        nota1 = entrada.nextDouble();

        System.out.print("Introduzca nota 2: ");
        nota2 = entrada.nextDouble();
        
        System.out.print("Introduzca nota 3: ");
        nota3 = entrada.nextDouble();
    }
    
    /**
     * Método para verificar la correcta introducción de notas.
     * Este método comprueba si las notas introducidas están en el rango válido [0, 10].
     * @throws IllegalArgumentException si alguna nota está fuera del rango válido.
     */
    public void comprobacion() {
        if (nota1 > 10 || nota2 > 10 || nota3 > 10 || nota1 < 0 || nota2 < 0 || nota3 < 0) {
            throw new IllegalArgumentException("Las notas deben estar en el rango [0, 10]");
        }
    }
    
    /**
     * Método para calcular la nota definitiva.
     * Este método calcula la nota definitiva del estudiante mediante una ponderación
     * de las notas de las tres unidades formativas.
     * @return La nota definitiva del estudiante.
     */
    public double Calculonotas() {
    	sum1 = nota1 * 0.35;
    	sum2 = nota2 * 0.35;
    	sum3 = nota3 * 0.30;
        
        def = sum1 + sum2 + sum3;
        
        return def;
    }
    
    /**
     * Método para mostrar las notas introducidas y la nota definitiva.
     * Este método muestra las notas introducidas por el usuario, así como la nota
     * definitiva calculada.
     * @param notas Las notas introducidas por el usuario.
     * @param definitiva La nota definitiva del estudiante.
     */
    public void Mostrar(double[] notas, double definitiva) {
        System.out.println("Notas introducidas son:");
        System.out.println("Nota 1 = " + notas[0]);
        System.out.println("Nota 2 = " + notas[1]);
        System.out.println("Nota 3 = " + notas[2]);
        
        System.out.println("Suma 1 = " + sum1);
        System.out.println("Suma 2 = " + sum2);
        System.out.println("Suma 3 = " + sum3);
        
        System.out.println("Nota definitiva = " + definitiva);
    }

    /**
     * Método para determinar si el estudiante aprobó o reprobó.
     * Este método determina si la nota definitiva del estudiante está en el rango
     * de aprobación o no, y muestra el resultado correspondiente.
     * @param definitiva La nota definitiva del estudiante.
     * @return "Aprobado" si la nota definitiva es mayor o igual a 5, "Reprobado" en caso contrario.
     */
    public String aprobado(double definitiva) {
        if (definitiva >= 5) {
            return "Aprobadísimo";
        } else {
            return "Reprobadísimo";
        }
    }
    
    /**
     * Método principal para ejecutar el programa.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        notas fc = new notas(); // Creamos una instancia de la clase notas
        
        fc.IngresaNotas(); // Ingresamos las notas
        
        try {
            fc.comprobacion(); // Verificamos la correcta introducción de notas
            double definitiva = fc.Calculonotas(); // Calculamos la nota definitiva
            
            double[] notas = {fc.nota1, fc.nota2, fc.nota3};
            fc.Mostrar(notas, definitiva); // Mostramos las notas introducidas y la nota definitiva
            
            System.out.println("El estudiante está " + fc.aprobado(definitiva)); // Determinamos si el estudiante aprobó o reprobó
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // Manejamos el error si las notas están fuera del rango válido
        }
    }
}

