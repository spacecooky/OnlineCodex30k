package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;

public class SMDamoclesRhino extends Eintrag {

	public SMDamoclesRhino() {
		name = "Damocles Rhino";
		grundkosten = 60;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/SMDamoclesRhino.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
