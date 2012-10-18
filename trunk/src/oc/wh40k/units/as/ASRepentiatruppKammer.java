package oc.wh40k.units.as;

import oc.AnzahlPanel;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class ASRepentiatruppKammer extends RuestkammerVater {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;

	public ASRepentiatruppKammer() {}

	public void initButtons(boolean... defaults) {
		name = "Repentiatrupp\n";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Repentia", 5, 10, 17);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ASRepentiatrupp.jpg"));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ASDominatris", "Upgrade zur Dominatris");
		rkBoss.initKammer();
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		sizeSetzen();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
	}

}
