package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;

public class GKInquisitorKaramasov extends Eintrag {

	public GKInquisitorKaramasov() {
		name = "Inquisitor Karamasov";
		grundkosten = 200;

        BuildaHQ.addToInformationVector("GKInquisitor", 1);

		add(ico = new oc.Picture("oc/wh40k/images/GKInquisitorKaramasov.jpg"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

	@Override
	public void deleteYourself() {
        BuildaHQ.addToInformationVector("GKInquisitor", -1);
		super.deleteYourself();
	}

}
