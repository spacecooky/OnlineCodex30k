package oc.wh30k.units.sh;

import oc.BuildaHQ;
import oc.Eintrag;

public class SHGarvielLoken extends Eintrag {

	public SHGarvielLoken() {
		name = "Garviel Loken";
		grundkosten = 175;

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