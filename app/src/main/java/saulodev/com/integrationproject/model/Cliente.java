package saulodev.com.integrationproject.model;

import com.google.gson.annotations.SerializedName;

public class Cliente {

    @SerializedName("idCliente")
    private int id;

    @SerializedName("nome")
    private String nome;

    @SerializedName("cpf")
    private String cpf;

    @SerializedName("dataNascimento")
    private String dataNascimento;

    @SerializedName("email")
    private String email;

    @SerializedName("renda")
    private double renda;

    @SerializedName("patrimonio")
    private double patrimonio;

    @SerializedName("saldo")
    private double saldo;

    @SerializedName("senha")
    private String senha;

    @SerializedName("conta")
    private int conta;

    @SerializedName("agencia")
    private int agencia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public double getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(double patrimonio) {
        this.patrimonio = patrimonio;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
}
