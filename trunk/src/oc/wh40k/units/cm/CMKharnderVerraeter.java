package oc.wh40k.units.cm;

import oc.BuildaHQ;
import oc.Eintrag;

public class CMKharnderVerraeter extends Eintrag {

	public CMKharnderVerraeter() {
		name = "Kharn der Verräter";
		grundkosten = 160;

		add(ico = new oc.Picture("oc/wh40k/images/KharntheBetrayer.gif"));
		
		BuildaHQ.addToInformationVector("CMKhorneTroops", 1);
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Khorne-Berserker");
		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Khorne-Berserker");

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	
	@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("CMKhorneTroops", -1);
		if(BuildaHQ.getCountFromInformationVector("CMKhorneTroops")<1){
			BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Khorne-Berserker");
			BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Khorne-Berserker");
		}
		super.deleteYourself();
	}
}
