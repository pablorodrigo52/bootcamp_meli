package br.com.mercadolivre.starwars.dto;

import org.apache.tomcat.util.buf.CharChunk;

import br.com.mercadolivre.starwars.entities.Character;

/**
 * Character
 */
public class CharacterDTO {

    private String name, hairColor, skinColor, eyeColoe, birthYear, gender, homeworld, species;
    private int height;
    private int mass;



    public CharacterDTO() {
    }

    public CharacterDTO(String name, String hairColor, String skinColor, String eyeColoe, String birthYear, String gender, String homeworld, String species, int height, int mass) {
        this.name = name;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColoe = eyeColoe;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
        this.height = height;
        this.mass = mass;
    }

    public static CharacterDTO convert (Character character){
        return new CharacterDTO(
            character.getName(), 
            character.getHairColor(), 
            character.getSkinColor(), 
            character.getEyeColoe(), 
            character.getBirthYear(), 
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

    public String getHairColor() {
        return this.hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return this.skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getEyeColoe() {
        return this.eyeColoe;
    }

    public void setEyeColoe(String eyeColoe) {
        this.eyeColoe = eyeColoe;
    }

    public String getBirthYear() {
        return this.birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
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