package com.abclearning;

import java.util.ArrayList;

public class BusinessLead extends  BusinessEmployee{
    int headCount = 0;
    ArrayList<Accountant> directReport = new ArrayList<>();
    Accountant accountant;
    TechnicalLead technicalLead;
    public BusinessLead(String name){
        super(name);
        baseSalary = getBaseSalary() * 2.0;
        this.headCount = 10; //Should start with a head count of 10
    }

    public boolean hasHeadCount(){
        return this.directReport.size() < this.headCount;
    }

    public boolean addReport (Accountant e, TechnicalLead supportTeam){
        if(hasHeadCount()){ // if employee less than 10
            this.directReport.add(e); // add new employee
            e.businessLead = this; // Set accountant's business lead
            budget += (1.1 * e.getBaseSalary()); // set budget
            e.supportTeam(supportTeam); //support Technical Lead
            return true;
        }
        return false;
    }

    public boolean requestBonus (Employee e, double bonus){
        if(budget >= bonus){
            e.bonus += bonus; // Give bonus if have budget
            budget -= bonus; // Deduct budget once bonus is given
            return true;
        }
        return false;
    }

    public boolean approveBonus(Employee e, double bonus){
        for (int i = 0; i < this.directReport.size(); i++){
            if(this.directReport.get(i).equals(e.getManager()) && this.directReport.get(i).approveBonus(bonus))
                return true;
        }
        return false;
    }

    public String getTeamStatus(){
        String status = employeeStatus();
        if (this.directReport.size() == 0){
            status += "and no direct reports yet\n";
        }else{
            status += "and is managing: \n";
            for(int i = 0; i < this.directReport.size(); i++){
                int j = i + 1;
                status += "\t" + j + ". " + this.directReport.get(i).employeeStatus();
            }
        }
        return status;
    }
    public Employee getManager() {
        return null;
    }
}
