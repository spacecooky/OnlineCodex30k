package oc.wh40k.units.ne;

import oc.BuildaHQ;
import oc.Eintrag;

public class NETodessichel extends Eintrag {
    
	public NETodessichel() {
		name = "Todessichel";
		grundkosten = 175;

		add(ico = new oc.Picture("oc/wh40k/images/NETodessichel.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
