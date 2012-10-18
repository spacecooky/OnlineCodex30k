package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ELNightSpinner extends Eintrag {

	public ELNightSpinner() {
		name = "Night Spinner";
		grundkosten = 135;

		add(ico = new oc.Picture("oc/wh40k/images/NightSpinner.gif"));
		

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Shuriken cannon", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vectored engines", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Star engines", 15));
     	add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Holo-field", 35));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Spirit stones", 10));

        complete();

	}

    @Override
	public void refreshen() {
	}
    
}
