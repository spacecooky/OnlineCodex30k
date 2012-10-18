package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CM2007BeschworenerGrosserDaemon extends Eintrag {

	OptionsEinzelUpgrade o1;
	OptionsUpgradeGruppe o3;
	OptionsEinzelZaehler o4;
	OptionsZaehlerGruppe o5;
	RuestkammerStarter ot;

	public CM2007BeschworenerGrosserDaemon() {

		name = "Beschworener Gro�er D�mon";
		grundkosten = 100;
		this.setEintragsCNT(0);

		add(ico = new oc.Picture("oc/wh40k/images/SummonedGreaterDaemon.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
	}

}
