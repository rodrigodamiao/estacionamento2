package com.damzik.estacionamento2.helper;

import java.util.Random;

public class PlacaGenerator {

    private static final String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String numeros = "0123456789";
    private static final Random random = new Random();

    public static String gerarPlaca(){
        StringBuilder placa = new StringBuilder();

        for(int i = 0; i < 3; i++){
            placa.append(letras.charAt(random.nextInt(letras.length())));
        }
        placa.append("-");
        for(int i = 0; i < 4 ; i++){
            placa.append(numeros.charAt(random.nextInt(numeros.length())));
        }
        return placa.toString();
    }
}
