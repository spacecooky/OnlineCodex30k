package oc.wh40k.units.ab;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ABScoutSentinelSquadron extends Eintrag {

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	RuestkammerStarter v1;
	RuestkammerStarter v2;
	RuestkammerStarter v3;

	public ABScoutSentinelSquadron() {
		name = "Scout Sentinel Squadron";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/ABScoutSentinelSquadron.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Smoke launchers", 5));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo-netting", 10));

		seperator();

		v1 = new RuestkammerStarter(ID, randAbstand, cnt, "ABScoutSentinel", "Scout Sentinel");
		v1.initKammer();
        v1.setGrundkosten(35);
		add(v1);

		seperator();

		v2 = new RuestkammerStarter(ID, randAbstand, cnt, "ABScoutSentinel", "Scout Sentinel");
		v2.initKammer();
        v2.setGrundkosten(35);
		add(v2);

		seperator();

		v3 = new RuestkammerStarter(ID, randAbstand, cnt, "ABScoutSentinel", "Scout Sentinel");
		v3.initKammer();
        v3.setGrundkosten(35);
		add(v3);

		complete();
	}

	@Override
	public void refreshen() {
		int vehicles = (v1.isSelected() ? 1 : 0) + (v2.isSelected() ? 1 : 0) + (v3.isSelected() ? 1 : 0);

		oe1.setPreis(vehicles * 5);
		oe1.setAktiv(vehicles > 0);

		oe2.setPreis(vehicles * 10);
		oe2.setAktiv(vehicles > 0);
	}

}
