package saulodev.com.integrationproject.model;

public class KeyModel {

    private String type;
    private String description;

    public KeyModel(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public KeyModel(){

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
