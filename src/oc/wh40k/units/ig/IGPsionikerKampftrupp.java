package oc.wh40k.units.ig;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IGPsionikerKampftrupp extends Eintrag {

	AnzahlPanel squad;
    OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkTransport;

	boolean lastState = false;

	public IGPsionikerKampftrupp() {
		name = "Psioniker-Kampftrupp\n";
		grundkosten = 0;
        überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Sanktionierte Psioniker", 4, 9, 10);
		squad.setGrundkosten(10);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGPsykerBattleSquad.jpg"));

		seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Aufseher", 10));

        seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "IGChimaere", "Chimäre");
		rkTransport.initKammer(true);
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        oe1.setSelected(true);
	}

}
