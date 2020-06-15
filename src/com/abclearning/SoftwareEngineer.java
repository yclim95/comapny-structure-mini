package com.abclearning;

public class SoftwareEngineer extends TechnicalEmployee {
    private boolean codeAccess;

    public SoftwareEngineer(String name) {
        super(name);
        setCodeAccess(true);
    }

    public boolean getCodeAccess() {
        return codeAccess;
    }

    public void setCodeAccess(boolean codeAccess) {
        this.codeAccess = codeAccess;
    }

    public int getSuccessfulCheckIns() {
        return checkIn;
    }

    public boolean checkInCode() {
        TechnicalLead techLead = (TechnicalLead) this.getManager();
        if (techLead.approveCheckIn(this)) {
            this.checkIn++;
            return true;
        }
        else{
            codeAccess = false;
            return false;
        }
    }

    public String employeeStatus() {
        return null;
    }
}
