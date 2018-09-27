package org.sample.solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortMapByValue {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("1", "cb");
        map.put("2", "ab");
        map.put("3", "bc");
        map.put("4", "tr");
        map.put("5", "az");

        System.out.println(map);

        final Map<String, String> sortedMap = map.entrySet().stream()
                .sorted(Entry.comparingByValue())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("NORMAL_UNSORTED_MAP:-> "+map);
        System.out.println("NORMAL_SORTED_MAP:-> "+sortedMap);


        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put("1", new Employee("764756", "Shantanu", "54666"));
        employeeMap.put("2", new Employee("164756", "Priya", "787558"));
        employeeMap.put("3", new Employee("754756", "Rajneesh", "585852"));
        employeeMap.put("4", new Employee("964756", "KanagRaj", "868328235"));

        final Map<String, Employee> employeeSortedMap = employeeMap.entrySet().stream()
                .sorted(Comparator.comparing(e -> e.getValue().getEmployeeName()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("EMPLOYEE_UNSORTED_MAP:-> "+employeeMap);
        System.out.println("EMPLOYEE_SORTED_MAP:-> "+employeeSortedMap);
    }
}

class Employee {

    private String employeeId;
    private String employeeName;
    private String employeeSalary;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, String employeeSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("employeeId='").append(employeeId).append('\'');
        sb.append(", employeeName='").append(employeeName).append('\'');
        sb.append(", employeeSalary='").append(employeeSalary).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

