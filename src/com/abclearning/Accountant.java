package com.abclearning;

public class Accountant extends BusinessEmployee{
    BusinessLead businessLead;
    TechnicalLead technicalLead;
    public Accountant(String name){
        super(name);
    }

    public TechnicalLead getTeamSupported(){
        // Support Technical Lead?
        return this.technicalLead;
    }

    public void supportTeam(TechnicalLead technicalLead){
        // Should allow a reference to Technical Lead
        this.technicalLead = technicalLead;
        this.technicalLead.accountant = this;
        double total = 0;

        for (int i = 0; i < this.technicalLead.directReport.size(); i++){
            total += this.technicalLead.directReport.get(i).getBaseSalary();
        }
        budget = total * 1.1;
    }

    public boolean approveBonus(double bonus){
        if (bonus > budget || this.technicalLead == null)
            return false;
        return true;
    }

    public String employeeStatus(){
        return (super.employeeStatus() + " is supporting " + this.technicalLead + "\n");
    }
    public Employee getManager() {
        return this.businessLead; // Business Lead is the manager of Accountant
    }
}
