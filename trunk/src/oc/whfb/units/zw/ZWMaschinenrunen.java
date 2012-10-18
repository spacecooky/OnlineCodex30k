package oc.whfb.units.zw;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ZWMaschinenrunen extends RuestkammerVater {

	OptionsZaehlerGruppe oz1;
	OptionsZaehlerGruppe oz2;

	boolean isKanone = false;
	boolean isSpeer = false;
	boolean isGroll = false;
	
	boolean VerteidigungSelected = false;
	boolean TarnungSelected = false;
	boolean OpferungSelected = false;
	boolean TreffsicherheitSelected = false;
	
	
	int maxCosts = 0;

	public ZWMaschinenrunen() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		isKanone = defaults[0];
		isSpeer = defaults[1];
		isGroll = defaults[2];

		maxCosts = 300;

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("MR der Verteidigung"), BuildaHQ.translate("Meisterrune der Verteidigung"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("MR der Tarnung"), BuildaHQ.translate("Meisterrune der Tarnung"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("MR der Opferung"), BuildaHQ.translate("Meisterrune der Opferung"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("MR der Treffsicherh."), BuildaHQ.translate("Meisterrune der Treffsicherheit"), 30));
		add(oz2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schmiederune"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Genauigkeitsrune"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Funktionsrune"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Durchschlagsrune"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tapferkeitsrune"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rune der Standhaftigkeit"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Flakksons Zielsuchrune"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Laderune"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Brandrune"), 5));
		add(oz1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 3));
		setUeberschrift(BuildaHQ.translate("Maschinenrunen"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		oz1.setMaxAnzahl(oz2.isSelected() ? 2 : 3);
		oz2.setMaxAnzahl(oz1.getAnzahl() >= 3 ? 0 : 1);

		oz1.setAktiv(BuildaHQ.translate("Schmiederune"), isKanone);
		oz1.setAktiv(BuildaHQ.translate("Genauigkeitsrune"), isGroll);
		oz1.setAktiv(BuildaHQ.translate("Flakkons Zielsuchrune"), isSpeer);

		double totalCosts = oz1.getKosten() + oz2.getKosten();
		if (totalCosts > maxCosts) {
			showErrorMessage("Max. " + maxCosts + " "+BuildaHQ.translate("Punkte"));
			setButtonState(false);
		} else {
			hideErrorMessage();
			setButtonState(true);
		}
		
		
		// Unique entry: Meisterrune der Verteidigung				
		boolean VerteidigungGlobal = ( BuildaHQ.getCountFromInformationVector("ZWVerteidigung") > 0 ? true : false );		
		if(VerteidigungGlobal && !VerteidigungSelected) oz2.setAktiv("Meisterrune der Verteidigung", false);		
		else oz2.setAktiv("Meisterrune der Verteidigung", true);		
				
		if(oz2.isSelected("Meisterrune der Verteidigung")) {		
			VerteidigungSelected = true;	
			BuildaHQ.setInformationVectorValue("ZWVerteidigung", 1);	
		} else {		
			if(VerteidigungSelected) {	
				VerteidigungSelected = false;
				BuildaHQ.setInformationVectorValue("ZWVerteidigung", 0);
			}	
		}		
		
		// Unique entry: Meisterrune der Tarnung				
		boolean TarnungGlobal = ( BuildaHQ.getCountFromInformationVector("ZWTarnung") > 0 ? true : false );		
		if(TarnungGlobal && !TarnungSelected) oz2.setAktiv(BuildaHQ.translate("Meisterrune der Tarnung"), false);		
		else oz2.setAktiv(BuildaHQ.translate("Meisterrune der Tarnung"), true);		
				
		if(oz2.isSelected(BuildaHQ.translate("Meisterrune der Tarnung"))) {		
			TarnungSelected = true;	
			BuildaHQ.setInformationVectorValue("ZWTarnung", 1);	
		} else {		
			if(TarnungSelected) {	
				TarnungSelected = false;
				BuildaHQ.setInformationVectorValue("ZWTarnung", 0);
			}	
		}		

		// Unique entry: Meisterrune der Opferung				
		boolean OpferungGlobal = ( BuildaHQ.getCountFromInformationVector("ZWOpferung") > 0 ? true : false );		
		if(OpferungGlobal && !OpferungSelected) oz2.setAktiv(BuildaHQ.translate("Meisterrune der Opferung"), false);		
		else oz2.setAktiv(BuildaHQ.translate("Meisterrune der Opferung"), true);		
				
		if(oz2.isSelected(BuildaHQ.translate("Meisterrune der Opferung"))) {		
			OpferungSelected = true;	
			BuildaHQ.setInformationVectorValue("ZWOpferung", 1);	
		} else {		
			if(OpferungSelected) {	
				OpferungSelected = false;
				BuildaHQ.setInformationVectorValue("ZWOpferung", 0);
			}	
		}		

		// Unique entry: Meisterrune der Treffsicherheit				
		boolean TreffsicherheitGlobal = ( BuildaHQ.getCountFromInformationVector("ZWTreffsicherheit") > 0 ? true : false );		
		if(TreffsicherheitGlobal && !TreffsicherheitSelected) oz2.setAktiv(BuildaHQ.translate("Meisterrune der Treffsicherheit"), false);		
		else oz2.setAktiv(BuildaHQ.translate("Meisterrune der Treffsicherheit"), isSpeer);
				
		if(oz2.isSelected(BuildaHQ.translate("Meisterrune der Treffsicherheit"))) {		
			TreffsicherheitSelected = true;	
			BuildaHQ.setInformationVectorValue("ZWTreffsicherheit", 1);	
		} else {		
			if(TreffsicherheitSelected) {	
				TreffsicherheitSelected = false;
				BuildaHQ.setInformationVectorValue("ZWTreffsicherheit", 0);
			}	
		}		

		BuildaHQ.refreshEntries(4);

	}
	
	public void deleteYourself() {
		if(VerteidigungSelected) BuildaHQ.setInformationVectorValue("ZWVerteidigung", 0);
		if(TarnungSelected) BuildaHQ.setInformationVectorValue("ZWTarnung", 0);
		if(OpferungSelected) BuildaHQ.setInformationVectorValue("ZWOpferung", 0);
		if(TreffsicherheitSelected) BuildaHQ.setInformationVectorValue("ZWTreffsicherheit", 0);
		
	}

}
