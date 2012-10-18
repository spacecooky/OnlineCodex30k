package oc.whfb.units.doc;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DOCMagicLores extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	boolean isTzeentch 	= false;
	boolean isNurgle 	= false;
	boolean isSlaanesh 	= false;
	boolean isMaster	= false;
	
	boolean isKairos 	= false;
	boolean isScribes 	= false;
	
	public DOCMagicLores() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {	
		isTzeentch 	= defaults[0];
		isNurgle 	= defaults[1];
		isSlaanesh 	= defaults[2];
		
		if ( isTzeentch ) {
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Tzeentch")));
			
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Schatten")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Todes")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Feuers")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Metalls")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Lichts")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Himmel")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Bestien")));		
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Lebens")));
			
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Alle Magie Lehren")));
			
		} else if ( isNurgle )
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Nurgle")));
		else if ( isSlaanesh )
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Slaanesh")));
		
		if ( !isTzeentch && !isNurgle && !isSlaanesh ){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Schatten")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Todes")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Feuers")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Metalls")));
		}
		
		add(o1 = new OptionsUpgradeGruppe( ID, randAbstand, cnt, "", ogE, false ));
		
		setHeadline(o1, BuildaHQ.translate("Lehren der Magie"));
		setUeberschrift(BuildaHQ.translate("Lehren der Magie"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
		o1.setAktiv(BuildaHQ.translate("Alle Magie Lehren"), isKairos);
		
		if ( isTzeentch && !isKairos ) {
			o1.setAktiv(BuildaHQ.translate("Lehre der Schatten"), isMaster);
			o1.setAktiv(BuildaHQ.translate("Lehre des Todes"),    isMaster);
			o1.setAktiv(BuildaHQ.translate("Lehre des Feuers"),   isMaster);
			o1.setAktiv(BuildaHQ.translate("Lehre des Metalls"),  isMaster);
			o1.setAktiv(BuildaHQ.translate("Lehre des Lichts"),   isMaster);
			o1.setAktiv(BuildaHQ.translate("Lehre der Himmel"),   isMaster);
			o1.setAktiv(BuildaHQ.translate("Lehre der Bestien"),  isMaster);
			o1.setAktiv(BuildaHQ.translate("Lehre des Lebens"),   isMaster);
		}
		
		if ( isKairos ) {
			o1.setAktiv(BuildaHQ.translate("Lehre des Tzeentch"), !isKairos);
			o1.setAktiv(BuildaHQ.translate("Lehre der Schatten"), !isKairos);
			o1.setAktiv(BuildaHQ.translate("Lehre des Todes"),    !isKairos);
			o1.setAktiv(BuildaHQ.translate("Lehre des Feuers"),   !isKairos);
			o1.setAktiv(BuildaHQ.translate("Lehre des Metalls"),  !isKairos);
			o1.setAktiv(BuildaHQ.translate("Lehre des Lichts"),   !isKairos);
			o1.setAktiv(BuildaHQ.translate("Lehre der Himmel"),   !isKairos);
			o1.setAktiv(BuildaHQ.translate("Lehre der Bestien"),  !isKairos);
			o1.setAktiv(BuildaHQ.translate("Lehre des Lebens"),   !isKairos);
			
			o1.setSelected(BuildaHQ.translate("Alle Magie Lehren"), isKairos);
		}
		
		
	}
	
	@Override
	public void specialAction(boolean... action) {
		isMaster 	= action[0];
		isScribes 	= action[1];
		isKairos 	= action[2];
		
		refreshen();
	}
}
