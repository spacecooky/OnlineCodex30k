package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IGBanebladeKompanie extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;
	RuestkammerStarter t4;
	RuestkammerStarter t5;
	RuestkammerStarter t6;

	public IGBanebladeKompanie() {
		name = "Baneblade-Kompanie";
		grundkosten = 150;
		this.überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/IGBanebladeKompanie.jpg"));

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "IGBanebladeKammer", "", 1);
		t1.initKammer(true);
		t1.setButtonText("Befehlspanzer");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "IGBanebladeKammer", "", 1);
		t2.initKammer(false);
		t2.setButtonText("Baneblade");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "IGBanebladeKammer", "", 1);
		t3.initKammer(false);
		t3.setButtonText("Baneblade");
		add(t3);

		seperator();

		t4 = new RuestkammerStarter(ID, randAbstand, cnt, "IGBanebladeKammer", "", 1);
		t4.initKammer(false);
		t4.setButtonText("Baneblade");
		add(t4);

		seperator();

		t5 = new RuestkammerStarter(ID, randAbstand, cnt, "IGBanebladeKammer", "", 1);
		t5.initKammer(false);
		t5.setButtonText("Baneblade");
		add(t5);

		seperator();

		t6 = new RuestkammerStarter(ID, randAbstand, cnt, "IGBanebladeKammer", "", 1);
		t6.initKammer(false);
		t6.setButtonText("Baneblade");
		add(t6);

		complete();
	}

	@Override
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
