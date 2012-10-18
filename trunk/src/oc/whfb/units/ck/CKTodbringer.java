package oc.whfb.units.ck;

import oc.BuildaHQ;
import oc.Eintrag;

public class CKTodbringer extends Eintrag {
	
	public CKTodbringer() {
		name = BuildaHQ.translate("Todbringer");
		grundkosten = 205;

		add(ico = new oc.Picture("oc/whfb/images/CKTodbringer.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}
