package oc.wh40k.units.sw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SWSpaceWolvesLandRaiderCrusader extends Eintrag {

	public SWSpaceWolvesLandRaiderCrusader() {
		name = "Land Raider Crusader";
		grundkosten = 250;

		add(ico = new oc.Picture("oc/wh40k/images/SWLandRaiderCrusader.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multimelter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
