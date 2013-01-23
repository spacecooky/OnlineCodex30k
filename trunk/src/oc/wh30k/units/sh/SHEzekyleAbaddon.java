package oc.wh30k.units.sh;

import oc.BuildaHQ;
import oc.Eintrag;

public class SHEzekyleAbaddon extends Eintrag {

	public SHEzekyleAbaddon() {
		name = "Ezekyle Abaddon";
		grundkosten = 215;

		add(ico = new oc.Picture("oc/wh40k/images/xy.jpg"));

		BuildaHQ.addToInformationVector("SHPraetor", 1);
		
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
	@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("SHPraetor", -1);
		super.deleteYourself();
	}
	

}
