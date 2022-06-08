package saulodev.com.integrationproject.util;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class VerificarDados {

    //VERIFICAR SE CAMPO ESTÁ PREENCHIDO
    public static boolean verificarPreenchido(String dado){
        return !dado.isEmpty();
    }

    //VALIDAR TAMANHOS
    /*public boolean verificaTamanhoTelefone(String dado){
        return dado.length() >= 15;
    }//*/
    public static boolean verificaTamanhoCpf(String dado){
        return dado.length() >= 11;
    }

    //Revisar critério de tamanho de nome
    public static boolean validarNome(String name) {
        return (name.contains(" ") && name.length() > 5);
    }

    //VALIDAR CPF
    public static boolean validaCPF(String cpf) {
        if (cpf.length() < 11) {
            return false;
        } else {

            int[] digitosFinais = new int[2];
            int[] digitosCpf = new int[10];
            int multiplicacao;
            int soma;
            int restoDivisao;

            for (int x = 0; x < 10; x++) {
                digitosCpf[x] = cpf.charAt(x);
            }

            if (digitosCpf[0] == digitosCpf[1] && digitosCpf[2] == digitosCpf[3] &&
                    digitosCpf[4] == digitosCpf[5] && digitosCpf[6] == digitosCpf[7] &&
                    digitosCpf[8] == digitosCpf[9]) {
                return false;
            } else {
                for (int indiceMultiplicacao = 0; indiceMultiplicacao < 2; indiceMultiplicacao++) {
                    if (indiceMultiplicacao == 0) {
                        multiplicacao = 10;
                    } else {
                        multiplicacao = 11;
                    }
                    soma = 0;

                    for (int indiceSoma = 0; indiceSoma < 9 + indiceMultiplicacao; indiceSoma++) {
                        soma = soma + Integer.parseInt(String.valueOf(cpf.charAt(indiceSoma))) * multiplicacao;
                        multiplicacao = multiplicacao - 1;
                    }

                    restoDivisao = soma % 11;

                    if (restoDivisao < 2) {
                        digitosFinais[indiceMultiplicacao] = 0;

                    } else {
                        digitosFinais[indiceMultiplicacao] = 11 - restoDivisao;

                    }
                }

                if (digitosFinais[0] == Integer.parseInt(String.valueOf(cpf.charAt(9))) &&
                        digitosFinais[1] == Integer.parseInt(String.valueOf(cpf.charAt(10)))) {
                    return true;
                } else {
                    //Inválido
                    return false;
                }
            }

        }
    }

    //VALIDAR IDADE | DATA
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean dateIsValid(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate d = LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static int calculoIdade(String date) {
        int ano, mes, dia;
        String[] dateArray = date.split("/");
        dia = Integer.parseInt(dateArray[0]);
        mes = Integer.parseInt(dateArray[1]);
        ano = Integer.parseInt(dateArray[2]);
        return (int) ChronoUnit.YEARS.between(LocalDate.of(ano, mes, dia), LocalDate.now());
    }

    //VERIFICAR SE EXISTE CARACTÉRES ESPECIAIS
    public static boolean verificarCaracterEspecial(String dado){
        String caracterEspecial = "0123456789!¹@²#³$£%¢¨¬&*()-_=+§´`[{ª]}º<>.;:'|°?-+*/";//Colocar o \ e " para verificar
        int contador = 0;
        for(int i = 0; i < dado.length(); i++){
            for(int j = 0; j < caracterEspecial.length(); j++) {
                if (dado.charAt(i) == caracterEspecial.charAt(j))
                    contador++;
            }
        }
        return contador == 0;
    }

    //VERIFICA SE VALOR É MAIOR QUE 0
    public static boolean maiorQueZero(String dado){
        return Double.parseDouble(dado)>0;
    }

    //VERIFICAR SENHAS
    public static boolean verificarSenha(String dado, String verificador){
        return dado.length() == 6 && dado.equals(verificador);
    }
}
