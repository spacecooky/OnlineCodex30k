package oc.wh40k.units.bt;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class BTLandRaiderCrusaderKammer extends RuestkammerVater {

	public BTLandRaiderCrusaderKammer() {
		grundkosten = 265;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/BTLandRaiderCrusaderGross.jpg"));
		

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Gesalbter Rumpf", 25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Nebelwerfer", 3));

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
	}

}











