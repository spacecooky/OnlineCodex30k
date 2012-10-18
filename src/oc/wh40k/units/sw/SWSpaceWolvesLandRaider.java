package oc.wh40k.units.sw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SWSpaceWolvesLandRaider extends Eintrag {

	public SWSpaceWolvesLandRaider() {
		name = "Land Raider";
		grundkosten = 250;

		add(ico = new oc.Picture("oc/wh40k/images/SWLandRaider.jpg"));

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

	@Override
	public void deleteYourself() {
	}

}
