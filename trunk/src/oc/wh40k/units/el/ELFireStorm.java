package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ELFireStorm extends Eintrag {

	public ELFireStorm() {

		name = "Fire Storm";
		grundkosten = 180;

		add(ico = new oc.Picture("oc/wh40k/images/FireStorm.gif"));
		

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "shuriken cannon", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "vectored engines", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "star engines", 15));
     	add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "holo-field", 35));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "spirit stones", 10));

        complete();

	}

	//@OVERRIDE
	public void refreshen() {
	}
}
