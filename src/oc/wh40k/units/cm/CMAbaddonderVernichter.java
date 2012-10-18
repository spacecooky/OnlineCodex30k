package oc.wh40k.units.cm;

import oc.BuildaHQ;
import oc.Eintrag;

public class CMAbaddonderVernichter extends Eintrag {


	public CMAbaddonderVernichter() {
		name = "Abaddon der Vernichter";
		grundkosten = 265;

		add(ico = new oc.Picture("oc/wh40k/images/AbbaddontheDespoiler.gif"));
		
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Auserkorene");
		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Auserkorene");

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
	@Override
	public void deleteYourself() {
		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Auserkorene");
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Auserkorene");
		super.deleteYourself();
	}

}
