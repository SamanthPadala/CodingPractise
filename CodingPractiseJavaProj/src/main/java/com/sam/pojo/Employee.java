package com.sam.pojo;

public class Employee {

    private int id;
    private String name;
    private String address;
    private double salary;
    private String department;
    private String hobby;
    private String favColor;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getHobby() {
        return hobby;
    }

    public String getFavColor() {
        return favColor;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", hobby='" + hobby + '\'' +
                ", favColor='" + favColor + '\'' +
                '}';
    }

    private Employee(EmpBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.salary = builder.salary;
        this.department = builder.department;
        this.hobby = builder.hobby;
        this.favColor = builder.favColor;
    }

    public static class EmpBuilder {
        private int id;
        private String name;
        private String address;
        private double salary;
        private String department;
        private String hobby;
        private String favColor;

        // mandatory fields
        public EmpBuilder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public EmpBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public EmpBuilder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public EmpBuilder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public EmpBuilder setHobby(String hobby) {
            this.hobby = hobby;
            return this;
        }

        public EmpBuilder setFavColor(String favColor) {
            this.favColor = favColor;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
