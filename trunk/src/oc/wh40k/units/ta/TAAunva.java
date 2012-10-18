package oc.wh40k.units.ta;

import oc.BuildaHQ;
import oc.Eintrag;

public class TAAunva extends Eintrag {

	public TAAunva() {

		name = "Aun'va";

		grundkosten = 205;





		add(ico = new oc.Picture("oc/wh40k/images/Aunva.gif"));



		complete();

	}

	//@OVERRIDE
	public void refreshen() {
        setUnikat(true);
	}
}
