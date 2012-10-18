package oc.wh40k.units.bt;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class BTLandRaiderCrusader extends Eintrag {

	public BTLandRaiderCrusader() {
		name = "Land Raider Crusader";
		grundkosten = 265;

		add(ico = new oc.Picture("oc/wh40k/images/BTLandRaiderCrusader.jpg"));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Gesalbter Rumpf", 25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Nebelwerfer", 3));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
