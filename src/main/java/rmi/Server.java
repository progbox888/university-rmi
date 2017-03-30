package rmi;

import dto.Course;
import dto.Lecturer;
import dto.Student;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

/**
 * Created by Norik on 30.03.2017.
 */
 public interface Server extends Remote{

     void addStudent(Student student) throws RemoteException;

     Student getStudent(int studentID)throws RemoteException;

     void updateStudent(int id,Student student) throws RemoteException;

     void deleteStudent(int studentID) throws RemoteException;

     void addCourse(Course course) throws RemoteException;

     Course getCourse(int id) throws RemoteException;

     void updateCourse(int courseID, Course course) throws RemoteException;

     void deleteCourse(int id) throws RemoteException;

     void addLecturer(Lecturer lecturer) throws RemoteException;

     Lecturer getLecturer(int id) throws RemoteException;

     void updateLecturer(int id, Lecturer lecturer) throws RemoteException;

     void deleteLecturer(int id) throws RemoteException;

     void assignGradeToStudent(int studentID, int courseID, int grade) throws RemoteException;

     void assignLecturerToCourse(int courseID, int lecturerID) throws RemoteException;


     Map<Integer,Integer> getStudentGrades(int studentID) throws RemoteException;
}
