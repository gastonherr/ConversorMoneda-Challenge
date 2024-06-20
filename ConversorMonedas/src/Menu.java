import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void ejecutarApp(){
        int opcion = 0;
        String menu = """
                Hola, accediste al nuevo conversor de monedas!!
                                1- Dolar a Peso argentino
                                2- Peso argentino a Dolar 
                                3- Dolar a Real brasileño 
                                4- Real brasileño a Dolar 
                                5- Dolar a Peso colombiano 
                                6- Peso colombiano a Dolar 
                                8- Salir 
                                
                                Elija la opción que desee consultar...
                """;

        String base_code;
        String target_code;
        double conversion_result;
        double montoInicial = 0;
        Operacion miCalculo = new Operacion();

        while (opcion != 8) {
            System.out.println(menu);
            Scanner lectura = new Scanner(System.in);
            try{
            opcion = lectura.nextInt();

            if (opcion <1 || opcion ==7 || opcion >8){
                System.out.println("*** Elija una opción válida*** ");

            } else if (opcion ==8) {
                System.out.println("*** Finalizando el programa ***");
                break;
            }
            } catch (InputMismatchException e) {
                    System.out.println("*** Elija una opción válida*** ");
                }

            System.out.println("*** Ingrese el valor que desee convertir ***");

            try {

                montoInicial = lectura.nextDouble();

            if (montoInicial < 0) {
                System.out.println("*** Monto incorrecto ***");}
            } catch (InputMismatchException e) {
                    System.out.println("*** Ingrese un valor válido ***");
                }



            switch (opcion) {
                    case 1 : base_code = "USD";
                        target_code = "ARS";
                        miCalculo.hacerCalculo(base_code, target_code, montoInicial);
                    break;

                    case 2 : base_code = "ARS";
                        target_code = "USD";
                        miCalculo.hacerCalculo(base_code, target_code, montoInicial);
                    break;

                    case 3 : base_code = "USD";
                        target_code = "BRL";
                        miCalculo.hacerCalculo(base_code, target_code, montoInicial);
                    break;

                    case 4 : base_code = "BRL";
                        target_code = "USD";
                        miCalculo.hacerCalculo(base_code, target_code, montoInicial);
                    break;

                    case 5 : base_code = "USD";
                        target_code = "COP";
                        miCalculo.hacerCalculo(base_code, target_code, montoInicial);
                    break;

                    case 6 : base_code = "COP";
                        target_code = "USD";
                        miCalculo.hacerCalculo(base_code, target_code, montoInicial);
                    break;

            }






            }
        }


    }




