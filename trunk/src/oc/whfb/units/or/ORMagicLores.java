package oc.whfb.units.or;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ORMagicLores extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	public ORMagicLores() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {	
		if ( defaults[0] ){//Orkshamane
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Groﬂer Waaagh!")));
		} else {
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kleiner Waaagh!")));
		}	
		add(o1 = new OptionsUpgradeGruppe( ID, randAbstand, cnt, "", ogE, false ));
		
		setHeadline(o1, BuildaHQ.translate("Lehren der Magie"));
		setUeberschrift(BuildaHQ.translate("Lehren der Magie"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
	}	
}
