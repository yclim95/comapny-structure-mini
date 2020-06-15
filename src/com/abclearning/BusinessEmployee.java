package com.abclearning;

abstract public class BusinessEmployee extends Employee{
    public BusinessEmployee(String name){
        super(name, 50000.0);
    }

    public double getBonusBudget(){
        return bonusBudget;
    }
    public void setBonusBudget(double bonusBudget){
        this.bonusBudget = bonusBudget;
    }

    public String employeeStatus() {
        String s = String.format("%.2f",getBonusBudget());
        return this.toString() + " with a budget of " + s;
    }
}
