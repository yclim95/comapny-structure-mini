package com.abclearning;

abstract public class Employee {
    String name;
    double baseSalary;
    int ID;
    private static int countEmployee;
    double bonus;

    public Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
        countEmployee++;
        this.ID = countEmployee;
    }

    //Overloading constructing
    public Employee(String name){
        super();
        this.name = name;
    }

    public double getBaseSalary(){
        return this.baseSalary;
    }

    public String getName(){
        return this.name;
    }

    public int getEmployeeID(){
        return this.ID;
    }

    public boolean equals (Employee other){
        return this.ID == other.ID;
    }

    public String toString(){
        return (this.ID + " " + this.name);
    }

    abstract public Employee getManager();

    abstract public String employeeStatus();
}
