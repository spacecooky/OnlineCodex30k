package oc.whfb.units.bdc;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class BDCMagicLores extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	public BDCMagicLores() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Wildnis")));		
		if ( !defaults[0] ){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Todes")));
			if ( !defaults[1] )ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Bestien")));
		}
		if ( !defaults[1] ) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Schatten")));
		
		add(o1 = new OptionsUpgradeGruppe( ID, randAbstand, cnt, "", ogE, false ));
		
		setHeadline(o1, BuildaHQ.translate("Lehren der Magie"));
		setUeberschrift(BuildaHQ.translate("Lehren der Magie"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
	}

}
