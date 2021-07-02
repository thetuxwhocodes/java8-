package com.thetuxwhocodes.java8andbeyond.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentOperations {
    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student(1, "S1", "D1", 1000),
                new Student(2, "S2", "D1", 998),
                new Student(3, "S3", "D1", 990),
                new Student(4, "S4", "D2", 803),
                new Student(5, "S5", "D2", 993),
                new Student(6, "S6", "D2", 995),
                new Student(7, "S7", "D3", 1000),
                new Student(8, "S8", "D3", 990),
                new Student(9, "S9", "D3", 803)
        );

        /*
         * Simple filter. Get all Students belonging to a particular department
         */
        System.out.println("Find all Students from Dept D2");
        List<String> d2Students = students.stream().filter(s -> s.getDept().equals("D2")).map(Student::getName).collect(Collectors.toList());
        System.out.println(d2Students);
        System.out.println();

        /*
         * Simple grouping example. Group all Students by department
         */
        System.out.println("Group all Students by Dept");
        Map<String, List<Student>> studentsByDept =  students.stream().collect(Collectors.groupingBy(Student::getDept));
        System.out.println(studentsByDept);
        System.out.println();

        /*
         * Group all Student Names by department
         */
        System.out.println("Group all Student Names by Dept");
        Map<String, String> studentNamesByDept =  students.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.mapping(Student::getName, Collectors.joining(", ", "[", "]"))));
        System.out.println(studentNamesByDept);
        System.out.println();

        /*
         * Finding the topper of the class
         *
         * 1. One method which is very easy is to use Stream.max()
         * 2. Other option is use Collectors.maxBy
         *
         * Both have min versions as well.
         */

        System.out.println("Using Stream max/min");
        Student topper = students.stream().max(Comparator.comparing(Student::getTotalMarks)).get();
        System.out.println("Topper: " + topper.getName());
        Student needImprovement = students.stream().min(Comparator.comparing(Student::getTotalMarks)).get();
        System.out.println("Need Improvement: " + needImprovement.getName());
        System.out.println();

        System.out.println("Using Collectors maxBy/minBy");
        Student topper_ = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getTotalMarks))).get();
        System.out.println("Topper: " + topper_.getName());
        Student needImprovement_ = students.stream().collect(Collectors.minBy(Comparator.comparing(Student::getTotalMarks))).get();
        System.out.println("Need Improvement: " + needImprovement_.getName());
        System.out.println();

        /*
         * Both scenarios return only one element that matches the condition.
         * But actually there are more than 1. We need all of them.
         * As of now I see only a 2 step process for this.
         *  First get the top marks, then filter everyone with the top marks. Same for min marks.
         */

        System.out.println("Using the 2 step approach");
        int topMarks = students.stream().mapToInt(Student::getTotalMarks).max().getAsInt();
        List<String> toppers = students.stream().filter(s -> s.getTotalMarks() == topMarks).map(Student::getName).collect(Collectors.toList());
        System.out.println("Toppers: " + toppers);
        int leastMarks = students.stream().mapToInt(Student::getTotalMarks).min().getAsInt();
        List<String> needsImprovement = students.stream().filter(s -> s.getTotalMarks() == leastMarks).map(Student::getName).collect(Collectors.toList());
        System.out.println("needsImprovement: " + needsImprovement);
        System.out.println();

    }
}

class Student {
    int id;
    String name;
    String dept;
    int totalMarks;

    public Student(int id, String name, String dept, int totalMarks) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.totalMarks = totalMarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", totalMarks=" + totalMarks +
                '}';
    }
}
