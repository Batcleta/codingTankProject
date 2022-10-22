package org.example;

// [X] pedir que o usuário digite a quantidade de temperaturas a serem transformadas.
// [X] pedir que o usuário escolha duas unidades de temperatura. A unidade de origem da temperatura e a unidade a ser transformada.
// [X] conseguir transformar temperatura em Celsius, Kelvin e Fahrenheit a partir de qualquer uma dessas unidades para qualquer uma dessas unidades.

// [X] imprimir cada temperatura passada, e a unidade escolhida, e também a temperatura resultante, transformada, com sua respectiva unidade.
// [ ] calcular a média das temperaturas iniciais e transformadas.
// [ ] ser capaz de se recuperar e tratar qualquer erro que venha ocorrer em sua execução. Entrega via GITHUB durante a aula de segunda. Não precisa ser tudo na mesma classe.

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        double[] temperatures = getTemperatures();
        String[] temperatureTypes = getTemperatureTypes();
        double[] convertedTemperatures = convertTemperature(temperatures, temperatureTypes);

        System.out.print("Temperaturas informadas: " + "\t");
        for (double temperature : temperatures) {
            System.out.print(temperature + "\t");
        }

        System.out.println(" ");

        System.out.print("Tipos de temperaturas informadas: " + "\t");
        for (String temperatureType : temperatureTypes) {
            System.out.print(temperatureType + "\t");
        }

        System.out.println(" ");

        System.out.print("Temperaturas convertidas: " + "\t");
        for (double convertedTemperature : convertedTemperatures) {
            System.out.print(convertedTemperature + "\t");
        }

        System.out.println(" ");

//        calcularMediaIniciais(temperatures);
//        System.out.println(" ");
//        calcularMediaConvertidas(convertedTemperatures);

    }

    private static void calcularMediaIniciais(double[] temperatures) {

        double sum = 0;
        for (int i = 0; i < temperatures.length; i++) {
            sum = sum + temperatures[i];
        }
        System.out.print("Média das temperaturas iniciais " + "\t");
        System.out.println(sum / temperatures.length);
    }

    private static void calcularMediaConvertidas(double[] convertedTemperatures) {

        double sum = 0;
        for (int i = 0; i < convertedTemperatures.length; i++) {
            sum = sum + convertedTemperatures[i];
        }
        System.out.print("Média das temperaturas convertidas" + "\t");
        System.out.println(sum / convertedTemperatures.length);

    }


    private static double[] convertTemperature(double[] temperatures, String[] temperatureTypes) {
        double[] convertedArray = new double[temperatures.length];


        if (temperatureTypes[0].equals("celsius") && temperatureTypes[1].equals("fahrenheit")) {

            for (int i = 0; i < temperatures.length; i++) {
                double conversion = (temperatures[i] * (double) 9 / 5) + 32;
                convertedArray[i] = conversion;
            }
        } else if (temperatureTypes[0].equals("celsius") && temperatureTypes[1].equals("kelvin")) {
            for (int i = 0; i < temperatures.length; i++) {
                double conversion = temperatures[i] + 273.15;
                convertedArray[i] = conversion;
            }
        } else if (temperatureTypes[0].equals("fahrenheit") && temperatureTypes[1].equals("celsius")) {
            for (int i = 0; i < temperatures.length; i++) {
                double conversion = (temperatures[i] - 32) * ((double) 5 / 9);

                convertedArray[i] = conversion;
            }
        } else if (temperatureTypes[0].equals("fahrenheit") && temperatureTypes[1].equals("kelvin")) {
            for (int i = 0; i < temperatures.length; i++) {
                double conversion = (temperatures[i] - 32) * ((double) 5 / 9) + 273.15;

                convertedArray[i] = conversion;
            }
        } else if (temperatureTypes[0].equals("kelvin") && temperatureTypes[1].equals("celsius")) {
            for (int i = 0; i < temperatures.length; i++) {
                double conversion = temperatures[i] - 273.15;
                convertedArray[i] = conversion;
            }
        } else if (temperatureTypes[0].equals("kelvin") && temperatureTypes[1].equals("fahrenheit")) {
            for (int i = 0; i < temperatures.length; i++) {
                double conversion = (temperatures[i] - 273.15) * ((double) 9 / 5) + 32;
                convertedArray[i] = conversion;
            }
        } else {
            System.out.println("Entradas inválidas");
        }


        return convertedArray;
    }

    private static String[] getTemperatureTypes() {
        String[] temperaturesTypesArray = new String[]{};

        Scanner scanner = new Scanner(System.in);
        boolean isInvalid;

        do {
            isInvalid = false;

            try {

                System.out.println("Informe o tipo da temperatura de origem. ( Celsius, Kelvin e Fahrenheit ) ");
                String firstTemperature = scanner.next();

                System.out.println("Informe o tipo da temperatura para conversão. ( Celsius, Kelvin e Fahrenheit ) ");
                String lastTemperature = scanner.next();

                if (firstTemperature == null || firstTemperature.isEmpty() || lastTemperature == null || lastTemperature.isEmpty()) {
                    System.out.println("Por favor, digite ao menos uma temperatura");
                    isInvalid = true;
                    continue;
                }


                if (!firstTemperature.equalsIgnoreCase("celsius") &&
                        !firstTemperature.equalsIgnoreCase("fahrenheit") &&
                        !firstTemperature.equalsIgnoreCase("Kelvin")) {
                    System.out.println("A temperatura informada deve ser ( Celsius, Kelvin ou Fahrenheit )");
                    isInvalid = true;
                    continue;
                }

                if (!lastTemperature.equalsIgnoreCase("celsius") &&
                        !lastTemperature.equalsIgnoreCase("fahrenheit") &&
                        !lastTemperature.equalsIgnoreCase("Kelvin")) {
                    System.out.println("A temperatura informada deve ser ( Celsius, Kelvin ou Fahrenheit )");
                    isInvalid = true;
                    continue;
                }

                if (firstTemperature.equals(lastTemperature)) {
                    System.out.println("Os tipos de temperaturas não podem ser iguais");
                    isInvalid = true;
                    continue;
                }

                temperaturesTypesArray = new String[]{firstTemperature.toLowerCase(), lastTemperature.toLowerCase()};

            } catch (Exception e) {

                if (e instanceof NumberFormatException) {
                    System.out.println("Por favor, digite digite numeros inteiros ou decimais separados apenas por espaço");
                    isInvalid = true;

                } else {
                    System.out.println(e);
                    isInvalid = true;
                }
            }

        } while (isInvalid);

        return temperaturesTypesArray;

    }

    private static double[] getTemperatures() {
        double[] temperaturesArray = new double[]{};

        Scanner scanner = new Scanner(System.in);
        boolean isInvalid;

        do {
            isInvalid = false;

            try {

                System.out.println("informe a quantidade de temperaturas separadas com espaço");
                String temperaturesQuantity = scanner.nextLine();

                if (temperaturesQuantity == null || temperaturesQuantity.isEmpty()) {
                    System.out.println("Por favor, digite ao menos uma temperatura");
                    isInvalid = true;
                    continue;
                }

                String[] tempStringToArray = temperaturesQuantity.split(" ");

                if (tempStringToArray.length <= 0) {
                    System.out.println("Por favor, digite ao menos uma temperatura");
                    isInvalid = true;
                    continue;
                }

                temperaturesArray = Stream.of(tempStringToArray).mapToDouble(Double::parseDouble).toArray();

            } catch (Exception e) {

                if (e instanceof NumberFormatException) {
                    System.out.println("Por favor, digite digite numeros inteiros ou decimais separados apenas por espaço");
                    isInvalid = true;

                } else {
                    System.out.println(e);
                    isInvalid = true;
                }

            }


        } while (isInvalid);

        return temperaturesArray;
    }
}