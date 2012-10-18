package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DAWhirlwind extends Eintrag {

    OptionsEinzelUpgrade ia2;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
	RuestkammerStarter techmarine;

	public DAWhirlwind() {
		name = "Whirlwind";
		grundkosten = 85;

		add(ico = new oc.Picture("oc/wh40k/images/DAWhirlwind.gif"));

		seperator();

        add(ia2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "IA2 Update Regeln", "Imperial Armour 2 Update Regeln", 0));

        seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 5));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

		seperator(8);

		techmarine = new RuestkammerStarter(ID, randAbstand, cnt, "DATechmarineKammer", "Techmarine");
		techmarine.initKammer();
		add(techmarine);

		complete();
	}

	@Override
	public void refreshen() {
        if(ia2.isSelected()) {
            oe1.setPreis(10);
            oe2.setPreis(10);
            techmarine.setAktiv(false);
        } else {
            oe1.setPreis(5);
            oe2.setPreis(15);
            techmarine.setAktiv(true);
        }
	}

}
