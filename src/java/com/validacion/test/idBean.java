package com.validacion.test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="idBean")
@SessionScoped
public class idBean {

String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
}
