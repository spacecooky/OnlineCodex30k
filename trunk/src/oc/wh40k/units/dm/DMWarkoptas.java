package oc.wh40k.units.dm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class DMWarkoptas extends Eintrag {

    RuestkammerStarter t1;
    RuestkammerStarter t2;
    RuestkammerStarter t3;

	public DMWarkoptas() {
		name = "Warkopta";
		
		kategorie=4;
		
		grundkosten = 0;


		add(ico = new oc.Picture("oc/wh40k/images/Warkopta.gif"));
		

        t1 = new RuestkammerStarter(ID, randAbstand, cnt, "DMWarkoptaKammer", "Warkopta");
		t1.initKammer();
		add(t1);

        seperator();

        t2 = new RuestkammerStarter(ID, randAbstand, cnt, "DMWarkoptaKammer", "Warkopta");
		t2.initKammer();
		add(t2);

        seperator();

        t3 = new RuestkammerStarter(ID, randAbstand, cnt, "DMWarkoptaKammer", "Warkopta");
		t3.initKammer();
		add(t3);

    	complete();

	}

	public void refreshen() {
	}
}
