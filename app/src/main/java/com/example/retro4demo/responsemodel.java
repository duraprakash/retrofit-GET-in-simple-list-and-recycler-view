package com.example.retro4demo;

public class responsemodel {
//    TODO: 1. change all attributes, constructors, getter and setter

    // 1.0 create model (MODAL CLASS [1])
    // and define attributes
    String id, name, desig;
    String image;

    // 1.1 create empty constructor
    public responsemodel() {
    }

    // 1.2 create constructor with parameter
    public responsemodel(String id, String name, String desig,
                         String image
    ) {
        this.id = id;
        this.name = name;
        this.desig = desig;
        this.image = image;
    }

    // 1.3 create getter and setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //1.4 go to apiset (API)
}
