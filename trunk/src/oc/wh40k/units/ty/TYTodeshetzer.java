package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.Eintrag;

public class TYTodeshetzer extends Eintrag {

	public TYTodeshetzer() {
		name = "Todeshetzer";
		grundkosten = 140;

		add(ico = new oc.Picture("oc/wh40k/images/TYTodeshetzer.jpg"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
