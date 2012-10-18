package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;

public class SMTyberosTheRedWake extends Eintrag {
    
        boolean honourGuardSelected = false;
        boolean commandSquadSelected = false;

	public SMTyberosTheRedWake() {
		name = "Tyberos the Red Wake";
		grundkosten = 190;

		BuildaHQ.addToInformationVector("SMEnableCommandSquad", 1);
		BuildaHQ.addToInformationVector("SMEnableHonourGuard", 1);
                
		BuildaHQ.addToInformationVector("SMOnlyOneChapterMaster", 1);
		BuildaHQ.addToInformationVector("SMChapterMaster", 1);
                
                BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("The Red Brethren");

		add(ico = new oc.Picture("oc/wh40k/images/SMKorsarroKhan.gif"));
                
		complete();
	}

	@Override
	public void deleteYourself() {
            
		if(!honourGuardSelected) BuildaHQ.addToInformationVector("SMEnableCommandSquad", -1);
		if(!commandSquadSelected) BuildaHQ.addToInformationVector("SMEnableHonourGuard", -1);
                
                BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("The Red Brethren");
		
                BuildaHQ.addToInformationVector("SMChapterMaster", -1);
                BuildaHQ.addToInformationVector("SMOnlyOneChapterMaster", -1);

		super.deleteYourself();
	}

	@Override
	public void refreshen() {
            setUnikat(true);
            
            if(BuildaHQ.getCountFromInformationVector("SMChapterMaster") > 1 && BuildaHQ.getCountFromInformationVector("SMOnlyOneChapterMaster") > 0) {
                setFehlermeldung("nur ein Ordensmeister");
            } else {
                setFehlermeldung("");
            }
            
            //Entweder Kommandotrupp ODER Ehrengarde
            
            int commandSquads = BuildaHQ.getCountFromInformationVector("SMCommandSquad");
            int commandSquadsMax = BuildaHQ.getCountFromInformationVector("SMEnableCommandSquad");
            int honourGuards = BuildaHQ.getCountFromInformationVector("SMHonourGuard");
            int honourGuardsMax = BuildaHQ.getCountFromInformationVector("SMEnableHonourGuard");
            
            if(commandSquadSelected && commandSquads < commandSquadsMax) {
                commandSquadSelected = false;
                BuildaHQ.addToInformationVector("SMEnableHonourGuard", 1);
            }
            
            if(honourGuardSelected && honourGuards < honourGuardsMax) {
                honourGuardSelected = false;
                BuildaHQ.addToInformationVector("SMEnableCommandSquad", 1);
            }
            
            
            if(!honourGuardSelected && !commandSquadSelected) {
                
                if(commandSquadsMax != 0 && commandSquads >= commandSquadsMax) {
                    BuildaHQ.addToInformationVector("SMEnableHonourGuard", -1);
                    commandSquadSelected = true;
                }

                if(honourGuardsMax != 0 && honourGuards >= honourGuardsMax) {
                    BuildaHQ.addToInformationVector("SMEnableCommandSquad", -1);
                    honourGuardSelected = true;
                }
                
            }
            
            
            
        }

}
