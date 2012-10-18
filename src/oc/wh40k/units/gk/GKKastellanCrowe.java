package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;

public class GKKastellanCrowe extends Eintrag {

	public GKKastellanCrowe() {
		name = "Kastellan Crowe";
		grundkosten = 150;

		add(ico = new oc.Picture("oc/wh40k/images/GKKastellanCrowe.jpg"));

		seperator();

		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Purificator-Trupp");
		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Purificator-Trupp");

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Purificator-Trupp");
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Purificator-Trupp");
		super.deleteYourself();
	}

}
