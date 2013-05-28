package oc.wh30k.units.dg;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DGMortariontheReaper extends Eintrag {

	OptionsUpgradeGruppe o0;

	public DGMortariontheReaper() {
		name = "Mortarion the Reaper";
		grundkosten = 425;

		add(ico = new oc.Picture("oc/wh40k/images/xy.jpg"));

		BuildaHQ.addToInformationVector("DGPraetor", 1);
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Angel's wrath", 0));
		ogE.addElement(new OptionsGruppeEintrag("Armoured spearhead", 0));
		ogE.addElement(new OptionsGruppeEintrag("Orbital assault", 0));
		ogE.addElement(new OptionsGruppeEintrag("Pride of the Legion", 0));
		add(o0 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}
	
	@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("DGPraetor", -1);
		super.deleteYourself();
	}

}
