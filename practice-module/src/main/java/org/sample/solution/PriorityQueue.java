package org.sample.solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {
        List<Student> students = new ArrayList<>();
        Comparator<Student> studentComparator = (s1, s2) -> {
            if (s1.getCGPA() != s2.getCGPA()) {
                return s1.getCGPA() > s2.getCGPA() ? -1 : 1;
            } else if (!s1.getName().equals(s2.getName())) {
                return s1.getName().compareTo(s2.getName());
            } else {
                return s1.getID() > s2.getID() ? -1 : 1;
            }
        };
        for (String event : events) {
            if (event.startsWith("ENTER")) {
                String[] student = event.split(" ");
                students.add(new Student(student[1],
                        Double.parseDouble(student[2]),
                        Integer.parseInt(student[3])));
            }
            students.sort(studentComparator);
            if (students.size()>0&&event.startsWith("SERVED")) {
                students.remove(0);
            }
        }
        return students;
    }
}

class Student {

    private long id;
    private String name;
    private double cgpa;

    public Student(String name, double cgpa, int id) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public long getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}