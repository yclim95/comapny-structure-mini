package com.abclearning;

public class Accountant extends BusinessEmployee{
    TechnicalLead technicalLead;
    public Accountant(String name){
        super(name);
        bonusBudget = 0;
    }

    public TechnicalLead getTeamSupported(){
        // Support Technical Lead?
        return this.technicalLead;
    }

    public void supportTeam(TechnicalLead technicalLead){
        // Should allow a reference to Technical Lead
        this.technicalLead = technicalLead;
        for (int i = 0; i < this.technicalLead.directReport.size(); i++){
            this.bonusBudget += this.technicalLead.directReport.get(i).getBaseSalary() * 1.1;
        }
    }

    public boolean approveBonus(double bonus){
        if (bonus <= getBonusBudget())
            return true;
        else{
            System.out.println(" Rejected because Budget not sufficient. ");
            return false;
        }
    }

    public String employeeStatus(){
        return (super.employeeStatus() + " is supporting " + this.technicalLead);
    }

}
