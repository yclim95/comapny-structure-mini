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

        // Check In (Tech)
        seA.checkInCode(); // seA checkin ++ (1)
        seA.checkInCode(); // seA checkin ++ (2)
        seC.checkInCode(); // seC checkin ++ (1)
        seC.checkInCode(); // seC checkin ++ (2)


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

        // Check In (Tech)
        seD.checkInCode(); // seD checkin ++ (1)
        seF.checkInCode(); // seF checkin ++ (1)
        seF.checkInCode(); // seF checkin ++ (2)
        seF.checkInCode(); // seF checkin ++ (3)
        seF.checkInCode(); // seF checkin ++ (4)

        System.out.println(VPofENG.getTeamStatus());


        //Object Creation
        BusinessLead CFO = new BusinessLead("Christiant");
        Accountant actA = new Accountant("Laurensky");
        Accountant actB = new Accountant("Jessica");

        //Add Report Line
        CFO.addReport(actA, CTO);
        CFO.addReport(actB, VPofENG);
        System.out.println(CFO.getTeamStatus());


        //Employee's Manager
        System.out.println(seB.toString() + "'s manager is " + seB.getManager().toString()); // SEB's Manager
        System.out.println(seF.toString() + "'s manager is " + seF.getManager().toString()); // SEF's Manager
        System.out.println(actB.toString() + "'s manager is " + actB.getManager().toString()); // ActB's Manager
        System.out.println();

        //Approve Bonus
        System.out.println("Testing Business Lead approvedBonus()");
        System.out.println(seA.getManager() + " is asking for $10, 000 bonus for " + seA.getName() + ", " +
                "(the Approval result should be TRUE): ");
        System.out.println(CTO.requestBonus(seA, 10000));
        System.out.println("Updated budget is: " + seA.getManager().getAccountantSupport().getBonusBudget() + "\n");

        System.out.println(seF.getManager() + " is asking for $5, 000 bonus for " + seF.getName() + ", " +
                "(the Approval result should be TRUE): ");
        System.out.println(VPofENG.requestBonus(seF, 5000));
        System.out.println("Updated budget is: " + seF.getManager().getAccountantSupport().getBonusBudget() + "\n");

        System.out.println(seF.getManager() + " is asking for $400, 000 bonus for " + seF.getName() + ", " +
                "(the Approval result should be FALSE): ");
        System.out.println(VPofENG.requestBonus(seF, 400000));
        System.out.println("Updated budget is: " + seF.getManager().getAccountantSupport().getBonusBudget() + "\n");
    }
}
