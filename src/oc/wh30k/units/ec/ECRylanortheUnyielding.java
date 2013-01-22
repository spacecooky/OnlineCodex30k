package oc.wh30k.units.ec;

import oc.BuildaHQ;
import oc.Eintrag;

public class ECRylanortheUnyielding extends Eintrag {

	public ECRylanortheUnyielding() {
		name = "Rylanor the Unyielding";
		grundkosten = 255;

		add(ico = new oc.Picture("oc/wh40k/images/xy.jpg"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
