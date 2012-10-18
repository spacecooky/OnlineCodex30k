package oc.wh40k.units.sf;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SFLandRaiderHelios extends Eintrag {
    
        OptionsUpgradeGruppe o1;

	public SFLandRaiderHelios() {
		name = "Land Raider Helios";
		grundkosten = 260;

		add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderHelios.jpg"));

		seperator();

                ogE.addElement(new OptionsGruppeEintrag("WW-Raketenwerfer", "Whirlwind-Raketenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Hyperios launcher", "Hyperios anti-aircraft launcher", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

                seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
		complete();
	}

	@Override
	public void refreshen() {
                o1.alwaysSelected();
	}


}
