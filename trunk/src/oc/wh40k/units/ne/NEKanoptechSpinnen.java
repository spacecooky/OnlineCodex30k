package oc.wh40k.units.ne;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class NEKanoptechSpinnen extends Eintrag {

	RuestkammerStarter s1;
	RuestkammerStarter s2;
	RuestkammerStarter s3;

	public NEKanoptechSpinnen() {
		name = "Kanoptech-Spinnen";
		grundkosten = 0;
		überschriftSetzen = true;
        
		add(ico = new oc.Picture("oc/wh40k/images/NEKanoptechSpinnen.jpg"));

		seperator();

		s1 = new RuestkammerStarter(ID, randAbstand, cnt, "NEKanoptechSpinneKammer", "Kanoptech-Spinne");
		s1.initKammer();
		add(s1);

		s2 = new RuestkammerStarter(ID, randAbstand, cnt, "NEKanoptechSpinneKammer", "Kanoptech-Spinne");
		s2.initKammer();
		add(s2);

		s3 = new RuestkammerStarter(ID, randAbstand, cnt, "NEKanoptechSpinneKammer", "Kanoptech-Spinne");
		s3.initKammer();
		add(s3);

		complete();
	}

	@Override
	public void refreshen() {
	}

}
