package com.abclearning;

import java.util.ArrayList;

public class BusinessLead extends  BusinessEmployee{
    int headCount;
    ArrayList<Accountant> directReport;
    public BusinessLead(String name){
        super(name);
        baseSalary = getBaseSalary() * 2;
        this.headCount = 10; //Should start with a head count of 10
        this.directReport = new ArrayList<Accountant>();
    }

    public boolean hasHeadCount(){
        return this.directReport.size() < this.headCount;
    }

    public boolean addReport (Accountant e, TechnicalLead supportTeam){
        if(hasHeadCount()){ // if employee less than 10
            this.directReport.add(e); // add new employee
            this.bonusBudget += (1.1 * e.getBaseSalary()); // set budget
            e.supportTeam(supportTeam); //support Technical Lead
            supportTeam.accountantSupport = e; // Set this accountant to this technicalLead as a support
            e.setManager(this);
            return true;
        }
        return false;
    }

    public boolean requestBonus (Employee e, double bonus){
        if(this.bonusBudget >= bonus){
            this.bonusBudget += bonus; //Give business bonus to businesslead
            e.bonus += bonus; // Give bonus if have budget to employee
            this.bonusBudget -= bonus; // Deduct budget once bonus is given
            return true;
        }
        return false;
    }

    public boolean approveBonus(Employee e, double bonus){
        for (int i = 0; i < this.directReport.size(); i++){
            if(this.directReport.get(i).getTeamSupported().equals(e.getManager()) &&
                    this.directReport.get(i).approveBonus(bonus)){
                e.bonus += bonus;
                this.directReport.get(i).bonusBudget -= bonus;
            }
                return true;
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
                int j = i + 1;
                status += "\t" + " " + this.directReport.get(i).employeeStatus() + "\n";
            }
        }
        return status;
    }

}
