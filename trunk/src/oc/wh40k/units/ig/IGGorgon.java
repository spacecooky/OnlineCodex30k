package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IGGorgon extends Eintrag {

	public IGGorgon() {
		name = "Gorgon";
		grundkosten = 430;


		add(ico = new oc.Picture("oc/wh40k/images/Gorgon.gif"));
		

                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "hunter-killer missile", 10));
                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "camo-netting", 20));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "improved comms", 0));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "searchlight", 0));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "smoke launchers", 0));
                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "extra armor", 15));

		complete();

	}

	public void refreshen() {
	}
}
