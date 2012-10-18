package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;

public class DAEzekiel extends Eintrag {

	public DAEzekiel() {
		name = "Ezekiel";
		grundkosten = 170;

		add(ico = new oc.Picture("oc/wh40k/images/DAEzekiel.gif"));
		
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
}
