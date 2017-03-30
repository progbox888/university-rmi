package storage;


import dto.Student;

import java.sql.*;

/**
 * Created by Norik on 28.03.2017.
 */
public class StudentDAO {
    private ConnectionManager connectionManager;

    private static final StudentDAO instance  = new StudentDAO();

    private StudentDAO(){
            this.connectionManager = ConnectionManager.getInstance();
    }

    public static StudentDAO getStudentDAO(){
        return instance;
    }

    public void addStudent(Student student){
        String query = "INSERT  INTO  student(firstName,lastName,email, phoneNumber) VALUE (?,?,?,?)";
        setStudent(query,student);
    }

    public void updateStudent(int id, Student student){
        String query = "UPDATE  student SET firstName = ?,lastName = ?, email = ?, " +
                "phoneNumber = ? WHERE studentID = " + id;
        setStudent(query,student);
    }

    public void deleteStudent(int studentID){
        if (studentID < 0)
            throw new IllegalArgumentException();
        String query = "DELETE FROM student.student WHERE studentID = " + studentID;
        try {
            PreparedStatement statement  = connectionManager.getPreparedStatemant(query);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public  Student getStudent(int studentID){
        String query = "SELECT firstName, lastName,email,phoneNumber FROM student WHERE  studentID = " + studentID;
        Student student = null;
        try {
            PreparedStatement statement = connectionManager.getPreparedStatemant(query);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phoneNumber");
                student = new Student(firstName, lastName, email, phoneNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    private  void setStudent(String query, Student student){
        try {
            PreparedStatement statement = connectionManager.getPreparedStatemant(query);
            statement.setNString(1,student.getFirstName());
            statement.setNString(2,student.getLastName());
            statement.setNString(3,student.getEmail());
            statement.setNString(4,student.getPhoneNumber());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


