package com.abclearning;

import java.util.ArrayList;

public class BusinessLead extends  BusinessEmployee{
    ArrayList<Accountant> directReport;
    public BusinessLead(String name){
        super(name);
        baseSalary = getBaseSalary() * 2; // The BusinessLead's base salary should be twice that of an Accountant.
        headCount = 10; //Should start with a head count of 10
        this.directReport = new ArrayList<Accountant>();
    }
    // Should return true if the number of direct reports this manager has is less than their headcount.
    public boolean hasHeadCount(){
        return this.directReport.size() < this.headCount;
    }

    public boolean addReport (Accountant e, TechnicalLead supportTeam){
        /*
         * Should accept the reference to an Accountant object, and if
         * the BusinessLead has head count left should add this
         * employee to their list of direct reports.
         */
        if(hasHeadCount()){ // if employee less than 10
            this.directReport.add(e); // add new employee
            this.bonusBudget += (1.1 * e.getBaseSalary()); // Increase 1.1 times of employee's base salary
            e.supportTeam(supportTeam); //support Technical Lead
            supportTeam.accountantSupport = e; // Set this accountant to this technicalLead as a support
            e.setManager(this);
            return true;
        }
        return false;
    }

    // Should check if the bonus amount requested would fit in current BusinessLead's budget.
    public boolean requestBonus (Employee e, double bonus){
        if(this.bonusBudget >= bonus){
            this.bonusBudget += bonus; //Give business bonus to business lead
            e.bonus += bonus; // Give bonus if have budget to employee
            this.bonusBudget -= bonus; // Deduct budget once bonus is given
            return true;
        }
        return false;
    }
    // This function should look through the Accountants the BusinessLead manages
    public boolean approveBonus(Employee e, double bonus){
        for (int i = 0; i < this.directReport.size(); i++){
            // if any of them are supporting a the TechnicalLead that is the manager of the Employee passed
            // in then the Accountant's budget should be consulted to see if
            // the bonus could be afforded.
            if(this.directReport.get(i).getTeamSupported().equals(e.getManager()) &&
                    this.directReport.get(i).approveBonus(bonus)){
                e.bonus += bonus; // If the team can afford the bonus, it should be rewarded.
                this.directReport.get(i).bonusBudget -= bonus;
                return true;
            }
        }
        return false;
    }

    public String getTeamStatus(){
        String status = employeeStatus();
        if (this.directReport.size() == 0){
            status += " and no direct reports yet\n";
        }else{
            status += " and is managing: \n";
            for(int i = 0; i < this.directReport.size(); i++){
                status += "\t" + " " + this.directReport.get(i).employeeStatus() + "\n";
            }
        }
        return status;
    }

}
