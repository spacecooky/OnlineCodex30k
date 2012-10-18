package oc.whfb.units.bt;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class BTTrebuchet extends Eintrag {

	public BTTrebuchet() {
		name = BuildaHQ.translate("Trebuchet");
		grundkosten = 90;

		add(ico = new oc.Picture("oc/whfb/images/DELokhirTeufelsherz.jpg"));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zimmermann"), 10));

		complete();
	}

	@Override
	public void refreshen() { }
}
