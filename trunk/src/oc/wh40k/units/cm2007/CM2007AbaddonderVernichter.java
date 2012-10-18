package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;

public class CM2007AbaddonderVernichter extends Eintrag {


	public CM2007AbaddonderVernichter() {
		name = "Abaddon der Vernichter";
		grundkosten = 275;

		add(ico = new oc.Picture("oc/wh40k/images/AbbaddontheDespoiler.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
