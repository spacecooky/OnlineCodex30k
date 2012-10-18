package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class TYSymbiarch extends RuestkammerVater {

	public TYSymbiarch() {
		grundkosten = 46;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/TYSymbiarch.jpg"));
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sensenklauen", 2));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Injektor", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Säureblut", 15));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
