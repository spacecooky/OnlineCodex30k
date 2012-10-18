package oc.wh40k.units.sf;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class SFSiegeDreadnoughtTalon extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;
	RuestkammerStarter t4;
	RuestkammerStarter t5;
	RuestkammerStarter t6;

	public SFSiegeDreadnoughtTalon() {
		name = "Siege Dreadnought Talon";
		grundkosten = 0;
                überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/SMGepanzerteSpeerspitze.jpg"));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "SFIroncladCybotKammer", "", 1);
		t1.initKammer();
		t1.setButtonText("Ironclad Cybot");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "SFIroncladCybotKammer", "", 1);
		t2.initKammer();
		t2.setButtonText("Ironclad Cybot");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "SFIroncladCybotKammer", "", 1);
		t3.initKammer();
		t3.setButtonText("Ironclad Cybot");
		add(t3);

		seperator();

		t4 = new RuestkammerStarter(ID, randAbstand, cnt, "SFSiegePatternDreadnoughtKammer", "", 1);
		t4.initKammer();
		t4.setButtonText("Siege Pattern Dreadnought");
		add(t4);

		seperator();

		t5 = new RuestkammerStarter(ID, randAbstand, cnt, "SFSiegePatternDreadnoughtKammer", "", 1);
		t5.initKammer();
		t5.setButtonText("Siege Pattern Dreadnought");
		add(t5);

		seperator();

		t6 = new RuestkammerStarter(ID, randAbstand, cnt, "SFSiegePatternDreadnoughtKammer", "", 1);
		t6.initKammer();
		t6.setButtonText("Siege Pattern Dreadnought");
		add(t6);

		complete();
	}

	
	public void refreshen() {
            int selections = t1.getSelectedAsInt() + t2.getSelectedAsInt() + t3.getSelectedAsInt() + t4.getSelectedAsInt() + t5. getSelectedAsInt() + t6.getSelectedAsInt();
            
            t1.setLegal(selections > 0);
            t4.setLegal(selections > 0);
            
            t1.setAktiv(t1.isSelected() || selections < 3);
            t2.setAktiv(t2.isSelected() || (t1.isSelected() && selections < 3));
            t3.setAktiv(t3.isSelected() || (t2.isSelected() && selections < 3));
            
            t4.setAktiv(t4.isSelected() || selections < 3);
            t5.setAktiv(t5.isSelected() || (t4.isSelected() && selections < 3));
            t6.setAktiv(t6.isSelected() || (t5.isSelected() && selections < 3));

            t2.getPanel().setLocation(t2.getPanel().getX(), t1.getPanel().getY() + t1.getPanel().getHeight() + 10);
            t3.getPanel().setLocation(t3.getPanel().getX(), t2.getPanel().getY() + t2.getPanel().getHeight() + 10);
            t4.getPanel().setLocation(t4.getPanel().getX(), t3.getPanel().getY() + t3.getPanel().getHeight() + 10);
            t5.getPanel().setLocation(t5.getPanel().getX(), t4.getPanel().getY() + t4.getPanel().getHeight() + 10);
            t6.getPanel().setLocation(t6.getPanel().getX(), t5.getPanel().getY() + t5.getPanel().getHeight() + 10);
	}

}
