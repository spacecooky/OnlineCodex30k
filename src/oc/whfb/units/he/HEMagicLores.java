package oc.whfb.units.he;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class HEMagicLores extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	boolean eltharion = false;
	
	public HEMagicLores() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {	
		
		try{
			eltharion = defaults[1];
		} catch (Exception e) {
			eltharion = false;
		}
		
		if ( !defaults[0] ) {
			if (!eltharion ) {
				ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Weiﬂe Magie")));	
			}
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Schatten")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Todes")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Metalls")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Lichts")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Bestien")));		
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Lebens")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Himmel")));
		}
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Feuers")));
		
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
