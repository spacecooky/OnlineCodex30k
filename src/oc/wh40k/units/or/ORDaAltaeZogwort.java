package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;

public class ORDaAltaeZogwort extends Eintrag {

	public ORDaAltaeZogwort() {

		name = "Da Alt� Zogwort";

		grundkosten = 145;





		add(ico = new oc.Picture("oc/wh40k/images/DaAltaeZogwort.gif"));



		complete();

	}

	//@OVERRIDE
	public void refreshen() {
        setUnikat(true);
	}
}
