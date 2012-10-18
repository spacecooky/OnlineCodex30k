package oc.whfb.units.bt;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class BTMagicLores extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	public BTMagicLores() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Bestien")));		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Lebens")));			
		if ( defaults[0] ){// Dame der Herrin
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Himmel")));
		}
		else if ( defaults[1] ) {// Morgiana
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Schatten")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Todes")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Feuers")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Metalls")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Lichts")));
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
