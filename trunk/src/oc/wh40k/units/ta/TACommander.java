package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class TACommander extends Eintrag {

	OptionsUpgradeGruppe o1;
	RuestkammerStarter ob;

	public TACommander() {
		name = "Commander";
		grundkosten = 0;

		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Commander.gif"));
		
		ogE.addElement(new OptionsGruppeEintrag("Shas'el", 50));
		ogE.addElement(new OptionsGruppeEintrag("Shas'o", 75));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ob = new RuestkammerStarter(ID, randAbstand, cnt, "TAKampfanzugKammer", "Commander");
		ob.setGrundkosten(0);
		ob.initKammer(true, true,true);
		ob.setButtonText("Rüstkammer");
		add(ob);

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0, true);
	}
	
}
