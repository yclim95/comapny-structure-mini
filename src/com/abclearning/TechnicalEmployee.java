package com.abclearning;

abstract public class TechnicalEmployee extends Employee{
    public int checkIn;
    public TechnicalEmployee(String name){
        super(name, 75000.0);
        checkIn = 0;
    }

    public void setCheckIn(){
        checkIn++;
    }

    public String employeeStatus() {
        return (this.ID + " " + this.name) + "has " + this.checkIn + "successful check ins\n";
    }
}
