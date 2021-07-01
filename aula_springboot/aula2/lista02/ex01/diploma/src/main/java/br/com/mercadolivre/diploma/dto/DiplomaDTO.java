package br.com.mercadolivre.diploma.dto;

public class DiplomaDTO {
    
    private String msg;
    private String id;

    public DiplomaDTO(String msg, String id) {
        this.msg = msg;
        this.id = id;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
   
}
