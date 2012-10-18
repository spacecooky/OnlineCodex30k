package oc.wh40k.units.ta;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class TAOShovahLeibwache extends Eintrag {

	RuestkammerStarter[] krisis = new RuestkammerStarter[7];
	int Select = 0;

	public TAOShovahLeibwache() {

		name = "O'Shovahs Leibwache";

		grundkosten = 0;

		überschriftSetzen = true;

		this.setEintragsCNT(0);





		add(ico = new oc.Picture("oc/wh40k/images/KrisisLeibwache.gif"));  // DASSELBE BILD WIE DIE NORMALE 1-2 LEIbWACHE!!





		for (int i = 0; i < krisis.length; ++i) {

			krisis[i] = new RuestkammerStarter(ID, randAbstand, cnt, "TAKampfanzugKammer", "Krisis Shas'vre");

			krisis[i].setGrundkosten(35);

			krisis[i].initKammer(true, true, false);

			add(krisis[i]);

			krisis[i].setSeperator(0);

		}

		complete();

	}

	//@OVERRIDE
	public void refreshen() {
		Select = 0;
		for(int k = 0; k < krisis.length; ++k) {
		Select += (krisis[k].isSelected() ? 1 : 0);
		}

		for(int j = 0; j < krisis.length; ++j) {
		krisis[j].setLegal(Select > 0);
		}
	}
}
