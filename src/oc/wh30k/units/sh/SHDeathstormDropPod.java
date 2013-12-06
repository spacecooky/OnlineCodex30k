package oc.wh30k.units.sh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class SHDeathstormDropPod extends Eintrag {

	OptionsUpgradeGruppe o1;

	public SHDeathstormDropPod() {
		name = "Deathstorm Drop Pod";
		grundkosten = 90;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Frag launchers", "Deathstorm frag launchers", 0));
		ogE.addElement(new OptionsGruppeEintrag("Krak launchers", "Deathstorm krak launchers", 30));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
				
		if (!o1.isSelected()) o1.setSelected(0, true);
		
	}

}
