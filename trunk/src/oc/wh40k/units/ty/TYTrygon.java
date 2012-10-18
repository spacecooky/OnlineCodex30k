package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class TYTrygon extends Eintrag {

	public TYTrygon() {
		name = "Trygon";
		grundkosten = 200;

		add(ico = new oc.Picture("oc/wh40k/images/TYTrygon.jpg"));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Upgrade zum Alpha-Trygon", 40));

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
