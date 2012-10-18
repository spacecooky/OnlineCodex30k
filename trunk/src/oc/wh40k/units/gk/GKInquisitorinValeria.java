package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;

public class GKInquisitorinValeria extends Eintrag {

	public GKInquisitorinValeria() {
		name = "Inquisitorin Valeria";
		grundkosten = 140;

        BuildaHQ.addToInformationVector("GKInquisitor", 1);

		add(ico = new oc.Picture("oc/wh40k/images/GKInquisitorinValeria.jpg"));

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
