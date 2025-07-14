//package com.autobots.java.lambda.streamAPI;
//import java.sql.Array;
//import java.util.ArrayList;
//import java.util.List;
//public interface Typing {
//    void pay(double amount);
//}
//abstract class Employee implements Typing {
//    protected String name;
//    protected itn id;
//
//    public Employee(String name, int id){
//        this.name = name;
//        this.id = id;
//    }
//    public abstract double calculateSalary();
//
//    @Override
//    public void pay (double amount){
//    }
//
//     public void printeDetails(){
//        System.out.println("Employee ID " + id + " Name: " +name);
//     }
//}
//
//Class Developer extends Employee {
//    private double hourlyRate;
//    private int hoursWorked;
//
//    public Developer (String name, int id, double hourlyRate, int hourseWorked){
//        super(name,id);
//        this.hourlyRate = hourlyRate;
//        this.hoursWorked = hourseWorked;
//    }
//
//    @Override
//            public double calculateSalary(){
//        return hourlyRate * hourseWorked;
//
//    }
//}
//class Manager extends Employee {
//    private double fixedSalary;
//    private double bonus;
//
//    public Manager (String name , int id, double fixedSalary, double bonus){
//        super(name, id );
//        this.fixedSalary= fixedSalary;
//        this.bonus = bonusl
//    }
//
//    @Override
//    public double calculateSalary () {
//        return fixedSalary + bonus;
//    }
//}
//public class Company {
//    private List<Employee> employees;
//
//    public Company (){
//        employees= new ArrayList<>();
//    }
//}