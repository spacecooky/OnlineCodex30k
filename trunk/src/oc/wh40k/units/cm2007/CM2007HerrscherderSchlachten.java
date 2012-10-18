package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;

public class CM2007HerrscherderSchlachten extends Eintrag {

	public CM2007HerrscherderSchlachten() {
		name = "Herrscher der Schlachten";
		grundkosten = 750;

		add(ico = new oc.Picture("oc/wh40k/images/HerrscherderSchlachten.gif"));
		

		complete();

	}

	public void refreshen() {
        setUnikat(true);
	}
}
