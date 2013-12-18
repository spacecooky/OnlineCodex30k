package oc.wh30k.units.lc;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class LCMyrmidonSecutors extends Eintrag {

	RuestkammerStarter t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;

	public LCMyrmidonSecutors() {
		name = "Myrmidon Secutors";
		grundkosten = 0;
        überschriftSetzen = true;

		seperator();
		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonLordKammer", "Myrmidon Lord");
		t1.initKammer(true, false);
		t1.setAbwaehlbar(false);
		add(t1);		

		seperator();
		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "Myrmidon Secutor");
		t2.initKammer(true, false);
		t2.setAbwaehlbar(false);
		add(t2);

		seperator();
		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "Myrmidon Secutor");
		t3.initKammer(true, false);
		t3.setAbwaehlbar(false);
		add(t3);

		seperator();
		t4 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "Myrmidon Secutor");
		t4.initKammer(true, false);
		add(t4);

		seperator();
		t5 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "Myrmidon Secutor");
		t5.initKammer(true, false);
		add(t5);

		seperator();
		t6 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "Myrmidon Secutor");
		t6.initKammer(true, false);
		add(t6);

		seperator();
		t7 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "Myrmidon Secutor");
		t7.initKammer(true, false);
		add(t7);

		seperator();
		t8 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "Myrmidon Secutor");
		t8.initKammer(true, false);
		add(t8);

		seperator();
		t9 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "Myrmidon Secutor");
		t9.initKammer(true, false);
		add(t9);

		seperator();
		t10 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "Myrmidon Secutor");
		t10.initKammer(true, false);
		add(t10);

		complete();
	}

	
	public void refreshen() {
            /*if (!t1.isSelected()) {t1.setSelected(true);}
            if (!t2.isSelected()) {t2.setSelected(true);}
            if (!t3.isSelected()) {t3.setSelected(true);}  */          
                       
            t5.setAktiv(t4.isSelected());
            t6.setAktiv(t5.isSelected());
            t7.setAktiv(t6.isSelected());
            t8.setAktiv(t7.isSelected());
            t9.setAktiv(t8.isSelected());
            t10.setAktiv(t9.isSelected());

            t2.getPanel().setLocation(t2.getPanel().getX(), t1.getPanel().getY() + t1.getPanel().getHeight() + 5);
            t3.getPanel().setLocation(t3.getPanel().getX(), t2.getPanel().getY() + t2.getPanel().getHeight() + 5);
            t4.getPanel().setLocation(t4.getPanel().getX(), t3.getPanel().getY() + t3.getPanel().getHeight() + 5);
            t5.getPanel().setLocation(t5.getPanel().getX(), t4.getPanel().getY() + t4.getPanel().getHeight() + 5);
            t6.getPanel().setLocation(t6.getPanel().getX(), t5.getPanel().getY() + t5.getPanel().getHeight() + 5);
            t7.getPanel().setLocation(t7.getPanel().getX(), t6.getPanel().getY() + t6.getPanel().getHeight() + 5);
            t8.getPanel().setLocation(t8.getPanel().getX(), t7.getPanel().getY() + t7.getPanel().getHeight() + 5);
            t9.getPanel().setLocation(t9.getPanel().getX(), t8.getPanel().getY() + t8.getPanel().getHeight() + 5);
            t10.getPanel().setLocation(t10.getPanel().getX(), t9.getPanel().getY() + t9.getPanel().getHeight() + 5);
            }

}
