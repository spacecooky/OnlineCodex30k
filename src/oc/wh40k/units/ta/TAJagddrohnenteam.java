package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class TAJagddrohnenteam extends Eintrag {

	public TAJagddrohnenteam() {

		name = "Jagddrohnenteam";

		grundkosten = 0;



		add(new AnzahlPanel(ID, randAbstand, cnt, "Jagddrohnenteam", "Jagddrohnenteams", 1, 3, 80));



		add(ico = new oc.Picture("oc/wh40k/images/Jagddrohnenteam.gif"));





		complete();

	}

	//@OVERRIDE
	public void refreshen() {
	}
}
