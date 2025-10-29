package com.sam.listOperations;

import com.sam.pojo.Employee;

import java.util.ArrayList;
import java.util.List;

public class ListOperations {

    public static void main() {

    }

    public void sortList() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee.EmpBuilder(1, "abc").setAddress("hyd").setSalary(1000).build());
        list.add(new Employee.EmpBuilder(2, "def").setAddress("sec").setDepartment("HR").setSalary(2000).build());
        list.add(new Employee.EmpBuilder(3, "ghi").setAddress("nzb").setDepartment("IT").setSalary(3000).setHobby("cricket").build());
        list.add(new Employee.EmpBuilder(4, "pwo").setAddress("sdpt").setDepartment("Finance").setSalary(4000).setHobby("chess").setFavColor("White").build());

    }




}
