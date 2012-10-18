package oc.wh40k.units.ab;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ABValkyrieAssaultCarrierSquadron extends Eintrag {

	RuestkammerStarter v1;
	RuestkammerStarter v2;
	RuestkammerStarter v3;

	public ABValkyrieAssaultCarrierSquadron() {
		name = "Valkyrie Assault Carrier Squadron";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/ABValkyrieAssaultCarrierSquadron.jpg"));

		v1 = new RuestkammerStarter(ID, randAbstand, cnt, "ABValkyrie", "Valkyrie");
		v1.initKammer();
        v1.setGrundkosten(100);
		add(v1);

		seperator();

		v2 = new RuestkammerStarter(ID, randAbstand, cnt, "ABValkyrie", "Valkyrie");
		v2.initKammer();
        v2.setGrundkosten(100);
		add(v2);

		seperator();

		v3 = new RuestkammerStarter(ID, randAbstand, cnt, "ABValkyrie", "Valkyrie");
		v3.initKammer();
        v3.setGrundkosten(100);
		add(v3);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
