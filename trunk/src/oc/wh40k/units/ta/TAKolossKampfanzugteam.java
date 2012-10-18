package oc.wh40k.units.ta;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class TAKolossKampfanzugteam extends Eintrag {

	RuestkammerStarter ob1;
	RuestkammerStarter ob2;
	RuestkammerStarter o1;
	RuestkammerStarter o2;
	RuestkammerStarter o3;

	public TAKolossKampfanzugteam() {
		name = "Koloss Kampfanzugteam";
		überschriftSetzen = true;
		grundkosten = 0;
        
        BuildaHQ.addToInformationVector("TA2006KolossKampfanzugteam", 1);

		add(ico = new oc.Picture("oc/wh40k/images/KolossKampfanzugteam.gif"));
		

		ob1 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKolossKammer", "Koloss Shas'vre");
		ob1.setGrundkosten(80);
		ob1.initKammer(true, true);
		add(ob1);

		ob2 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKolossKammer", "Koloss Teamführer");
		ob2.setGrundkosten(75);
		ob2.initKammer(true, false);
		add(ob2);

		o1 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKolossKammer", "Koloss");
		o1.initKammer(false, false);
		add(o1);

		seperator();

		o2 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKolossKammer", "Koloss");
		o2.initKammer(false, false);
		add(o2);

		o3 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKolossKammer", "Koloss");
		o3.initKammer(false, false);
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

        // O'Shova Sonderregel beachten
        int currentUnitCount = BuildaHQ.getCountFromInformationVector("TA2006KolossKampfanzugteam");
        boolean oshova = BuildaHQ.getCountFromInformationVector("TA2006OShovah") == 0 ? false : true;
        if(oshova && currentUnitCount > 1) setFehlermeldung("0-1 wgegen O'Shova");
        else setFehlermeldung("");
	}

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.addToInformationVector("TA2006KolossKampfanzugteam", -1);
    }

}
