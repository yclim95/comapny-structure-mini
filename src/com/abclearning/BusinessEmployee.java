package com.abclearning;

abstract public class BusinessEmployee extends Employee{
    double budget;
    public BusinessEmployee(String name){
        super(name, 50000.0);
    }

    public double getBonusBudget(){
        return this.budget;
    }
    abstract public Employee getManager();

    public String employeeStatus() {
        return (this.ID + " " + this.name) + "with a budget of " + this.budget;
    }
}
