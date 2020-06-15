package com.abclearning;

abstract public class Employee {
    private static int countEmployee;
    String name;
    double baseSalary;
    int ID;
    double bonus;
    public double bonusBudget;
    public int headcount = 0;
    public Employee manager;
    public Accountant accountantSupport;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        countEmployee++;
        this.ID = countEmployee;
    }

    //Overloading constructing
    public Employee(String name) {
        super();
        this.name = name;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public String getName() {
        return this.name;
    }

    public int getEmployeeID() {
        return this.ID;
    }

    public boolean equals(Employee other) {
        return this.getEmployeeID() == other.getEmployeeID();
    }

    public String toString() {
        return (this.getEmployeeID() + " " + this.getName());
    }

    public Employee getManager(){
        return this.manager;
    };

    public void setManager(Employee manager){
        this.manager = manager;
    }

    public Accountant getAccountantSupport(){
        return this.accountantSupport;
    }

    abstract public String employeeStatus();
}
