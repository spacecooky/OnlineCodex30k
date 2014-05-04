package oc.wh30k.units.ih;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class SHLegionDreadnoughtTalon extends Eintrag {

	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;
	OptionsUpgradeGruppe o1, o2;

	public SHLegionDreadnoughtTalon() {
		name = "Legion Dreadnought Talon";
		grundkosten = 0;
		�berschriftSetzen = true;

		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Legion Drop Pod", 35));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag("Dreadnought Drop Pod", 65));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "SHDreadnoughtKammer", "Legion Dreadnought");
		t1.initKammer();
		t1.setAbwaehlbar(false);
		add(t1);

		seperator();
		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "SHDreadnoughtKammer", "Legion Dreadnought");
		t2.initKammer();
		add(t2);

		seperator();
		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "SHDreadnoughtKammer", "Legion Dreadnought");
		t3.initKammer();
		add(t3);

		complete();
	}

	
	public void refreshen() {
            int selections = t1.getSelectedAsInt() + t2.getSelectedAsInt() + t3.getSelectedAsInt();
            
            t1.setLegal(selections > 0);
            
            t1.setAktiv(t1.isSelected() || selections < 3);
            t2.setAktiv(t2.isSelected() || (t1.isSelected() && selections < 3));
            t3.setAktiv(t3.isSelected() || (t2.isSelected() && selections < 3));

            t2.getPanel().setLocation(t2.getPanel().getX(), t1.getPanel().getY() + t1.getPanel().getHeight() + 10);
            t3.getPanel().setLocation(t3.getPanel().getX(), t2.getPanel().getY() + t2.getPanel().getHeight() + 10);
    
            o1.setAktiv(!o2.isSelected() && BuildaHQ.getCountFromInformationVector("SHRoW") == 3);
            o2.setAktiv(!o1.isSelected() && selections == 1);
            
            o1.setPreis(0, selections * 35);
            }

}
