package com.abclearning;

abstract public class BusinessEmployee extends Employee{
    public BusinessEmployee(String name){
        super(name, 50000.0); // Has a default salary of 50000
    }
    // return BonusBudget
    public double getBonusBudget(){
        return bonusBudget;
    }
    /*
     * Should return a String representation of this BusinessEmployee
     * that includes their ID, name and the size of their currently managed budget.
     * Example: "1 Kasey with a budget of 22500.0"
     */
    public String employeeStatus() {
        String s = String.format("%.2f",getBonusBudget());
        return this.toString() + " with a budget of " + s;
    }
}
