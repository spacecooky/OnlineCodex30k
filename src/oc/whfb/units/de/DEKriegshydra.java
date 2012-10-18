package oc.whfb.units.de;

import oc.BuildaHQ;
import oc.Eintrag;

public class DEKriegshydra extends Eintrag {

	public DEKriegshydra() {
		name = BuildaHQ.translate("Kriegshydra");
		grundkosten = 175;

		add(ico = new oc.Picture("oc/whfb/images/DEKriegshydra.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}
