package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.Eintrag;

public class TYEinauge extends Eintrag {

	public TYEinauge() {
		name = "Einauge";
		grundkosten = 260;

		add(ico = new oc.Picture("oc/wh40k/images/TYEinauge.jpg"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
