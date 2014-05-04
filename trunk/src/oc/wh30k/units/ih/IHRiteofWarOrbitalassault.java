package oc.wh30k.units.ih;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IHRiteofWarOrbitalassault extends Eintrag {

	//OptionsUpgradeGruppe o1;

	public IHRiteofWarOrbitalassault() {
		name = "Rite of War Orbital assault";
		überschriftSetzen = true;
		this.setEintragsCNT(0);
		
		BuildaHQ.setInformationVectorValue("IHRoW", 3);

		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Armoured spearhead");
		//BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Orbital assault");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Pride of the Legion");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War The Head of the Gorgon");
		
		BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Deathstorm Drop Pod");
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Deathstorm Drop Pod");

		
		complete();
	}

	
	@Override
	public void refreshen() {		
						
		int possibleSquads = BuildaHQ.getCountFromInformationVector("IHPraetor");
		if(1 > possibleSquads) {
			setFehlermeldung("Requirements not met!");
		} else {
			setFehlermeldung("");
		}
						
		setUnikat(true);				
	}
	
	@Override
	public void deleteYourself() {
		
		BuildaHQ.setInformationVectorValue("IHRoW", 0);
		
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Armoured spearhead");
		//BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Orbital assault");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Pride of the Legion");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War The Head of the Gorgon");
		
		BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Deathstorm Drop Pod");
		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Deathstorm Drop Pod");
		super.deleteYourself();
	}

}
