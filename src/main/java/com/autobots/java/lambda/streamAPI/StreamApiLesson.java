package com.autobots.java.lambda.streamAPI;

import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameEvent;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class StreamApiLesson {
    public static void main(String[] args) {

        List<String> names = List.of("Anna", "Bob", "Alex", "Bella", "Andrew");
//        for (String name : names){
//            if (name.startsWith("A"))
//                System.out.println(name);
//        }
        List<String> result = names.stream()
                .filter(name ->name.startsWith("A"))
                .map(String :: toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);

    List<Integer> numbers = List.of(1,2,3,4,5,6);
    int r1 = 0;
    for (int num : numbers){
        r1 +=num;
    }
        System.out.println(r1);
    int totalSum = numbers.stream()
            .mapToInt(num -> num)
            .sum();
        System.out.println(totalSum);

    int totalElements = (int) numbers.stream()
            .count();
        System.out.println(totalElements);

        numbers.stream()
                .min(Integer::compare)
                .ifPresent(System.out::println);


        List<String> list1 = List.of("one", "two", "three","Hello", "four", "five");
        list1.stream()
                .filter(s -> s.length()>3)
                .findFirst()
                .ifPresent(System.out::println);

                List<Employee> employees = List.of(
                        new Employee(1, "Alice", 28, 3000, "IT"),
                        new Employee(2, "Bob", 35, 4000, "HR"),
                        new Employee(3, "Charlie", 40, 5000, "Finance"),
                        new Employee(4, "David", 25, 3500, "IT"),
                        new Employee(5, "Eva", 30, 4200, "Marketing"),
                        new Employee(6, "Frank", 45, 6000, "Finance"),
                        new Employee(7, "Grace", 32, 4100, "HR"),
                        new Employee(8, "Henry", 29, 3900, "IT"),
                        new Employee(9, "Isabel", 38, 4500, "Marketing"),
                        new Employee(10, "Jack", 27, 3600, "IT")
                );
                List<Employee> ITemployees = employees.stream()
                        .filter(s -> s.getDepartment().equalsIgnoreCase("IT"))
                        .collect(Collectors.toList());
        System.out.println(ITemployees);



        List<Employee> ITEmployees2 = new ArrayList<>();
        for (Employee employee : employees){
            if (employee.getDepartment().equalsIgnoreCase("IT")){
                ITEmployees2.add(employee);
            }
        } System.out.println(ITEmployees2);

        Map<String,List<Employee>> employeesByDeparted = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(employeesByDeparted);
        employeesByDeparted.forEach((Departament, list) ->{
            System.out.println("Otdel " + Departament);
            list.forEach(System.out::println);
        });

        Map<String, List<Employee>> employeesByDepartment = new HashMap<>();

        for (Employee employee : employees){
            employeesByDepartment.putIfAbsent(employee.getDepartment(), new ArrayList<>());
            employeesByDepartment.get(employee.getDepartment()).add(employee);
        }
        for (Map.Entry<String, List<Employee>>entry : employeesByDepartment.entrySet()){
            System.out.println(entry.getKey() + "\n" + entry.getValue());
        }
        System.out.println(employeesByDepartment);

    }
}
