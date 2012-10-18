package oc.wh40k.units.ig;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IGOgrynTrupp extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkTransport;

	boolean lastState = false;

	public IGOgrynTrupp() {
		name = "Ogryn Trupp";
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Ogryns", 3, 10, 40);
		squad.setGrundkosten(10);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGOgrynSquad.jpg"));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "IGChimaere", "Chimäre");
		rkTransport.initKammer(true);
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
