package oc.wh30k.units.ih;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IHRiteofWarArmouredspearhead extends Eintrag {

	//OptionsUpgradeGruppe o1;

	public IHRiteofWarArmouredspearhead() {
		name = "Rite of War Armoured spearhead";
		überschriftSetzen = true;
		this.setEintragsCNT(0);
		
		BuildaHQ.setInformationVectorValue("IHRoW", 2);

		//BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Armoured spearhead");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Orbital assault");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Pride of the Legion");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War The Head of the Gorgon");

		
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
		
		//BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Armoured spearhead");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Orbital assault");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Pride of the Legion");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War The Head of the Gorgon");
		super.deleteYourself();
	}

}
