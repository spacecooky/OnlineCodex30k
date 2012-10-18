package oc.whfb.units.bt;

import oc.BuildaHQ;
import oc.Eintrag;

public class BTAmalricvonGaudaron extends Eintrag {

	public BTAmalricvonGaudaron() {
		name = "Amalric von Gaudaron";
		grundkosten = 160;

		add(ico = new oc.Picture("oc/whfb/images/DELokhirTeufelsherz.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
		if(BuildaHQ.getCountFromInformationVector("BT_LOUEN") == 0){
			BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Bogenschützen");
			BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Landsknechte");
			BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bogenschützen");
			BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Landsknechte");
			
			BuildaHQ.refreshEntries(3);
			BuildaHQ.refreshEntries(4);
		}
	}

}
