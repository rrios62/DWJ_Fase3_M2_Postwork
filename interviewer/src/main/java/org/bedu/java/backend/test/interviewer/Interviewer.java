package org.bedu.java.backend.test.interviewer;

import java.io.*;
import java.util.ArrayList;

public class Interviewer implements Serializable {
    static ArrayList<Interviewer> data;
        int id;//Se cambio el tipo de dato a int para que la prueba de hamcrest pudiera correr
        String name;
        String lastName;
        String email;
        Boolean isActive;

          public Interviewer(String name, String lastName, String email, Boolean isActive){
               this.id = (int) (data.size()+1);
               this.name = name;
               this.lastName = lastName;
               this.email = email;
               this.isActive = isActive;
             }
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Interviewer add(){
          data.add(this);
           return this;
    }

    public void save(
                  String name,
                  String lastName,
                  String email,
                  Boolean isActive
          ){
              if (!name.equals(""))
                  this.name = name;

              if (!lastName.equals(""))
                  this.lastName = lastName;

              if (!email.equals(""))
                  this.email = email;

              this.isActive = isActive;

              data.add(this);
          }
    public static Interviewer getByEmail(String email) {
        for (Interviewer interviewer: data) {
            if (interviewer.email.equals(email))
                return interviewer;
        }

        return null;
    }

    public void delete() {
        data.remove(this);
    }

    public static void saveDataToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./interviewers");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(Interviewer.data);

            outputStream.close();
            fileOutputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void loadDataFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("./interviewers");
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

            ArrayList<Interviewer> fileData = (ArrayList<Interviewer>) inputStream.readObject();

            Interviewer.data.clear();
            Interviewer.data.addAll(fileData);

            inputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            if (!e.getMessage().contains("No such file or directory"))
                e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "\nID: " + this.id +
                "\nName: " + this.name +
                "\nLast Name: " + this.lastName +
                "\nEmail: " + this.email +
                "\nIs Active: " + this.isActive + "\n";
    }
}
