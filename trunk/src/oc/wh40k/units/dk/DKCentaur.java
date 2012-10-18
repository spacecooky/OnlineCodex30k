package oc.wh40k.units.dk;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class DKCentaur extends RuestkammerVater {

    boolean grenadiers;
    OptionsEinzelUpgrade oe;

	public DKCentaur() {
		grundkosten = 40;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGChimera.jpg"));
		

        try {
            grenadiers = defaults[0];
        } catch(Exception e) {}

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Searchlight", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Smoke launchers", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozerblade", 10));
		add(oe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo netting", 20));

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
        if(grenadiers) oe.setSelected(true);
	}

}
