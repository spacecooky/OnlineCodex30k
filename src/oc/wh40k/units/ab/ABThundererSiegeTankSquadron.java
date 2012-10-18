package oc.wh40k.units.ab;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ABThundererSiegeTankSquadron extends Eintrag {

	RuestkammerStarter v1;
	RuestkammerStarter v2;
	RuestkammerStarter v3;

	public ABThundererSiegeTankSquadron() {
		name = "Thunderer Siege Tank Squadron";
		grundkosten = 0;
		�berschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/ABThundererSiegeTankSquadron.jpg"));

		v1 = new RuestkammerStarter(ID, randAbstand, cnt, "ABThunderer", "Thunderer");
		v1.initKammer();
        v1.setGrundkosten(140);
		add(v1);

		seperator();

		v2 = new RuestkammerStarter(ID, randAbstand, cnt, "ABThunderer", "Thunderer");
		v2.initKammer();
        v2.setGrundkosten(140);
		add(v2);

		seperator();

		v3 = new RuestkammerStarter(ID, randAbstand, cnt, "ABThunderer", "Thunderer");
		v3.initKammer();
        v3.setGrundkosten(140);
		add(v3);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
