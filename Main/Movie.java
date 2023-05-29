/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author LENOVO
 */
public class Movie implements MovieInterface {
    private String title;
    private double storyline,characterization,acting;
    private String newTitle;
    public Movie(String title, double storyline, double characterization, double acting) {
        this.title = title;
        this.storyline = storyline;
        this.characterization = characterization;
        this.acting = acting;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getStoryline() {
        return storyline;
    }

    public void setStoryline(double storyline) {
        this.storyline = storyline;
    }

    public double getCharacterization() {
        return characterization;
    }

    public void setCharacterization(double characterization) {
        this.characterization = characterization;
    }

    public double getActing() {
        return acting;
    }

    public void setActing(double acting) {
        this.acting = acting;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }
    
    @Override
    public double movieRating() {
        return (storyline+characterization+acting)/3;
    }
    
    
}
