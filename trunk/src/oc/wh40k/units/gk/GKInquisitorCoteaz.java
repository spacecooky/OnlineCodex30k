package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;

public class GKInquisitorCoteaz extends Eintrag {

	public GKInquisitorCoteaz() {
		name = "Inquisitor Coteaz";
		grundkosten = 100;

        BuildaHQ.addToInformationVector("GKInquisitor", 9999); // Coatez allows unlimited numbers of companion units

		add(ico = new oc.Picture("oc/wh40k/images/GKInquisitorCoteaz.jpg"));

		seperator();

		BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Gefolge des Inquisitors");
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Gefolge des Inquisitors");

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Gefolge des Inquisitors");
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Gefolge des Inquisitors");

        BuildaHQ.addToInformationVector("GKInquisitor", -9999);

		super.deleteYourself();
	}

}
