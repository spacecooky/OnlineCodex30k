package oc.wh30k.units.we;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class WELegionSicaranBattleTank extends Eintrag {

	OptionsUpgradeGruppe o1, o2;

	public WELegionSicaranBattleTank() {
		name = "Legion Sicaran Battle Tank";
		grundkosten = 135;
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter sponsons", 20));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon sponsons", 40));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 10));
		ogE.addElement(new OptionsGruppeEintrag("Dozer blade", 5));
		ogE.addElement(new OptionsGruppeEintrag("Axiliary Drive", 10));
		ogE.addElement(new OptionsGruppeEintrag("Armoured Ceramite", 20));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 4));

		complete();
	}

	@Override
	public void refreshen() {
				
	}

}
