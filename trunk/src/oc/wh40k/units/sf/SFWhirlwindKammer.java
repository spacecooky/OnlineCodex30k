package oc.wh40k.units.sf;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class SFWhirlwindKammer extends RuestkammerVater {

	OptionsEinzelUpgrade chronus;

	boolean chronusSelected = false;

	public SFWhirlwindKammer() {
		grundkosten = 85;
        }
        
        public void initButtons(boolean... defaults) {

		add(ico = new oc.Picture("oc/wh40k/images/Whirlwind.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radar-Suchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}
	
}
