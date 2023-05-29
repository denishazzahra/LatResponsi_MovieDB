/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.MovieController;
import Model.MovieModel;
import View.MovieView;

/**
 *
 * @author LENOVO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MovieView MV=new MovieView();
        MovieModel MM=new MovieModel();
        MovieController MC=new MovieController(MM,MV);
        MV.setVisible(true);
    }
    
}
