package com.abclearning;

public class Accountant extends BusinessEmployee{
    TechnicalLead technicalLead;
    public Accountant(String name){
        super(name);
        // Should start with a bonus budget of 0 and no team they are officially supporting
        bonusBudget = 0;
    }
    // Should return a reference to the TechnicalLead that this Accountant is currently supporting.
    public TechnicalLead getTeamSupported(){
        // Support Technical Lead?
        return this.technicalLead;
    }

    public void supportTeam(TechnicalLead technicalLead){
        // Should allow a reference to a TechnicalLead to be passed and saved.
        this.technicalLead = technicalLead;
        // Once this happens the Accountant's bonus budget should be
        // updated to be the total of each SoftwareEngineer's base salary that
        // reports to that TechnicalLead plus 10%.
        for (int i = 0; i < this.technicalLead.directReport.size(); i++){
            this.bonusBudget += this.technicalLead.directReport.get(i).getBaseSalary() * 1.1;
        }
    }
    // Should take in a suggested bonus amount and check if there is still enough room in the budget.
    public boolean approveBonus(double bonus){
        if (bonus <= getBonusBudget())
            return true;
        else{
            System.out.print(" Rejected because Budget not sufficient. ");
            // If the bonus is greater than the remaining budget, false should be returned,
            return false;
        }
    }
    /*
     * Should return a String representation of this Accountant that
     * includes their ID, name, the size of their currently managed budget
     * and the name of the TechnicalLead they are currently supporting.
     */
    public String employeeStatus(){
        return (super.employeeStatus() + " is supporting " + this.technicalLead);
    }

}
