package oc.wh30k.units.sh;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class SHLegionWhirlwindScorpius extends Eintrag {

	OptionsUpgradeGruppe o1;

	public SHLegionWhirlwindScorpius() {
		name = "Legion Whirlwind Scorpius";
		grundkosten = 115;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 10));
		ogE.addElement(new OptionsGruppeEintrag("Dozer blade", 5));
		ogE.addElement(new OptionsGruppeEintrag("Extra armour", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));

		complete();
	}

	@Override
	public void refreshen() {
				
	}

}
