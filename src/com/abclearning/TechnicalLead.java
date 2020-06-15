package com.abclearning;

import java.util.ArrayList;

public class TechnicalLead extends  TechnicalEmployee{
    ArrayList<SoftwareEngineer> directReport; // Who is under technical lead

    public TechnicalLead(String name){
        super(name);
        baseSalary = getBaseSalary() * 1.3; // 1.3 Times salary of Technical employee
        headCount = 4; // Number of employee under Technical Lead
        this.directReport = new ArrayList<SoftwareEngineer>();
    }

    // Should return true if the number of direct reports this manager has is less than their headcount.
    public boolean hasHeadCount(){ // has how many employee under Technical Lead
        return (this.headCount >= directReport.size());
    }

    /*
     * Should accept the reference to a SoftwareEngineer object,
     * and if the TechnicalLead has head count left should add this
     * employee to their list of direct reports.
     */
    public boolean addReport (SoftwareEngineer e){
        if (hasHeadCount()){ // Check if the number of employee under technical lead is < 5
            directReport.add(e); // Add new employee under Technical Lead
            e.setManager(this); // Set this technical lead as software engineer's manager
            return true;
        }
        return  false; // Return false if there no one to add
    }

    public boolean approveCheckIn(SoftwareEngineer e){
        // Should see if the employee passed in does report to this Technical Lead (manager)
        // and if their code access is currently set to "true".
        if(e.getManager().equals(this) && e.getCodeAccess()){
            return true;
        }

        return false; // Employee no permission to checkin
    }

    /*
     * Should check if the bonus amount requested would be approved by the BusinessLead supporting this
     * TechnicalLead.
     */
    public boolean requestBonus(Employee e, double bonus){
        // If business lead does not approve, return false
        BusinessLead businessLead = (BusinessLead) this.getAccountantSupport().getManager();
        if (businessLead.approveBonus(e,bonus)){
            return true;
        }
        return false;
    }

    // Should return a String that gives insight into this Manager and all their direct reports.
    public String getTeamStatus(){
       boolean end = false;
       String status = this.ID + " " + this.name + " has " + this.checkIn + "successful check-ins and ";

        if (this.directReport.size() == 0){ // No employee under this technical lead
            status += "and no direct reports yet\n";
            end = true; // set to print employee's detail
        }else{ // If have employee under this technical lead
            status += "and is managing: \n";

        }

        // employee detail
        if (!end){
            for(int i = 0; i < this.directReport.size(); i++){
                status += "\t" + this.directReport.get(i).ID + " " + this.directReport.get(i).name +
                " has " + this.directReport.get(i).checkIn + " successful check ins\n";;
            }
        }
        return status; // return string for printing to console
    }

}
