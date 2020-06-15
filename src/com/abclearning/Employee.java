package com.abclearning;

abstract public class Employee {
    private static int countEmployee; // + 1 for each employee added
    String name; // Employee name
    double baseSalary; // Base Salary based on the role
    int ID; // Based on countEmployee
    double bonus; // Bonus given to employee
    public double bonusBudget; // Bonus Budget given to employee
    public int headCount = 0; // The number of employee under a manager
    public Employee manager; // Manager (Technical Lead & Business Lead)
    public Accountant accountantSupport; // Support given by Accountant to Technical) Lead for bonus

    //Construct Employee with two parameters name and base salary
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        countEmployee++;
        this.ID = countEmployee;
    }

    //Should return the employee's base salary
    public double getBaseSalary() {
        return this.baseSalary;
    }
    //Should return the employee's name
    public String getName() {
        return this.name;
    }
    //Should return the employee's ID.
    public int getEmployeeID() {
        return this.ID;
    }
    //Should return true if the two employee’s ID are the same, false otherwise
    public boolean equals(Employee other) {
        return this.getEmployeeID() == other.getEmployeeID();
    }
    /*
     * Should return a String representation of the employee that
     * is a combination of their id followed by their name.
     * Example: "1 Kasey"
     */
    public String toString() {
        return (this.getEmployeeID() + " " + this.getName());
    }
    //Should return a reference to the Employee object that represents this employee's manager
    public Employee getManager(){
        return this.manager;
    }
    // Should set reference to Employee object that represent this employee's manager
    public void setManager(Employee manager){
        this.manager = manager;
    }
    // Should return a reference to Accountant as a support to Technical Lead for bonus
    public Accountant getAccountantSupport(){
        return this.accountantSupport;
    }
    /*
     * Should return a String representation of that Employee's current status.
     * This will be different for every subclass of Employee
     */
    abstract public String employeeStatus();
}
