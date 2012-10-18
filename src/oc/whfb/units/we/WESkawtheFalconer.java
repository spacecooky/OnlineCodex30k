package oc.whfb.units.we;

import oc.BuildaHQ;
import oc.Eintrag;

public class WESkawtheFalconer extends Eintrag {
	
	public WESkawtheFalconer() {
		name = "Skaw the Falconer";
		grundkosten = 175;
		
		seperator();
		
		add(ico = new oc.Picture("oc/whfb/images/WEOriontheKingintheWoods.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
