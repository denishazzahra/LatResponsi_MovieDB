/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.Movie;
import Model.MovieModel;
import View.MovieView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class MovieController {
    MovieModel MM;
    MovieView MV;
    String[][] data;
    int row;
    public MovieController(MovieModel MM, MovieView MV) {
        this.MM = MM;
        this.MV = MV;
        showData();
        MV.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Movie m=new Movie(MV.getTitle(),MV.getStoryline(),MV.getCharacterization(),MV.getActing());
                if(MM.checkTitle(m.getTitle())){
                    MM.addMovie(m);
                    showData();
                }
            }
        });
        MV.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Movie m=new Movie(MV.getTitle(),MV.getStoryline(),MV.getCharacterization(),MV.getActing());
                MM.deleteMovie(m);
                showData();
            }
        });
        MV.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Movie m=new Movie(data[row][0],MV.getStoryline(),MV.getCharacterization(),MV.getActing());
                m.setNewTitle(MV.getTitle());
                if(MM.checkUpdate(m.getTitle(),m.getNewTitle())){
                    MM.updateMovie(m);
                    showData();
                }
            }
        });
        MV.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                MV.tfTitle.setText("");
                MV.tfStoryline.setText("");
                MV.tfCharacterization.setText("");
                MV.tfActing.setText("");
            }
        });
        MV.tableMovie.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                row=MV.tableMovie.getSelectedRow();
                MV.tfTitle.setText(data[row][0]);
                MV.tfStoryline.setText(data[row][1]);  
                MV.tfCharacterization.setText(data[row][2]);  
                MV.tfActing.setText(data[row][3]);  
            }
        });
    }
    void showData(){
        data=MM.readMovie();
        String[] columnName={"Title","Storyline","Characterization","Acting","Rating Score"};
        DefaultTableModel tableModel = new DefaultTableModel(data, columnName) {
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
            }
        };
        MV.tableMovie.setModel(tableModel);
    }
}
