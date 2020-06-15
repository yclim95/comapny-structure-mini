package com.abclearning;

public class SoftwareEngineer extends TechnicalEmployee {
    private boolean codeAccess;

    public SoftwareEngineer(String name) {
        super(name); // Should start without access to code and with 0 code check ins
        setCodeAccess(true);
    }

    //Should return whether or not this SoftwareEngineer has access to make changes to the code base
    public boolean getCodeAccess() {
        return codeAccess;
    }

    // Should update Software Engineer's code privileges to either true / false
    public void setCodeAccess(boolean codeAccess) {
        this.codeAccess = codeAccess;
    }

    // Should return the current count of how many times this SoftwareEngineer has successfully checked in code
    public int getSuccessfulCheckIns() {
        return checkIn;
    }

    // Should check if this SoftwareEngineer's manager approves of their check in.
    public boolean checkInCode() {
        TechnicalLead techLead = (TechnicalLead) this.getManager();
        // If the check in is approved their successful
        if (techLead.approveCheckIn(this)) {
            this.checkIn++; //checkin count should be increased
            return true; // the method should return "true".
        }
        // If the manager does not approve the check in the SoftwareEngineer's code
        else{
            codeAccess = false; //access should be changed to false
            return false; // the method should return "false"
        }
    }

    public String employeeStatus() {
        return null;
    }
}
