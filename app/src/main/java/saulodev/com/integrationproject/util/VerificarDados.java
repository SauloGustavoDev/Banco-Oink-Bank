package saulodev.com.integrationproject.util;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VerificarDados {

    //VERIFICAR SE CAMPO ESTÁ PREENCHIDO
    public boolean verificarPreenchido(String dado){
        return !dado.isEmpty();
    }

    //VALIDAR TAMANHOS
    /*public boolean verificaTamanhoTelefone(String dado){
        return dado.length() >= 15;
    }//*/
    public boolean verificaTamanhoCpf(String dado){
        return dado.length() >= 11;
    }

    //VALIDAR CPF
    public boolean validaCPF(String cpf) {
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
    public boolean verificarIdade(String dado){
        String dadoFormatado = dado.replace("/", "");
        int diasAnoBissexto = 0;
        int diaNoMes = 0;

        String diaDigitadoAux = String.valueOf(dadoFormatado.charAt(0)) + String.valueOf(dadoFormatado.charAt(1));
        String mesDigitadoAux = String.valueOf(dadoFormatado.charAt(2)) + String.valueOf(dadoFormatado.charAt(3));
        String anoDigitadoAux = String.valueOf(dadoFormatado.charAt(4)) + String.valueOf(dadoFormatado.charAt(5)) +  String.valueOf(dadoFormatado.charAt(6)) +  String.valueOf(dadoFormatado.charAt(7));

        int diaDigitado = Integer.parseInt(diaDigitadoAux);
        int mesDigitado = Integer.parseInt(mesDigitadoAux);
        int anoDigitado = Integer.parseInt(anoDigitadoAux);

        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy");
        Date data = new Date();
        String dataAtual= formataData.format(data);


        String diaAtualAux = String.valueOf(dadoFormatado.charAt(1)) + String.valueOf(dadoFormatado.charAt(2));
        String mesAtualAux = String.valueOf(dadoFormatado.charAt(3)) + String.valueOf(dadoFormatado.charAt(4));
        String anoAtualAux = String.valueOf(dataAtual.charAt(6)) + String.valueOf(dataAtual.charAt(7)) + String.valueOf(dataAtual.charAt(8)) + String.valueOf(dataAtual.charAt(9));


        int diaAtual = Integer.parseInt(diaAtualAux);
        int mesAtual = Integer.parseInt(mesAtualAux);
        int anoAtual = Integer.parseInt(anoAtualAux);

        Log.d("data", "dia atual: " + Integer.toString(diaAtual));
        Log.d("data", "mes atual: " + Integer.toString(mesAtual));
        Log.d("data", "ano atual: " + Integer.toString(anoAtual));


        int bissexto = 0;

        if(anoAtual%4 == 0)
            bissexto = 1;

        int[] diasNoMes = {
                31,28 + bissexto ,31,30,31,30,
                31,31,30,31,30,31
        };

        return (anoDigitado <= anoAtual - 18) && (anoDigitado < anoAtual - 18 || mesDigitado <= mesAtual) && (anoDigitado < anoAtual - 18 || mesDigitado < mesAtual || diaDigitado < diaAtual);

    }
    public boolean verificarDataValida(String dado){

        String dadoFormatado = dado.replace("/", "");

        if(dadoFormatado.length() < 8)
            return false;

        for(int i = 0; i < dadoFormatado.length(); i++){
            Log.d("dado", String.valueOf(dadoFormatado.charAt(i)));
        }

        String diaDigitadoAux = String.valueOf(dadoFormatado.charAt(0)) + String.valueOf(dadoFormatado.charAt(1));
        String mesDigitadoAux = String.valueOf(dadoFormatado.charAt(2)) + String.valueOf(dadoFormatado.charAt(3));
        String anoDigitadoAux = String.valueOf(dadoFormatado.charAt(4)) + String.valueOf(dadoFormatado.charAt(5)) +  String.valueOf(dadoFormatado.charAt(6)) +  String.valueOf(dadoFormatado.charAt(7));
        Log.d("dado", diaDigitadoAux);
        int diaDigitado = Integer.parseInt(diaDigitadoAux);
        int mesDigitado = Integer.parseInt(mesDigitadoAux);
        int anoDigitado = Integer.parseInt(anoDigitadoAux);


        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy");
        Date data = new Date();
        String dataAtual= formataData.format(data);

        String anoAtualAux = String.valueOf(dataAtual.charAt(6)) + String.valueOf(dataAtual.charAt(7)) + String.valueOf(dataAtual.charAt(8)) + String.valueOf(dataAtual.charAt(9));
        int anoAtual = Integer.parseInt(anoAtualAux);

        int bissexto = 0;

        if(anoAtual%4 == 0)
            bissexto = 1;

        int[] diasNoMes = {
                31,28 + bissexto ,31,30,31,30,
                31,31,30,31,30,31
        };

        return anoDigitado <= anoAtual && 0 <= diaDigitado && diaDigitado <= diasNoMes[mesDigitado - 1] && mesDigitado <= 12 && mesDigitado > 0;
    }

    //VERIFICAR SE EXISTE CARACTÉRES ESPECIAIS
    public boolean verificarCaracterEspecial(String dado){
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
    public boolean maiorQueZero(String dado){
        return Double.parseDouble(dado)>0;
    }

    //VERIFICAR SENHAS
    public boolean verificarSenha(String dado, String verificador){
        return dado.length() == 6 && dado.equals(verificador);
    }
}
