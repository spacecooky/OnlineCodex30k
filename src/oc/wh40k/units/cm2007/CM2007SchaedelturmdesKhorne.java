package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;

public class CM2007SchaedelturmdesKhorne extends Eintrag {

	public CM2007SchaedelturmdesKhorne() {
		name = "Sch�delturm des Khorne";
		grundkosten = 700;

		add(ico = new oc.Picture("oc/wh40k/images/SchaedelturmdesKhorne.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
	}

}
