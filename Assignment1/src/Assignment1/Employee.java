package Assignment1;

public class Employee {
    private String name, email;
    private String phNo;
    private double pmSalary, pdSalary;

    public Employee(){}

    public Employee(String name, String email, String phNo, double pmSalary, double pdSalary) {
        this.name = name;
        this.email = email;
        this.phNo = phNo;
        this.pmSalary = pmSalary;
        this.pdSalary = pdSalary;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhNo() {
        return phNo;
    }

    public double getPmSalary() {
        return pmSalary;
    }

    public double getPdSalary() {
        return pdSalary;
    }

    public String getNameByPhoneNo(String phNo){
       // Employee e = ;

        return this.name;
    }

}
