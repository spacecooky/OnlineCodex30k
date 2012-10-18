package oc.wh40k.units.cm;

import oc.BuildaHQ;
import oc.Eintrag;

public class CMLuciusderEwige extends Eintrag {

	public CMLuciusderEwige() {
		name = "Lucius der Ewige";
		grundkosten = 165;

		add(ico = new oc.Picture("oc/wh40k/images/LuciustheEternal.gif"));
		
		BuildaHQ.addToInformationVector("CMSlaanesTroops", 1);
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Noisemarines");
		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Noisemarines");
		
		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("CMSlaanesTroops", -1);
		if(BuildaHQ.getCountFromInformationVector("CMSlaanesTroops")<1){
			BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Noisemarines");
			BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Noisemarines");
		}
		super.deleteYourself();
	}
}
