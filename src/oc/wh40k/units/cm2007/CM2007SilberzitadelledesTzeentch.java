package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;

public class CM2007SilberzitadelledesTzeentch extends Eintrag {

	public CM2007SilberzitadelledesTzeentch() {
		name = "Silberzitadelle des Tzeentch";
		grundkosten = 400;

		add(ico = new oc.Picture("oc/wh40k/images/CMSilberzitadelledesTzeentch.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
