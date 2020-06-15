package com.abclearning;

import java.util.ArrayList;

public class TechnicalLead extends  TechnicalEmployee{
    int headCount;
    ArrayList<SoftwareEngineer> directReport; // Who is under technical lead

    public TechnicalLead(String name){
        super(name);
        baseSalary = getBaseSalary() * 1.3; // 1.3 Times salary of Technical employee
        this.headCount = 4; // Number of employee under Technical Lead
        this.directReport = new ArrayList<SoftwareEngineer>();
    }

    public boolean hasHeadCount(){ // has how many employee under Technical Lead
        return (this.headCount >= directReport.size());
    }

    public boolean addReport (SoftwareEngineer e){
        if (hasHeadCount()){ // Check if the number of employee under technical lead is < 5
            directReport.add(e); // Add new employee under Technical Lead
            e.setManager(this); // Set this technical lead as software engineer's manager
            return true;
        }
        return  false; // Return false if there no one to add
    }

    public boolean approveCheckIn(SoftwareEngineer e){
        // If employee under Technical Lead, then have permission to checkin CODE
        if(e.getManager().equals(this) && e.getCodeAccess()){
            return true;
        }

        return false; // Employee no permission to checkin
    }

    public boolean requestBonus(Employee e, double bonus){
        // If business lead does not approve, return false
        BusinessLead businessLead = (BusinessLead) this.getAccountantSupport().getManager();
        if (businessLead.approveBonus(e,bonus)){
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
                " has " + this.directReport.get(i).checkIn + " successful check ins\n";;
            }
        }
        return status;
    }

}
