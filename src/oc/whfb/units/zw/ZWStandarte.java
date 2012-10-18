package oc.whfb.units.zw;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ZWStandarte extends RuestkammerVater {

	OptionsZaehlerGruppe oz1;
	OptionsZaehlerGruppe oz2;

	boolean isAST = false;
	boolean ValayaSelected = false;
	boolean StromniSelected = false;
	boolean AngstSelected = false;
	boolean GrungniSelected = false;

	int maxCosts = 0;
	double totalCosts = 0;

	public ZWStandarte() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		isAST = defaults[0];

		if(!isAST) maxCosts = 50;
		if(isAST) maxCosts = 210;

		if(maxCosts >=100) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Valayas Meisterrune"), BuildaHQ.translate("Meisterrune der Valaya"), 100));
		if(maxCosts >=100) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stromnis Meisterrune"), BuildaHQ.translate("Stromni Rotbarts Meisterrune"), 100));
		if(maxCosts >=75) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Meisterrune der Angst"), 75));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Grungnis Meisterrune"), 50));
		add(oz2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));

		if(maxCosts >=55) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Marschrune"), 55));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Langsamkeitsrune"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mutrune"), 30));
		if(isAST) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Wächterrune"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kampfrune"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Unbeirrbarkeitsrune"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Entschlossenheitsrune"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Arkane Schutzrune"), BuildaHQ.translate("Rune des arkanen Schutzes"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rune der Vorfahren"), 10));
		add(oz1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 3));

		seperator();
		setUeberschrift(BuildaHQ.translate("Standarten Runen"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		oz1.setMaxAnzahl(oz2.isSelected() ? 2 : 3);
		oz2.setMaxAnzahl(oz1.getAnzahl() >= 3 ? 0 : 1);

		totalCosts = oz1.getKosten() + oz2.getKosten();

		if(isAST) {
			if(totalCosts > maxCosts) {
				showErrorMessage("Max. " + maxCosts + " "+ BuildaHQ.translate("Punkte"));
				setButtonState(false);
			} else {
				hideErrorMessage();
				setButtonState(true);
			}
		}
		else {
			if(totalCosts > maxCosts) {
				showErrorMessage("Max. " + maxCosts + " "+ BuildaHQ.translate("Punkte"));
				setButtonState(false);
		}	else {
				showErrorMessage("");
				setButtonState(true);
			}
		}


		// Unique entry: Meisterrune der Valaya
		boolean ValayaGlobal = ( BuildaHQ.getCountFromInformationVector("ZWValaya") > 0 ? true : false );
		if(ValayaGlobal && !ValayaSelected) oz2.setAktiv(BuildaHQ.translate("Meisterrune der Valaya"), false);
		else oz2.setAktiv(BuildaHQ.translate("Meisterrune der Valaya"), true);

		if(oz2.isSelected(BuildaHQ.translate("Meisterrune der Valaya"))) {
			ValayaSelected = true;
			BuildaHQ.setInformationVectorValue("ZWValaya", 1);
		} else {
			if(ValayaSelected) {
				ValayaSelected = false;
				BuildaHQ.setInformationVectorValue("ZWValaya", 0);
			}
		}

		// Unique entry: Stromni Rotbarts Meisterrune
		boolean StromniGlobal = ( BuildaHQ.getCountFromInformationVector("ZWStromni") > 0 ? true : false );
		if(StromniGlobal && !StromniSelected) oz2.setAktiv(BuildaHQ.translate("Stromni Rotbarts Meisterrune"), false);
		else oz2.setAktiv(BuildaHQ.translate("Stromni Rotbarts Meisterrune"), true);

		if(oz2.isSelected(BuildaHQ.translate("Stromni Rotbarts Meisterrune"))) {
			StromniSelected = true;
			BuildaHQ.setInformationVectorValue("ZWStromni", 1);
		} else {
			if(StromniSelected) {
				StromniSelected = false;
				BuildaHQ.setInformationVectorValue("ZWStromni", 0);
			}
		}

		// Unique entry: Meisterrune der Angst
		boolean AngstGlobal = ( BuildaHQ.getCountFromInformationVector("ZWAngst") > 0 ? true : false );
		if(AngstGlobal && !AngstSelected) oz2.setAktiv(BuildaHQ.translate("Meisterrune der Angst"), false);
		else oz2.setAktiv(BuildaHQ.translate("Meisterrune der Angst"), true);

		if(oz2.isSelected(BuildaHQ.translate("Meisterrune der Angst"))) {
			AngstSelected = true;
			BuildaHQ.setInformationVectorValue("ZWAngst", 1);
		} else {
			if(AngstSelected) {
				AngstSelected = false;
				BuildaHQ.setInformationVectorValue("ZWAngst", 0);
			}
		}

		// Unique entry: Grungnis Meisterrune
		boolean GrungniGlobal = ( BuildaHQ.getCountFromInformationVector("ZWGrungni") > 0 ? true : false );
		if(GrungniGlobal && !GrungniSelected) oz2.setAktiv(BuildaHQ.translate("Grungnis Meisterrune"), false);
		else oz2.setAktiv(BuildaHQ.translate("Grungnis Meisterrune"), true);

		if(oz2.isSelected(BuildaHQ.translate("Grungnis Meisterrune"))) {
			GrungniSelected = true;
			BuildaHQ.setInformationVectorValue("ZWGrungni", 1);
		} else {
			if(GrungniSelected) {
				GrungniSelected = false;
				BuildaHQ.setInformationVectorValue("ZWGrungni", 0);
			}
		}
		
		BuildaHQ.refreshEntries(2);
		BuildaHQ.refreshEntries(3);
		BuildaHQ.refreshEntries(4);
	}

	public void deleteYourself() {
		if(ValayaSelected) BuildaHQ.setInformationVectorValue("ZWValaya", 0);
		if(StromniSelected) BuildaHQ.setInformationVectorValue("ZWStromni", 0);
		if(AngstSelected) BuildaHQ.setInformationVectorValue("ZWAngst", 0);
		if(GrungniSelected) BuildaHQ.setInformationVectorValue("ZWGrungni", 0);
	}
	
}
