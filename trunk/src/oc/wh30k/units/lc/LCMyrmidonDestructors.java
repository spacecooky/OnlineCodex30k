package oc.wh30k.units.lc;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class LCMyrmidonDestructors extends Eintrag {

	RuestkammerStarter t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;

	public LCMyrmidonDestructors() {
		name = "Myrmidon Secutors";
		grundkosten = 0;
        überschriftSetzen = true;

		seperator();
		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonLordKammer", "", 1);
		t1.initKammer(false, true);
		t1.setButtonText("Myrmidon Lord");
		t1.setAbwaehlbar(false);
		add(t1);		

		seperator();
		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "", 1);
		t2.initKammer(false, true);
		t2.setButtonText("Myrmidon Secutor");
		t2.setAbwaehlbar(false);
		add(t2);

		seperator();
		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "", 1);
		t3.initKammer(false, true);
		t3.setButtonText("Myrmidon Secutor");
		t3.setAbwaehlbar(false);
		add(t3);

		seperator();
		t4 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "", 1);
		t4.initKammer(false, true);
		t4.setButtonText("Myrmidon Secutor");
		add(t4);

		seperator();
		t5 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "", 1);
		t5.initKammer(false, true);
		t5.setButtonText("Myrmidon Secutor");
		add(t5);

		seperator();
		t6 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "", 1);
		t6.initKammer(false, true);
		t6.setButtonText("Myrmidon Secutor");
		add(t6);

		seperator();
		t7 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "", 1);
		t7.initKammer(false, true);
		t7.setButtonText("Myrmidon Secutor");
		add(t7);

		seperator();
		t8 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "", 1);
		t8.initKammer(false, true);
		t8.setButtonText("Myrmidon Secutor");
		add(t8);

		seperator();
		t9 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "", 1);
		t9.initKammer(false, true);
		t9.setButtonText("Myrmidon Secutor");
		add(t9);

		seperator();
		t10 = new RuestkammerStarter(ID, randAbstand, cnt, "LCMyrmidonKammer", "", 1);
		t10.initKammer(false, true);
		t10.setButtonText("Myrmidon Secutor");
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
