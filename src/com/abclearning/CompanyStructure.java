package com.abclearning;

public class CompanyStructure {

    public static void main(String[] args) {
        // Object Initialization (Tech Lead)
        TechnicalLead CTO = new TechnicalLead("Gishella");
        SoftwareEngineer seA = new SoftwareEngineer("Anastasya");
        SoftwareEngineer seB = new SoftwareEngineer("Gempi");
        SoftwareEngineer seC = new SoftwareEngineer("Marteen");

        // Add ReportLine (Tech)
        CTO.addReport(seA);
        CTO.addReport(seB);
        CTO.addReport(seC);
        System.out.println(CTO.getTeamStatus());
        

        // Object Creation
        TechnicalLead VPofENG = new TechnicalLead("Sabyan");
        SoftwareEngineer seD = new SoftwareEngineer("Berwyn");
        SoftwareEngineer seE = new SoftwareEngineer("Poppy");
        SoftwareEngineer seF = new SoftwareEngineer("I Wayan");
        SoftwareEngineer seG = new SoftwareEngineer("Nadine");

        //Add Report Line
        VPofENG.addReport(seD);
        VPofENG.addReport(seE);
        VPofENG.addReport(seF);
        VPofENG.addReport(seG);
        System.out.println(VPofENG.getTeamStatus());

        //Object Creation
        BusinessLead CFO = new BusinessLead("Christiant");
        Accountant actA = new Accountant("Laurensky");
        Accountant actB = new Accountant("Jessica");

        //Add Report Line
        CFO.addReport(actA, CTO);
        CFO.addReport(actB, VPofENG);
        System.out.println(CFO.getTeamStatus());
    }
}
