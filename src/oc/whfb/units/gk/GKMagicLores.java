package oc.whfb.units.gk;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class GKMagicLores extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	public GKMagicLores() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {			
		if (defaults[0])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre von Nehekhara")));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Todes")));
		if (defaults[0])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Lichts")));
					
		add(o1 = new OptionsUpgradeGruppe( ID, randAbstand, cnt, "", ogE, false ));
		
		setHeadline(o1, BuildaHQ.translate("Lehren der Magie"));
		setUeberschrift(BuildaHQ.translate("Lehren der Magie"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
	}

	@Override
	public void specialAction(boolean... action) {
		
		if (action[0]){
			o1.setAktiv(BuildaHQ.translate("Lehre des Todes"), false);
			o1.setAktiv(BuildaHQ.translate("Lehre des Lichts"), false);
		} else {
			o1.setAktiv(BuildaHQ.translate("Lehre des Todes"), true);
			o1.setAktiv(BuildaHQ.translate("Lehre des Lichts"), true);
		}
		
		super.specialAction(action);
	}	
	
	
}
