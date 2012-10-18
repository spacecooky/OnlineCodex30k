package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class TAKrisisLeibwache extends Eintrag {

	RuestkammerStarter ob1;
	RuestkammerStarter ob2;

	public TAKrisisLeibwache() {

		name = "Krisis Leibwache";
		grundkosten = 0;

		überschriftSetzen = true;
		this.setEintragsCNT(0);

		add(ico = new oc.Picture("oc/wh40k/images/KrisisLeibwache.gif"));
		

		ob1 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKampfanzugKammer", "Krisis Shas'vre");
		ob1.setGrundkosten(35);
		ob1.initKammer(true, true, false);
		add(ob1);

		ob2 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKampfanzugKammer", "Krisis Shas'vre");
		ob2.setGrundkosten(35);
		ob2.initKammer(true, true, false);
		add(ob2);

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		int Krisis = (ob1.isSelected() ? 1 : 0) + (ob2.isSelected() ? 1 : 0);

		ob1.setLegal(Krisis >= 1);
		ob2.setLegal(Krisis >= 1);

		ob2.getPanel().setLocation((int) ob1.getPanel().getLocation().getX(), (int) ob1.getPanel().getLocation().getY() + ob1.getPanel().getSize().height);
	}
}
