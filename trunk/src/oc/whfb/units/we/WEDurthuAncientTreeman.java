package oc.whfb.units.we;

import oc.BuildaHQ;
import oc.Eintrag;

public class WEDurthuAncientTreeman extends Eintrag {
	
	public WEDurthuAncientTreeman() {
		name = "Durthu - Ancient Treeman";
		grundkosten = 450;
		
		seperator();
		
		add(ico = new oc.Picture("oc/whfb/images/WEOriontheKingintheWoods.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
