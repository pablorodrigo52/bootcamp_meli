package br.com.mercadolivre.starwars.dto;

import org.apache.tomcat.util.buf.CharChunk;

import br.com.mercadolivre.starwars.entities.Character;

/**
 * Character
 */
public class CharacterDTO {

    private String name, hair_color, skin_color, eye_color, birth_year, gender, homeworld, species;
    private int height;
    private int mass;


    public CharacterDTO() {
    }

    public CharacterDTO(String name, String hair_color, String skin_color, String eye_color, String birth_year, String gender, String homeworld, String species, int height, int mass) {
        this.name = name;
        this.hair_color = hair_color;
        this.skin_color = skin_color;
        this.eye_color = eye_color;
        this.birth_year = birth_year;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
        this.height = height;
        this.mass = mass;
    }

    public static CharacterDTO convert (Character character){
        return new CharacterDTO(
            character.getName(), 
            character.getHair_color(), 
            character.getSkin_color(), 
            character.getEye_color(), 
            character.getBirth_year(), 
            character.getGender(), 
            character.getHomeworld(), 
            character.getSpecies(), 
            character.getHeight(), 
            character.getMass()
        );
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHair_color() {
        return this.hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public String getSkin_color() {
        return this.skin_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public String getEye_color() {
        return this.eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getBirth_year() {
        return this.birth_year;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return this.homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMass() {
        return this.mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }
}