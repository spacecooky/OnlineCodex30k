package oc.wh40k.units.ab;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ABBombardBattery extends Eintrag {

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	RuestkammerStarter v1;
	RuestkammerStarter v2;
	RuestkammerStarter v3;

	public ABBombardBattery() {
		name = "Bombard Battery";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/ABBombardBattery.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Enclosed crew comp.", "Enclosed crew compartments", 15));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo-netting", 30));

		seperator();

		v1 = new RuestkammerStarter(ID, randAbstand, cnt, "ABBombard", "Bombard");
		v1.initKammer();
        v1.setGrundkosten(145);
		add(v1);

		seperator();

		v2 = new RuestkammerStarter(ID, randAbstand, cnt, "ABBombard", "Bombard");
		v2.initKammer();
        v2.setGrundkosten(145);
		add(v2);

		seperator();

		v3 = new RuestkammerStarter(ID, randAbstand, cnt, "ABBombard", "Bombard");
		v3.initKammer();
        v3.setGrundkosten(145);
		add(v3);

		complete();
	}

	@Override
	public void refreshen() {
		int vehicles = (v1.isSelected() ? 1 : 0) + (v2.isSelected() ? 1 : 0) + (v3.isSelected() ? 1 : 0);

		oe1.setPreis(vehicles * 15);
		oe1.setAktiv(vehicles > 0);

		oe2.setPreis(vehicles * 30);
		oe2.setAktiv(vehicles > 0);
	}

}
