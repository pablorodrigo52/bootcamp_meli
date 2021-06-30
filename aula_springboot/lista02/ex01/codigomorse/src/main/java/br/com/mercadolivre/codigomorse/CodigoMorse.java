package br.com.mercadolivre.codigomorse;

public class CodigoMorse {

    public static String toMorse(String input){
        char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
        'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
        'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
        ',', '.', '?' };
    
        String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
        ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
        "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
        "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
        "-----", "--..--", ".-.-.-", "..--.." };
        
        char [] chars = input.toLowerCase().toCharArray();
        StringBuilder response = new StringBuilder();

        for (int i = 0; i < chars.length; i++){
            for (int j = 0; j < alphabet.length; j++){
                if (alphabet[j] == chars[i]){
                    response.append(morse[j]);
                    response.append(" ");
                    break;
                } 
                else if (chars[i] == ' ') {
                    response.append("   ");
                    break;
                }
            }
        }
        return response.toString();
    }
}
