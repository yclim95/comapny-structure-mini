package com.abclearning;

public class SoftwareEngineer extends  TechnicalEmployee{
    private boolean codeAccess;
    TechnicalLead technicalLead;
    public SoftwareEngineer(String name){
        super(name);
    }

    public boolean getCodeAccess(){
        return codeAccess;
    }

    public void setCodeAccess(boolean codeAccess){
        this.codeAccess = codeAccess;
    }

    public int getSuccessfulCheckIns(){
        return checkIn;
    }

    public boolean checkInCode(){
        if (this.technicalLead.approveCheckIn(this)){
            checkIn++;
            return true;
        }
        return false;
    }
    public Employee getManager() {
        return this.technicalLead;
    }

    public String employeeStatus() {
        return null;
    }
}
