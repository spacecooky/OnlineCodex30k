package oc.wh40k.units.cd;

import oc.BuildaHQ;
import oc.Eintrag;

public class CDKugathderSeuchenvater extends Eintrag {

	public CDKugathderSeuchenvater() {

		name = "Ku'gath, der Seuchenvater";

		grundkosten = 300;







		add(ico = new oc.Picture("oc/wh40k/images/CDKugathderSeuchenvater.gif"));

		seperator();









		complete();

	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
}
