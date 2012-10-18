package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;

public class CM2007SeuchenfestungdesNurgle extends Eintrag {

	public CM2007SeuchenfestungdesNurgle() {
		name = "Seuchenfestung des Nurgle";
		grundkosten = 700;

		add(ico = new oc.Picture("oc/wh40k/images/SeuchenfestungdesNurgle.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
	}

}
