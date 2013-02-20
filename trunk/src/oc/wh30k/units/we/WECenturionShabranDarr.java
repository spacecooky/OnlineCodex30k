package oc.wh30k.units.we;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class WECenturionShabranDarr extends Eintrag {
	
	OptionsUpgradeGruppe o1;

	public WECenturionShabranDarr() {
		name = "Centurion Shabran Darr";
		grundkosten = 115;

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Jump pack", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
	@Override
	public void deleteYourself() {
		
	}
	

}
