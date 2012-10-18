package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORDakkajet extends Eintrag {

	public ORDakkajet() {
		name = "Dakkajet";
		grundkosten = 110;


		add(ico = new oc.Picture("oc/wh40k/images/Dakkajet.gif"));
		

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt,"", "zus. sync. Dakkawumme","zusätzliche synchronisiserte Dakkawumme",10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt,"", "Rotä Farbä",5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt,"", "Fliegerass",10));
		
		complete();

	}

	public void refreshen() {
	}
}
