package oc.wh30k.units.we;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class WEKharnTheBloody extends Eintrag {
	
	OptionsUpgradeGruppe o1;

	public WEKharnTheBloody() {
		name = "Khârn The Bloody";
		grundkosten = 170;
		
		BuildaHQ.addToInformationVector("WEPraetor", 1);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Gorechild", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        o1.setAktiv(BuildaHQ.getCountFromInformationVector("WEAngron")<1);
	}
	
	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("WEPraetor", -1);
		super.deleteYourself();
		
	}
	

}
