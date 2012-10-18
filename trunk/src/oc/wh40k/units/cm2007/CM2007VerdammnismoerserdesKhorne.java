package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;

public class CM2007VerdammnismoerserdesKhorne extends Eintrag {

	public CM2007VerdammnismoerserdesKhorne() {
		name = "Verdammnismörser des Khorne";
		grundkosten = 350;

		add(ico = new oc.Picture("oc/wh40k/images/CMVerdammnismoerserKhorne.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
