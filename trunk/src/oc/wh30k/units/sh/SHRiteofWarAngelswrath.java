package oc.wh30k.units.sh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SHRiteofWarAngelswrath extends Eintrag {

	//OptionsUpgradeGruppe o1;

	public SHRiteofWarAngelswrath() {
		name = "Rite of War Angel's wrath";
		überschriftSetzen = true;
		this.setEintragsCNT(0);
		
		BuildaHQ.setInformationVectorValue("SHRoW", 1);

		//BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Angel's wrath");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Armoured spearhead");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Orbital assault");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Pride of the Legion");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War The Black Reaving");

		
		complete();
	}

	
	@Override
	public void refreshen() {		
		
		int possibleSquads = BuildaHQ.getCountFromInformationVector("SHPraetor");
		if(1 > possibleSquads) {
			setFehlermeldung("Requirements not met!");
		} else {
			setFehlermeldung("");
		}
						
		setUnikat(true);				
	}
	
	@Override
	public void deleteYourself() {
		
		BuildaHQ.setInformationVectorValue("SHRoW", 0);
		
		//BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Angel's wrath");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Armoured spearhead");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Orbital assault");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Pride of the Legion");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War The Black Reaving");
		super.deleteYourself();
	}

}
