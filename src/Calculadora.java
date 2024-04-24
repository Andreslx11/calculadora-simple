import java.util.InputMismatchException;
import java.util.Scanner;


/*
#################################################



Esto es un ensayo trabajando en la rama experimental1
*
*
*
*
* ################################################
*/



public class Calculadora {
    private Scanner scanner;
    private String bienvenida = "Bienvenid@ a la app calculadora";
    private String seleccionOperacion = """
            ------- selecione la opción: -------
            1. suma
            2. resta
            3. division
            4. multiplicacion
            5. Ingresas nuevos números
            6. salir
                        
            """;
    private double number1;
    private double number2;
    private int operacion;
    private double resultado;


    public Calculadora() {
        this.scanner = new Scanner(System.in);
    }

    public void bienvenida() {
        System.out.println(bienvenida);
    }

    public void imprimeMenu() {
        System.out.println(seleccionOperacion);
    }


    public double obtenerNumero1() {

        while (true) {

            try {
                System.out.println(" Ingrese el primer numero:");
                number1 = scanner.nextDouble();
                return number1;
            } catch (InputMismatchException e) {
                System.out.println("Error! ingrese un valor númerico: ");
                scanner.next(); // aqui se limpia el scanner
            }

        }
    }


    public double obtenerNumero2() {

        while (true) {

            try {
                System.out.println(" Ingrese el segundo numero:");
                number2 = scanner.nextDouble();
                return number2;
            } catch (InputMismatchException e) {
                System.out.println("Error! ingrese un valor númerico: ");
                scanner.next(); // aqui se limpia el scanner
            }

        }
    }


    public double suma(double number1, double number2) {
        return resultado = number1 + number2;
    }

    public double resta(double number1, double number2) {
        return resultado = number1 - number2;
    }

    public double division(double number1, double number2) {
        if (number2 == 0) {
            throw new ArithmeticException("No se puede dividir un número por cero");
        }
        return resultado = number1 / number2;
    }

    public double multiplicaion(double number1, double number2) {
        return resultado = number1 * number2;
    }

    public double obtenerNumero1DespuesPrimeraVuelta(double resultadoAnterior) {

        if (resultadoAnterior != 0) {
            return resultadoAnterior;
        } else {
            return obtenerNumero1();
        }
    }


    public String menu2() {
        return " Ingresa una opcion aritmetica para seguir operando con el resultado \n" +
                "anterior, opción 5 para ingresar nuevos números y 6 salir ";
    }

    // Es una buena pratica cerrar desactivarlo scanner
    public void cerrarScanner() {
        scanner.close();
    }

    public void operacion() {
        double resultadoAnterior = 0;
        boolean continuar = true;
        while (continuar) {
            try {
                operacion = scanner.nextInt();
                switch (operacion) {
                    case 1:
                        number1 = obtenerNumero1DespuesPrimeraVuelta(resultadoAnterior);
                        number2 = obtenerNumero2();
                        resultado = suma(number1, number2);
                        resultadoAnterior = resultado;
                        System.out.println("resultado de la suma: " + resultado);
                        System.out.println(menu2());
                        break;
                    case 2:
                        number1 = obtenerNumero1DespuesPrimeraVuelta(resultadoAnterior);
                        number2 = obtenerNumero2();
                        resultado = resta(number1, number2);
                        resultadoAnterior = resultado;
                        System.out.println("resultado de la resta: " + resultado);
                        System.out.println(menu2());
                        break;
                    case 3:
                        number1 = obtenerNumero1DespuesPrimeraVuelta(resultadoAnterior);
                        number2 = obtenerNumero2();
                        resultado = division(number1, number2);
                        resultadoAnterior = resultado;
                        System.out.println("resultado de la divición: " + resultado);
                        System.out.println(menu2());
                        break;
                    case 4:
                        number1 = obtenerNumero1DespuesPrimeraVuelta(resultadoAnterior);
                        number2 = obtenerNumero2();
                        resultado = multiplicaion(number1, number2);
                        resultadoAnterior = resultado;
                        System.out.println("resultado de la multiplicación: " + resultado);
                        System.out.println(menu2());
                        break;
                    case 5:
                        resultadoAnterior = 0;
                        imprimeMenu();
                        continue;
                    case 6:

                        System.out.println("Adios gracias por usar nuestro servicio");
                        cerrarScanner();
                        continuar = false;
                        break;

                    default:
                        System.out.println("Error opción no valida");


                }
            } catch (InputMismatchException e) {
                System.out.println("Error! ingresa una opción valida");
                scanner.next(); // aqui se limpia el scanner
            }

        }


    }


}

