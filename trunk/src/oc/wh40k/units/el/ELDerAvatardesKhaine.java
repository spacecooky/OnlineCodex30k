package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;

public class ELDerAvatardesKhaine extends Eintrag {

	public ELDerAvatardesKhaine() {
		name = "Der Avatar des Khaine";
		grundkosten = 155;

		add(ico = new oc.Picture("oc/wh40k/images/ELDerAvatardesKhaine.gif"));
		

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
        setUnikat(true);
	}
}
