package oc.wh40k.units.bt;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class BTOrdenspriesterGrimaldusHeldvonAskalon extends Eintrag {

    OptionsEinzelUpgrade oe1;

	public BTOrdenspriesterGrimaldusHeldvonAskalon() {
		name = "Ordenspriester Grimaldus";
		grundkosten = 195;

		BuildaHQ.addToInformationVector("BTHQ", 1);
		BuildaHQ.addToInformationVector("BTKommandant", 1);
		BuildaHQ.addToInformationVector("BTOrdenspriester", 1);

		add(ico = new oc.Picture("oc/wh40k/images/BTOrdenspriesterGrimaldusHeldvonAskalon.jpg"));
        
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "An Komm-Trupp anschlieﬂen", "Angeschlossen an Kommandotrupp ", 0));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        setEintragsCNT(oe1.isSelected() ? 0 : 1);
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("BTHQ", -1);
		BuildaHQ.addToInformationVector("BTKommandant", -1);
		BuildaHQ.addToInformationVector("BTOrdenspriester", -1);
		super.deleteYourself();
	}
	
}
