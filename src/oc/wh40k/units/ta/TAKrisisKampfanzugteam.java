package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class TAKrisisKampfanzugteam extends Eintrag {

	RuestkammerStarter ob1;
	RuestkammerStarter ob2;
	RuestkammerStarter o1;
	RuestkammerStarter o2;
	RuestkammerStarter o3;

	public TAKrisisKampfanzugteam() {
		name = "Krisis Kampfanzugteam";
		überschriftSetzen = true;
		grundkosten = 0;

		add(ico = new oc.Picture("oc/wh40k/images/KrisisKampfanzugteam.gif"));
		

		ob1 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKampfanzugKammer", "Krisis Shas'vre");
		ob1.setGrundkosten(35);
		ob1.initKammer(true, true, false);
		add(ob1);

		ob2 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKampfanzugKammer", "Krisis Teamführer");
		ob2.setGrundkosten(30);
		ob2.initKammer(true, false, false);
		add(ob2);

		o1 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKampfanzugKammer", "Krisis");
		o1.initKammer(false, false, false);
		add(o1);

		seperator();

		o2 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKampfanzugKammer", "Krisis");
		o2.initKammer(false, false, false);
		add(o2);

		o3 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKampfanzugKammer", "Krisis");
		o3.initKammer(false, false, false);
		add(o3);

        complete();
	}

    @Override
	public void refreshen() {
		ob1.setAktiv(!o1.isSelected() && !ob2.isSelected());
		ob2.setAktiv(!o1.isSelected() && !ob1.isSelected());
		o1.setAktiv(!ob1.isSelected() && !ob2.isSelected());

		ob2.getPanel().setLocation((int) ob2.getPanel().getLocation().getX(), (int) ob1.getPanel().getLocation().getY() + ob1.getPanel().getSize().height);
		o1.getPanel().setLocation((int) o1.getPanel().getLocation().getX(), (int) ob2.getPanel().getLocation().getY() + ob2.getPanel().getSize().height);
		o2.getPanel().setLocation((int) o2.getPanel().getLocation().getX(), (int) o1.getPanel().getLocation().getY() + o1.getPanel().getSize().height + 8);
		o3.getPanel().setLocation((int) o3.getPanel().getLocation().getX(), (int) o2.getPanel().getLocation().getY() + o2.getPanel().getSize().height);
	}
    
}
