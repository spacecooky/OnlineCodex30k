package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;

public class SMLandRaiderHeliosAntiAircraft extends Eintrag {

	OptionsEinzelUpgrade chronus;

	boolean chronusSelected = false;
    OptionsUpgradeGruppe o1;
    
	public SMLandRaiderHeliosAntiAircraft() {
		name = "Land Raider Helios (Anti Aircraft)";
		grundkosten = 280;

		add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderHelios.jpg"));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zus�tzliche Panzerung", 15));

		complete();
	}

	@Override
	public void refreshen() {

	}

}
