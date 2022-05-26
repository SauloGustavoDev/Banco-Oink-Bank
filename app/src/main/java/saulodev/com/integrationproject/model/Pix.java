package saulodev.com.integrationproject.model;

import com.google.gson.annotations.SerializedName;

public class Pix {

    @SerializedName("idPix")
    private int idPix;

    @SerializedName("cpf")
    private String cpf;

    @SerializedName("email")
    private String email;

    @SerializedName("telefone")
    private String celular;

    @SerializedName("aleatoria")
    private String aleatoria;

    public int getIdPix() {
        return idPix;
    }

    public void setIdPix(int idPix) {
        this.idPix = idPix;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getAleatoria() {
        return aleatoria;
    }

    public void setAleatoria(String aleatoria) {
        this.aleatoria = aleatoria;
    }
}
