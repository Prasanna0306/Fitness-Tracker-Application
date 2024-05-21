package com.project.fitness.model;


import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.cj.Driver");
            Connection con = DriverManager.getConnection(null, null, null);
            String q = "select * from user where user_id = ?";
            PreparedStatement st = con.prepareStatement(q);
            st.setInt(0, 1);
            ResultSet  rs = st.executeQuery(q);
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }   
        }catch(Exception e){
            System.out.println(e);
        }
    }



}
