package oc.wh40k.units.cd;

import oc.BuildaHQ;
import oc.Eintrag;

public class CDSchicksalsweberOrakeldesTzeentch extends Eintrag {

	public CDSchicksalsweberOrakeldesTzeentch() {

		name = "Schicksalsweber, Orakel des Tzeentch";

		grundkosten = 333;

		add(ico = new oc.Picture("oc/wh40k/images/CDSchicksalsweberOrakeldesTzeentch.gif"));
		
		complete();

	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
}
