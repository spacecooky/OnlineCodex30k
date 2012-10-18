package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;

public class CM2007SubjugatorTitandesSlaanesh extends Eintrag {

	public CM2007SubjugatorTitandesSlaanesh() {
		name = "Subjugator-Titan des Slaanesh";
		grundkosten = 500;

		add(ico = new oc.Picture("oc/wh40k/images/CMSubjugatorTitandesSlaanesh.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
