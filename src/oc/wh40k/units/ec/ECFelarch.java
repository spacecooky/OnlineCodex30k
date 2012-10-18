package oc.wh40k.units.ec;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class ECFelarch extends RuestkammerVater {

	public ECFelarch() {
		grundkosten = 10;
	}

	@Override
	public void initButtons(boolean... defaults) {
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power Sword", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fusion Pistol", 10));
        
        if(defaults[0] == true) {
            seperator();
            
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Haywire Grenades", 5));
        }

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
