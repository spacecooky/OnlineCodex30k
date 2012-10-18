package oc.wh40k.units.ta;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;

public class TABarrakudaLuftueberlegenheitsjaeger extends Eintrag {

	public TABarrakudaLuftueberlegenheitsjaeger() {
		name = "Barrakuda-Luftüberlegenheitsjäger";
		grundkosten = 220;


		add(ico = new oc.Picture("oc/wh40k/images/Kampfbomba.gif"));
		

        add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Lenkraketen", 4, 10));

		complete();

	}

	public void refreshen() {
	}
}
