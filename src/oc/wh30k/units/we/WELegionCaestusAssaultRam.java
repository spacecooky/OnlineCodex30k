package oc.wh30k.units.we;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class WELegionCaestusAssaultRam extends Eintrag {

	OptionsUpgradeGruppe o1;

	public WELegionCaestusAssaultRam() {
		name = "Legion Caestus Assault Ram";
		grundkosten = 305;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Auxiliary drive", 10));
		ogE.addElement(new OptionsGruppeEintrag("Frag assault launchers", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
				
		complete();
	}

	@Override
	public void refreshen() {
				
	}

}
