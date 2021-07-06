package br.com.mercadolivre.linktracer.entities;

import java.util.UUID;

import br.com.mercadolivre.linktracer.dtos.LinkDTO;

/**
 * Link
 */
public class Link {

    private String id;
    private String url;
    private long access = 0;
    private boolean valid = true;

    public Link(){}

    public Link(String id, String url, long access, boolean valid) {
        this.id = id;
        this.url = url;
        this.access = access;
        this.valid = valid;
    }

    public Link(LinkDTO linkDTO){
        this.id = UUID.randomUUID().toString();
        this.url = linkDTO.getUrl();
        this.access = linkDTO.getAccess();
        this.valid = linkDTO.getValid();
    }

    public boolean isValid() {
        return this.valid;
    }

    public boolean getValid() {
        return this.valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setLink(String url) {
        this.url = url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public long getAccess() {
        return this.access;
    }

    public void setAccess(long access) {
        this.access = access;
    }

}