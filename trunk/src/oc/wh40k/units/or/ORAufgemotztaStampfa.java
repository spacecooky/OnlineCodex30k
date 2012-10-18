package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORAufgemotztaStampfa extends Eintrag {

	public ORAufgemotztaStampfa() {
		name = "Aufgemotzta Stampfa";
		grundkosten = 600;

		add(ico = new oc.Picture("oc/wh40k/images/BigMeksStampfa.gif"));
		

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Schmettaball",50));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Kill-Arsenal",120));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Wanstwumme",150));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Rotä Frabä",25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Schraubakrew",75));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Traktorstrahla",25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Morks Blick",25));
		
		complete();

	}

	public void refreshen() {
	}
}
