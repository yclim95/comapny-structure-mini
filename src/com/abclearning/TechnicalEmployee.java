package com.abclearning;

abstract public class TechnicalEmployee extends Employee{
    int checkIn = 0;
    public TechnicalEmployee(String name){
        super(name, 75000.0);
    }

    public int checkIn(){
        return this.checkIn++;
    }

    abstract  public Employee getManager();

    public String employeeStatus() {
        return (this.ID + " " + this.name) + "has " + this.checkIn + "successful checkins\n";
    }
}
