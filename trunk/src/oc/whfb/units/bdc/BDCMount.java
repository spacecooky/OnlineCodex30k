package oc.whfb.units.bdc;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class BDCMount extends RuestkammerVater {

	OptionsUpgradeGruppe oz1;
	
	public BDCMount() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
				
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tuskgor Streitwagen"), 80));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gnargor Streitwagen"), 145));
		add(oz1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		setUeberschrift(BuildaHQ.translate("Reittier"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}
}
