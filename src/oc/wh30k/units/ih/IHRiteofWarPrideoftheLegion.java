package oc.wh30k.units.ih;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IHRiteofWarPrideoftheLegion extends Eintrag {

	//OptionsUpgradeGruppe o1;

	public IHRiteofWarPrideoftheLegion() {
		name = "Rite of War Pride of the Legion";
		überschriftSetzen = true;
		this.setEintragsCNT(0);
		
		BuildaHQ.setInformationVectorValue("IHRoW", 4);

		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Armoured spearhead");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Orbital assault");
		//BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Pride of the Legion");
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War The Head of the Gorgon");
		
		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Legion Veteran Tactical Squad");
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Legion Veteran Tactical Squad");
		
		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Legion Terminator Squad");
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Legion Terminator Squad");

		
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
		
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Angel's wrath");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Armoured spearhead");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Orbital assault");
		//BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Rite of War Pride of the Legion");
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War The Head of the Gorgon");
		
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Legion Veteran Tactical Squad");
		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Legion Veteran Tactical Squad");
		
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Legion Terminator Squad");
		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Legion Terminator Squad");
		super.deleteYourself();
	}

}
