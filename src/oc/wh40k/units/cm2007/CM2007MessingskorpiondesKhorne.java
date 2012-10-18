package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;

public class CM2007MessingskorpiondesKhorne extends Eintrag {

	public CM2007MessingskorpiondesKhorne() {
		name = "Messingskorpion des Khorne";
		grundkosten = 400;

		add(ico = new oc.Picture("oc/wh40k/images/MessingskorpiondesKhorne.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
	}

}
