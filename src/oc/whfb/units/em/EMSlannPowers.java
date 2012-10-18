package oc.whfb.units.em;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class EMSlannPowers extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;
	OptionsUpgradeGruppe o5;
	OptionsUpgradeGruppe o6;
	OptionsUpgradeGruppe o7;
	OptionsUpgradeGruppe o8;
	OptionsUpgradeGruppe freePower = null;

	public EMSlannPowers() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Meister der Mysterien"), 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hohe Konzentration"), 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tranzendente Heilung"), 0));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Durchdringender Blick"), 0));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Höhere Bewußtseinsebene"), 0));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Besänftigender Geist"), 0));
		add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Unergründliche Präsenz"), 0));
		add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Seele aus Stein"), 0));
		add(o8 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Disziplinen der Alten"));
		sizeSetzen();
	}

	private void setCosts(OptionsUpgradeGruppe[] powers, OptionsUpgradeGruppe freePower){
		if(freePower == null){
			for (int i = 0; i < powers.length; i++) {
				powers[i].setPreis(0,0);
			}
		}else{
			
			for (int i = 0; i < powers.length; i++) {
				if(powers[i] == freePower){
					powers[i].setPreis(0, 0);
				}
				else{
					powers[i].setPreis(0, 50);				
				}
			}
		}	
	}
	
	@Override
	public void refreshen() {

		OptionsUpgradeGruppe[] powers = {o1, o2, o3, o4, o5, o6, o7, o8};
		
		boolean freePowerExists = false;
		if(freePower != null){
			if(freePower.isSelected()){
				freePowerExists = true;
			}else{
				for (int i = 0; i < powers.length; i++) {
					if(powers[i].isSelected()){
						freePower = powers[i];
						freePowerExists = true;
					}
				}
			}			
		}else{
			for (int i = 0; i < powers.length; i++) {
				if(powers[i].isSelected()){
					freePower = powers[i];
					freePowerExists = true;
				}
			}			
		}
		
		if(freePowerExists){
			setCosts(powers, freePower);
		}else{
			setCosts(powers, null);
		}
		
		int i = 0;
		for (int j = 0; j < powers.length; j++) {
			if(powers[j].isSelected()) i++;
		}
		
		
		if(i > 4) {
			setButtonState(false);
			showErrorMessage(BuildaHQ.translate("Nur vier Kräfte sind erlaubt."));
		} else {
			setButtonState(true);
			hideErrorMessage();
		}		
	}
}
