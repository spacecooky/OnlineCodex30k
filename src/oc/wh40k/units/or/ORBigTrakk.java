package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORBigTrakk extends Eintrag {

    RuestkammerStarter t1;
    RuestkammerStarter t2;
    RuestkammerStarter t3;

	public ORBigTrakk() {
		name = "Big Trakk";
		grundkosten = 0;


		add(ico = new oc.Picture("oc/wh40k/images/BigTrakk.gif"));
		

        t1 = new RuestkammerStarter(ID, randAbstand, cnt, "ORBigTrakkKammer", "Big Trakk");
		t1.initKammer();
		add(t1);

        seperator();

        t2 = new RuestkammerStarter(ID, randAbstand, cnt, "ORBigTrakkKammer", "Big Trakk");
		t2.initKammer();
		add(t2);

        seperator();

        t3 = new RuestkammerStarter(ID, randAbstand, cnt, "ORBigTrakkKammer", "Big Trakk");
		t3.initKammer();
		add(t3);

    	complete();

	}

	public void refreshen() {
	}
}
