package saulodev.com.integrationproject.model;
public class Contato {
    private String nome;
    private String chave;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Contato(String nome, String chave) {
        this.nome = nome;
        this.chave = chave;
    }
}
