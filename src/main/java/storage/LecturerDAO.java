package storage;

import dto.Lecturer;

import java.sql.*;

/**
 * Created by Norik on 28.03.2017.
 */
public class LecturerDAO {
    private ConnectionManager connectionManager;

    private static final LecturerDAO instance  = new LecturerDAO();

    private LecturerDAO(){
        connectionManager = ConnectionManager.getInstance();
    }

    public static LecturerDAO getLecturerDAO(){
        return instance;
    }

    public void addLecturer(Lecturer lecturer){
        String query = "INSERT  INTO  lecturer(firstName,lastName) VALUE (?,?)";
        setLecturer(query,lecturer);
    }

    public void updateLecturer(int id, Lecturer lecturer){
        String query = "UPDATE  lecturer SET firstName = ?, lastName = ? WHERE lecturerID = " + id;
        setLecturer(query,lecturer);
    }

    public void deleteLecturer(int lecturerID){
        if (lecturerID < 0)
            throw new IllegalArgumentException();
        String query = "DELETE FROM student.lecturer WHERE lecturerID = " + lecturerID;
        try {
            PreparedStatement statement  = connectionManager.getPreparedStatemant(query);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public  Lecturer getLecturer(int lecturerID){
        String query = "SELECT firstName, lastName FROM lecturer WHERE  lecturerID = " + lecturerID;
        Lecturer lecturer = null;
        try {
            PreparedStatement statement = connectionManager.getPreparedStatemant(query);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String firstName = resultSet.getNString("firstName");
                String lastName = resultSet.getNString("lastName");
                lecturer = new Lecturer(firstName, lastName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lecturer;
    }

    private  void setLecturer(String query, Lecturer lecturer){
        try {
            PreparedStatement statement = connectionManager.getPreparedStatemant(query);
            statement.setNString(1,lecturer.getFirstName());
            statement.setNString(2,lecturer.getLastName());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

