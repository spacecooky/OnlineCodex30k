package oc.wh30k.units.we;

import oc.BuildaHQ;
import oc.Eintrag;

public class WEThePrimarchAngron extends Eintrag {

	public WEThePrimarchAngron() {
		name = "The Primarch Angron";
		grundkosten = 400;

		add(ico = new oc.Picture("oc/wh40k/images/xy.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
	@Override
	public void deleteYourself() {
		
		
	}

}
