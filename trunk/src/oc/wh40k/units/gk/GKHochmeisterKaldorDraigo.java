package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;

public class GKHochmeisterKaldorDraigo extends Eintrag {

	public GKHochmeisterKaldorDraigo() {
		name = "Hochmeister Kaldor Draigo";
		grundkosten = 275;

		add(ico = new oc.Picture("oc/wh40k/images/GKHochmeisterKaldorDraigo.jpg"));

		seperator();

		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Paladin-Trupp");
		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Paladin-Trupp");

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Paladin-Trupp");
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Paladin-Trupp");
		super.deleteYourself();
	}

}
