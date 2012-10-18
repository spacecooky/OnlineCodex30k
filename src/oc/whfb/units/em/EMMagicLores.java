package oc.whfb.units.em;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class EMMagicLores extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	boolean isSlann 		= false;
	boolean isSkink 		= false;
	boolean isTehenhauin 	= false;
	
	public EMMagicLores() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {	
		isSlann 	 = defaults[0];
		isSkink 	 = defaults[1];
		isTehenhauin = defaults[2];
		
		if ( isSlann ) {
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Schatten")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Todes")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Feuers")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Metalls")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Lichts")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Himmel")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Bestien")));		
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Lebens")));
		} else if ( isSkink ) {
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Himmel")));
		} else if ( isTehenhauin ) {
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
