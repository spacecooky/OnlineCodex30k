package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class ORStampfaMobKammerAufgemotztaStampfa extends RuestkammerVater {

	public ORStampfaMobKammerAufgemotztaStampfa() {
		grundkosten = 600;
	}

	public void initButtons(boolean... defaults) {
		name = "Aufgemotzta Stampfa\n";
		grundkosten = 600;

		add(ico = new oc.Picture("oc/wh40k/images/BigMeksStampfa.gif"));
		

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Schmettaball",50));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Kill-Arsenal",120));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Wanstwumme",150));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Rotä Frabä",25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Schraubakrew",75));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Traktorstrahla",25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Morks Blick",25));

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
	}

}
