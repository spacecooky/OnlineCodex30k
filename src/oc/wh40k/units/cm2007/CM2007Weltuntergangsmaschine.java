package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;

public class CM2007Weltuntergangsmaschine extends Eintrag {

	public CM2007Weltuntergangsmaschine() {
		name = "Weltuntergangsmaschine";
		grundkosten = 400;

		add(ico = new oc.Picture("oc/wh40k/images/CMWeltuntergangsmaschine.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
