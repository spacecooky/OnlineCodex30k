package oc.whfb.units.og;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class OGMagicLores extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	boolean isFleischermeister = false;
	boolean isFleischer = false;
	boolean isFeuerbauch = false;
	boolean schlundSelected = false;
	
	public OGMagicLores() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {	
		
		isFleischermeister = defaults[0];
		isFleischer = defaults[1];
		isFeuerbauch = defaults[2];
		
		if (isFleischer || isFleischermeister){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des groﬂen Schlunds")));
			
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Bestien")));		
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Himmels")));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Todes")));
		} else if (isFeuerbauch) {
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Feuers")));	
		}

		add(o1 = new OptionsUpgradeGruppe( ID, randAbstand, cnt, "", ogE, false ));
		
		setHeadline(o1, BuildaHQ.translate("Lehren der Magie"));
		setUeberschrift(BuildaHQ.translate("Lehren der Magie"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
		
		if(o1.isSelected(BuildaHQ.translate("Lehre des groﬂen Schlunds"))) {
			if (!schlundSelected)BuildaHQ.addToInformationVector(BuildaHQ.translate("Lehre des groﬂen Schlunds"), 1);
			schlundSelected = true;
		} else {
			if(schlundSelected) {
				BuildaHQ.addToInformationVector(BuildaHQ.translate("Lehre des groﬂen Schlunds"), -1);		
			}
			schlundSelected = false;
		}
		
		if( BuildaHQ.getCountFromInformationVector(BuildaHQ.translate("Lehre des groﬂen Schlunds")) < 1 || BuildaHQ.getCountFromInformationVector(BuildaHQ.translate("Fleischer")) < 2 ){
			o1.setAktiv(BuildaHQ.translate("Lehre der Bestien"), false);
			o1.setAktiv(BuildaHQ.translate("Lehre des Himmels"), false);
			o1.setAktiv(BuildaHQ.translate("Lehre des Todes"), false);
		} else if ( o1.isSelected(BuildaHQ.translate("Lehre des groﬂen Schlunds")) && BuildaHQ.getCountFromInformationVector(BuildaHQ.translate("Lehre des groﬂen Schlunds")) == 1){
			o1.setAktiv(BuildaHQ.translate("Lehre der Bestien"), false);
			o1.setAktiv(BuildaHQ.translate("Lehre des Himmels"), false);
			o1.setAktiv(BuildaHQ.translate("Lehre des Todes"), false);
		} else {
			o1.setAktiv(BuildaHQ.translate("Lehre der Bestien"), true);
			o1.setAktiv(BuildaHQ.translate("Lehre des Himmels"), true);
			o1.setAktiv(BuildaHQ.translate("Lehre des Todes"), true);
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		
		if(schlundSelected) {
			BuildaHQ.addToInformationVector(BuildaHQ.translate("Lehre des groﬂen Schlunds"), -1);		
		}
	}	
	
	
}
