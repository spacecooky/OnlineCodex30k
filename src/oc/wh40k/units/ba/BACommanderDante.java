package oc.wh40k.units.ba;

import oc.BuildaHQ;
import oc.Eintrag;

public class BACommanderDante extends Eintrag {

	public BACommanderDante() {
		name = "Commander Dante";
		grundkosten = 225;

		BuildaHQ.addToInformationVector("BAHQ", 1);

		add(ico = new oc.Picture("oc/wh40k/images/BACommanderDante.jpg"));

		seperator();

		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Sanguinische Garde");
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Sanguinische Garde");

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("BAHQ", -1);
		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Sanguinische Garde");
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Sanguinische Garde");
		super.deleteYourself();
	}

}
