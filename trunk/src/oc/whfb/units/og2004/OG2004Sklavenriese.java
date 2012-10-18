package oc.whfb.units.og2004;

import oc.BuildaHQ;
import oc.Eintrag;

public class OG2004Sklavenriese extends Eintrag {

	public OG2004Sklavenriese() {
		name = BuildaHQ.translate("Sklavenriese");
		grundkosten = 175;

		BuildaHQ.addToInformationVector("OGSklavenriese", 1);

		add(ico = new oc.Picture("oc/whfb/images/OGSklavenriese.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}
