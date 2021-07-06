package br.com.mercadolivre.linktracer.dtos;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mercadolivre.linktracer.entities.Link;

public class LinkDTO {

    private String id;
    private String url;
    private long access;
    private boolean valid;

    public LinkDTO(){}
 
    public LinkDTO(String url) {
        this.url = url;
    }

    public LinkDTO(String id, String url){
        this.id = id;
        this.url = url;
    }

    public LinkDTO(String id, String url, long access, boolean valid){
        this.id = id;
        this.url = url;
        this.access = access;
        this.valid = valid;
    }

    public LinkDTO(Link link){
        this.url = link.getUrl();
        this.id = link.getId();
        this.access = link.getAccess();
        this.valid = link.getValid();
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

    public void setUrl(String url) {
        this.url = url;
    }

    public long getAccess() {
        return this.access;
    }

    public void setAccess(long access) {
        this.access = access;
    }
        
    public static Link convert (LinkDTO linkDto){
        return new Link(linkDto);
    }

    public static LinkDTO convert (Link link){
        return new LinkDTO(link);
    }

    public static List<LinkDTO> convert (List<Link> links){
        return links.stream().map(LinkDTO::convert).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "{" +
            " \"id\":\"" + getId() + "\"" +
            ", \"url\":\"" + getUrl() + "\"" +
            ", \"access\":\"" + getAccess() + "\"" +
            "}";
    }

}
