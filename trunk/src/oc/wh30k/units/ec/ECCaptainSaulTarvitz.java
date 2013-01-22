package oc.wh30k.units.ec;

import oc.BuildaHQ;
import oc.Eintrag;

public class ECCaptainSaulTarvitz extends Eintrag {

	public ECCaptainSaulTarvitz() {
		name = "Captain Sault Tarvitz";
		grundkosten = 135;

		add(ico = new oc.Picture("oc/wh40k/images/xy.jpg"));

		BuildaHQ.addToInformationVector("ECPraetor", 1);
		
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
	@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("ECPraetor", -1);
		super.deleteYourself();
	}
	

}
