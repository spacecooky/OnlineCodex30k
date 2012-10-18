package oc.wh40k.units.dm;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class DMScrapTrukkKammer extends RuestkammerVater {

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;
	OptionsEinzelUpgrade oe5;
	OptionsEinzelUpgrade oe6;
	OptionsEinzelUpgrade oe7;

	public DMScrapTrukkKammer() {
		grundkosten = 35;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/Pikk-Up.gif"));
		

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rokkit Launcha", 5));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Red Paint Job", 5));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot Riggers", 5));
		add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbomb Chukka", 5));
		add(oe5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boarding Plank", 5));
		add(oe6 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wreckin' Ball", 10));
		add(oe7 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Reinforced Ram", 5));
		
		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
	}

}
