/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Main.Movie;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author LENOVO
 */
public class MovieModel extends Connector {
    
    public void deleteMovie(Movie m){
        try{
            String query="DELETE from movie WHERE judul='"+m.getTitle()+"'";
            statement=connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Delete success!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Delete failed!");
        }
    }
    
    public void updateMovie(Movie m){
        try{
            String query="UPDATE movie set judul='"+m.getNewTitle()+"', alur='"+m.getStoryline()+"', penokohan='"+m.getCharacterization()+"', akting='"+m.getActing()+"', nilai='"+m.movieRating()+"' WHERE judul='"+m.getTitle()+"'";
            statement=connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Update success!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Update failed!");
        }
    }
    
    public void addMovie(Movie m){
        try{
            String query="INSERT INTO movie VALUES ('"+m.getTitle()+"','"+m.getStoryline()+"','"+m.getCharacterization()+"','"+m.getActing()+"','"+m.movieRating()+"')";
            statement=connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Insert success!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Insert failed!");
        }
    }
    
    public boolean checkTitle(String title){
        try{
            String query="SELECT COUNT(*) as total from movie where judul='"+title+"'";
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                if(rs.getString("total").equals("0")){
                    return true;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Checking failed!");
        }
        JOptionPane.showMessageDialog(null, "Movie title already existed!");
        return false;
    }
    
    public boolean checkUpdate(String oldTitle,String newTitle){
        try{
            String query="SELECT COUNT(*) as total from movie where judul='"+newTitle+"'  and judul!='"+oldTitle+"'";
            System.out.println(query);
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                if(rs.getString("total").equals("0")){
                    return true;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Checking failed!");
        }
        JOptionPane.showMessageDialog(null, "Movie title already existed!");
        return false;
    }
    
    public String[][] readMovie(){
        String[][] data=new String[numOfMovie()][5];
        int total=0;
        try{
            String query="SELECT * from movie";
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                data[total][0]=rs.getString("judul");
                data[total][1]=rs.getString("alur");
                data[total][2]=rs.getString("penokohan");
                data[total][3]=rs.getString("akting");
                data[total][4]=rs.getString("nilai");
                total++;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Read data failed!");
        }
        return data;
    }
    
    public int numOfMovie(){
        int total=0;
        try{
            String query="SELECT * from movie";
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                total++;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Read data failed!");
        }
        return total;
    }
}
