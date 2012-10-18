package oc.whfb.units.we;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class WEMagicLores extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	public WEMagicLores() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre von Athel Loren")));
		
		if( defaults[0] ) { //Zauberweber
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Lebens")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Bestien")));
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
