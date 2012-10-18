package oc.wh40k.units.cm;

import oc.BuildaHQ;
import oc.Eintrag;

public class CMAhriman extends Eintrag {


	public CMAhriman() {
		name = "Ahriman";
		grundkosten = 230;

		add(ico = new oc.Picture("oc/wh40k/images/Ahriman.gif"));
		
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Thousand Sons");
		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Thousand Sons");

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Thousand Sons");
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Thousand Sons");
		super.deleteYourself();
	}
}
