package oc.whfb.units.vf;

import java.util.Vector;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class VFMagicLores extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	
	boolean isMannfred = false;
	boolean isWissen   = false;
	
	public VFMagicLores() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		isMannfred = defaults[1];
		
		if ( defaults[0] ) {//Vampires
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Vampire")));
			
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Schatten")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Todes")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Feuers")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Metalls")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Lichts")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Himmels")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Bestien")));		
			
		} else {//Nekromant
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Nekromantie")));
		}
		add(o1 = new OptionsUpgradeGruppe( ID, randAbstand, cnt, "", ogE, false ));
		
		if( defaults[1] ) { //Fuerst Mannfred
			seperator(35);
			ogE = new Vector<OptionsGruppeEintrag>();
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Todes")));
			add(o2 = new OptionsUpgradeGruppe( ID, randAbstand, cnt, "", ogE, false ));
		}
		
		setHeadline(o1, BuildaHQ.translate("Lehren der Magie"));
		setUeberschrift(BuildaHQ.translate("Lehren der Magie"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		setButtonState(BuildaHQ.noErrors);
		o1.alwaysSelected();
		if( isMannfred ) {
			o2.alwaysSelected();
		}
				
		o1.setAktiv(BuildaHQ.translate("Lehre der Schatten"), isWissen);
		o1.setAktiv(BuildaHQ.translate("Lehre des Todes"),    isWissen);
		o1.setAktiv(BuildaHQ.translate("Lehre des Feuers"),   isWissen);
		o1.setAktiv(BuildaHQ.translate("Lehre des Metalls"),  isWissen);
		o1.setAktiv(BuildaHQ.translate("Lehre des Lichts"),   isWissen);
		o1.setAktiv(BuildaHQ.translate("Lehre des Himmels"),   isWissen);
		o1.setAktiv(BuildaHQ.translate("Lehre der Bestien"),  isWissen);
		o1.setAktiv(BuildaHQ.translate("Lehre des Lebens"),   isWissen);	
	}

	@Override
	public void specialAction(boolean... action) {
		isWissen = action[0];
	
		refreshen();
	}
}
