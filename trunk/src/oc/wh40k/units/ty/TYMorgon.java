package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class TYMorgon extends Eintrag {

	public TYMorgon() {
		name = "Morgon";
		grundkosten = 170;

		add(ico = new oc.Picture("oc/wh40k/images/TYMorgon.jpg"));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenalindrüsen", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxinkammern", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Regeneration", 25));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
