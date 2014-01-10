package oc.wh30k.units.sh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SHRiteofWarTheBlackReaving extends Eintrag {

	//OptionsUpgradeGruppe o1;

	public SHRiteofWarTheBlackReaving() {
		name = "Rite of War The Black Reaving";
		überschriftSetzen = true;
		this.setEintragsCNT(0);
		
		BuildaHQ.setInformationVectorValue("SHRoW", 5);

		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Angel's wrath");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Armoured spearhead");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Orbital assault");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Pride of the Legion");
		//BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War The Black Reaving");
		
		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Reaver Attack Squad");
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Reaver Attack Squad");

		
		complete();
	}

	
	@Override
	public void refreshen() {		
						
		int possibleSquads = BuildaHQ.getCountFromInformationVector("SHPraetor");
		if(BuildaHQ.getCountFromInformationVector("SHPraetor") < 1 || BuildaHQ.getCountFromInformationVector("SHSignal") < 1 ) {
			setFehlermeldung("Requirements not met!");
		} else {
			setFehlermeldung("");
		}
						
		setUnikat(true);				
	}
	
	@Override
	public void deleteYourself() {
		
		BuildaHQ.setInformationVectorValue("SHRoW", 0);
		
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Angel's wrath");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Armoured spearhead");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Orbital assault");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Pride of the Legion");
		//BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War The Black Reaving");
		
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Reaver Attack Squad");
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Reaver Attack Squad");
		super.deleteYourself();
	}

}
