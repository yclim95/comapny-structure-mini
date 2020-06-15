package com.abclearning;

import java.util.ArrayList;

public class TechnicalLead extends  TechnicalEmployee{
    int headCount = 0;
    ArrayList<SoftwareEngineer> directReport = new ArrayList<>(); // Who is under technical lead
    Accountant accountant;
    BusinessLead businessLead;

    public TechnicalLead(String name){
        super(name);
        baseSalary = getBaseSalary() * 1.3; // 1.3 Times salary of Technical employee
        this.headCount = 4; // Number of employee under Technical Lead
    }

    public boolean hasHeadCount(){ // has how many employee under Technical Lead
        return (this.headCount >= directReport.size());
    }

    public boolean addReport (SoftwareEngineer e){
        if (directReport.size() < headCount){ // Check if the number of employee under technical lead is < 5
            directReport.add(e); // Add new employee under Technical Lead
            e.technicalLead = this; // Software Engineer's tech lead refer to this
            return true;
        }
        return  false; // Return false if there no one to add
    }

    public boolean approveCheckIn(SoftwareEngineer e){
        // If employee under Technical Lead, then have permission to checkin CODE
        if(this.directReport.contains(e) && e.getCodeAccess() == true){
            return true;
        }

        return false; // Employee no permission to checkin
    }

    public boolean requestBonus(Employee e, double bonus){
        // If business lead does not approve, return false
        if (this.accountant.businessLead.approveBonus(e,bonus)){
            e.bonus += bonus; //set and increase bonus
            return  true;
        }
        return false;
    }

    public String getTeamStatus(){
       boolean end = false;
       String status = this.ID + " " + this.name + " has " + this.checkIn + "successful check-ins and ";

        if (this.directReport.size() == 0){
            status += "and no direct reports yet\n";
            end = true;
        }else{
            status += "and is managing: \n";

        }

        if (!end){
            for(int i = 0; i < this.directReport.size(); i++){
                int j = i + 1;
                status += "\t" + this.directReport.get(i).ID + " " + this.directReport.get(i).name +
                " has " + this.directReport.get(i).checkIn + " check-ins\n";
            }
        }
        return status;
    }

    public Employee getManager() {
        return null;
    }
}
