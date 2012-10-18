package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class SMGepanzerteSpeerspitze extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;
	RuestkammerStarter t4;
	RuestkammerStarter t5;
	RuestkammerStarter t6;

        int i = 0;

	public SMGepanzerteSpeerspitze() {
		name = "Gepanzerte Speerspitze";
		grundkosten = 50;

		add(ico = new oc.Picture("oc/wh40k/images/SMGepanzerteSpeerspitze.jpg"));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "SMLandRaiderKammer", "", 1);
		t1.initKammer(true);
		t1.setButtonText("Befehls-Land Raider");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "SMLandRaiderKammer", "", 1);
		t2.initKammer(false);
		t2.setButtonText("Land Raider");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "SMLandRaiderKammer", "", 1);
		t3.initKammer(false);
		t3.setButtonText("Land Raider");
		add(t3);

		seperator();

		t4 = new RuestkammerStarter(ID, randAbstand, cnt, "SMLandRaiderKammer", "", 1);
		t4.initKammer(false);
		t4.setButtonText("Land Raider");
		add(t4);

		seperator();

		t5 = new RuestkammerStarter(ID, randAbstand, cnt, "SMLandRaiderKammer", "", 1);
		t5.initKammer(false);
		t5.setButtonText("Land Raider");
		add(t5);

		seperator();

		t6 = new RuestkammerStarter(ID, randAbstand, cnt, "SMLandRaiderKammer", "", 1);
		t6.initKammer(false);
		t6.setButtonText("Land Raider");
		add(t6);

		complete();
	}

	
	public void refreshen() {
            t1.setAbwaehlbar(false);
            t2.setAbwaehlbar(false);
            t3.setAbwaehlbar(false);
            t4.setAktiv(t3.isSelected() && t2.isSelected() && t1.isSelected());
            t5.setAktiv(t4.isSelected());
            t6.setAktiv(t5.isSelected());

            t2.getPanel().setLocation(t2.getPanel().getX(), t1.getPanel().getY() + t1.getPanel().getHeight() + 10);
            t3.getPanel().setLocation(t3.getPanel().getX(), t2.getPanel().getY() + t2.getPanel().getHeight() + 10);
            t4.getPanel().setLocation(t4.getPanel().getX(), t3.getPanel().getY() + t3.getPanel().getHeight() + 10);
            t5.getPanel().setLocation(t5.getPanel().getX(), t4.getPanel().getY() + t4.getPanel().getHeight() + 10);
            t6.getPanel().setLocation(t6.getPanel().getX(), t5.getPanel().getY() + t5.getPanel().getHeight() + 10);
	}

}
