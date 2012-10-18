package oc.whfb.units.de;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DEMagicLores extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	public DEMagicLores() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwarze Magie")));
		
		if( ! defaults[0] ) {
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Todes")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Feuers")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Metalls")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Schatten")));
		}
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
