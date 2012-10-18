package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;

public class SMScriptorMagisterTigurius extends Eintrag {

	public SMScriptorMagisterTigurius() {
		name = "Scriptor-Magister Tigurius";
		grundkosten = 230;

		add(ico = new oc.Picture("oc/wh40k/images/SMScriptorMagisterTigurius.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
}
