package oc.whfb.units.we;

import oc.BuildaHQ;
import oc.Eintrag;

public class WEArielQueenoftheForest extends Eintrag {
	
	public WEArielQueenoftheForest() {
		name = "Ariel, Queen of the Forest ";
		grundkosten = 600;
		
		seperator();
		
		add(ico = new oc.Picture("oc/whfb/images/WEOriontheKingintheWoods.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
