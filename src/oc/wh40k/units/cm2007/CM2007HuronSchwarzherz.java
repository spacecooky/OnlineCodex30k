package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CM2007HuronSchwarzherz extends Eintrag {

	OptionsEinzelUpgrade o1;
	OptionsUpgradeGruppe o3;
	OptionsEinzelZaehler o4;
	OptionsZaehlerGruppe o5;
	RuestkammerStarter ot;

	public CM2007HuronSchwarzherz() {
		name = "Huron Schwarzherz";
		grundkosten = 170;

		add(ico = new oc.Picture("oc/wh40k/images/HuronBlackheart.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
