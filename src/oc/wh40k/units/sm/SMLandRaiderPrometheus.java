package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SMLandRaiderPrometheus extends Eintrag {

	OptionsEinzelUpgrade chronus;

	boolean chronusSelected = false;

	public SMLandRaiderPrometheus() {
		name = "Land Raider Prometheus";
		grundkosten = 270;

		add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderPrometheus.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multimelter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
