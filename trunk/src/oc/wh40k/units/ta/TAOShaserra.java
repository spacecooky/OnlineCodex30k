package oc.wh40k.units.ta;

import oc.BuildaHQ;
import oc.Eintrag;

public class TAOShaserra extends Eintrag {

	public TAOShaserra() {

		name = "O'Shaserra";

		grundkosten = 175;





		add(ico = new oc.Picture("oc/wh40k/images/OShaserra.gif"));



		complete();

	}

	//@OVERRIDE
	public void refreshen() {
        setUnikat(true);
	}
}
