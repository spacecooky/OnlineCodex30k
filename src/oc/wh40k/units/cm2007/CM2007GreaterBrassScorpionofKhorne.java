package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;

public class CM2007GreaterBrassScorpionofKhorne extends Eintrag {

	public CM2007GreaterBrassScorpionofKhorne() {
		name = "Greater Brass Scorpion of Khorne";
		grundkosten = 550;

		add(ico = new oc.Picture("oc/wh40k/images/CMGreaterBrassScorpionofKhorne.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
