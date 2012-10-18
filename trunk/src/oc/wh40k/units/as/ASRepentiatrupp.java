package oc.wh40k.units.as;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ASRepentiatrupp extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;

	public ASRepentiatrupp() {
		name = "Repentiatrupp\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Repentia", 5, 10, 17);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ASRepentiatrupp.jpg"));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ASDominatris", "Upgrade zur Dominatris");
		rkBoss.initKammer();
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
	}

}
