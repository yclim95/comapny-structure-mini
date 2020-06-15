package com.abclearning;

abstract public class TechnicalEmployee extends Employee {
    public int checkIn;

    public TechnicalEmployee(String name) {
        super(name, 75000.0); //Has a default base salary of 75000
        checkIn = 0;
    }
    /*
     * Should return a String representation of this TechnicalEmployee
     * Example: "1 Kasey has 10 successful check ins"
     */
    public String employeeStatus() {
        return (this.ID + " " + this.name) + "has " + this.checkIn + "successful check ins\n";
    }
}
