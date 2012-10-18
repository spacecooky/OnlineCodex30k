package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;

public class CM2007BanelordTitandesKhorne extends Eintrag {

	public CM2007BanelordTitandesKhorne() {
		name = "Banelord-Titan des Khorne";
		grundkosten = 2500;

		add(ico = new oc.Picture("oc/wh40k/images/BanelordTitandesKhorne.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
