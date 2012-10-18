package oc.whfb.units.im;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IMMagicLores extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	public IMMagicLores() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Metalls")));			
		if ( defaults[0] ){// Baltasar Gelt
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Bestien")));		
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Lebens")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Himmels")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Schatten")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Todes")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Feuers")));			
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Lichts")));
		}
		
		add(o1 = new OptionsUpgradeGruppe( ID, randAbstand, cnt, "", ogE, false ));
		
		setHeadline(o1, BuildaHQ.translate("Lehren der Magie"));
		setUeberschrift(BuildaHQ.translate("Lehren der Magie"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		setButtonState(BuildaHQ.noErrors);
		o1.alwaysSelected();
	}

}
