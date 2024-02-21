import java.util.Scanner;

public class NotacionCientifica {
    public static int contarCifrasSignificativas(double numero) {
        // Convertir el número a una cadena para facilitar el conteo de cifras significativas
        String numeroStr = Double.toString(numero);
        
        // Contar las cifras significativas
        int cifrasSignificativas = 0;
        boolean inicioCifrasSignificativas = false;
        boolean puntoEncontrado = false;
        boolean cerosContados = false; // Variable para rastrear si ya hemos contado los ceros
        
        for (char c : numeroStr.toCharArray()) {
            if (Character.isDigit(c)) {
                if (c != '0' || inicioCifrasSignificativas) {
                    cifrasSignificativas++;
                    inicioCifrasSignificativas = true;
                }
            } else if (c == '.') {
                puntoEncontrado = true;
            } else if (puntoEncontrado && !cerosContados && c == '0') {
                cifrasSignificativas++; // Contar el cero solo si está a la derecha del punto decimal
            }
        }
        
        return cifrasSignificativas;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        while (continuar) {
            // Solicitar al usuario que ingrese el tipo de número
            System.out.println("Elija el tipo de número:");
            System.out.println("1. Número normal");
            System.out.println("2. Número en notación científica");
            System.out.print("Ingrese su elección (1 o 2): ");
            int opcion = scanner.nextInt();
            
            // Declarar variables para el número y el exponente
            double numero = 0;
            int exponente = 0;
            
            // Verificar la opción seleccionada por el usuario
            if (opcion == 1) {
                // Solicitar al usuario que ingrese un número normal
                System.out.print("Ingrese un número normal: ");
                numero = scanner.nextDouble();
            } else if (opcion == 2) {
                // Solicitar al usuario que ingrese un número y un exponente en notación científica
                System.out.print("Ingrese el número en notación científica (por ejemplo, 6.022): ");
                numero = scanner.nextDouble();
                System.out.print("Ingrese el exponente en notación científica (por ejemplo, 23): ");
                exponente = scanner.nextInt();
            } else {
                System.out.println("Opción no válida. Por favor, ingrese 1 o 2.");
                scanner.close();
                return;
            }
            
            // Imprimir el número ingresado
            if (opcion == 1) {
                System.out.println("El número ingresado es: " + numero);
            } else {
                System.out.println("El número ingresado en notación científica es: " + numero + " x 10^" + exponente);
            }
            
            // Contar las cifras significativas
            int cifrasSignificativas;
            if (opcion == 1) {
                cifrasSignificativas = contarCifrasSignificativas(numero);
            } else {
                cifrasSignificativas = contarCifrasSignificativas(numero);
            }
            
            // Imprimir el resultado de las cifras significativas
            System.out.println("El número tiene " + cifrasSignificativas + " cifras significativas");
            
            // Preguntar al usuario si desea agregar otro valor
            System.out.print("¿Desea agregar otro valor? (Sí/No): ");
            String respuesta = scanner.next();
            if (!respuesta.equalsIgnoreCase("Si")) {
                continuar = false;
            }
        }
        
        // Cerrar el scanner
        scanner.close();
    }
}
