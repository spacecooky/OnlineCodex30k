package oc.whfb.units.zw;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ZWRunen extends RuestkammerVater {

	OptionsZaehlerGruppe oz1;
	OptionsZaehlerGruppe oz4;
	OptionsZaehlerGruppe oz2;
	OptionsZaehlerGruppe oz5;
	OptionsZaehlerGruppe oz3;
	OptionsZaehlerGruppe oz6;

	boolean isKoenig = false;
	boolean isRune = false;
	boolean isSlayer = false;
	boolean isMaschinist = false;
	boolean isKommandant = false;
	boolean isStandarte = false;

	boolean SkalfSelected = false;
	boolean SchadensruneSelected = false;
	boolean AlaricSelected = false;
	boolean ArtefaktSelected = false;
	boolean FlugSelected = false;
	boolean FlinkSelected = false;
	boolean KraggSelected = false;

	boolean StahlSelected = false;
	boolean AdamantSelected = false;
	boolean GromrilSelected = false;

	boolean BalanceSelected = false;
	boolean MagieerdungSelected = false;
	boolean TrotzSelected = false;
	boolean HerausforderungSelected = false;
	boolean FurchtSelected = false;
	boolean KönigSelected = false;

	int maxCosts = 0;

	public ZWRunen() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		isKoenig = defaults[0];
		isRune = defaults[1];
		isSlayer = defaults[2];
		isMaschinist = defaults[3];
		isStandarte = defaults[4];
		isKommandant = defaults[5];

		if(isRune && isKommandant) maxCosts = 150;
		if(isKoenig && isKommandant) maxCosts = 125;
		if((isKoenig || isRune || isSlayer) && !isKommandant) maxCosts = 75;
		if(isSlayer && isKommandant) maxCosts = 100;
		if(isMaschinist) maxCosts = 50;

		if(maxCosts >=75) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Skalfs Meisterrune"), BuildaHQ.translate("Skalf Schwarzhammers Meisterrune"), 75));
		if(maxCosts >=70) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Meisterrune d. Schadens"), BuildaHQ.translate("Meisterrune des Schadens"), 70));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Alarics Meisterrune"), BuildaHQ.translate("Alaric Wirrkopfs Meisterrune"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Artefaktbrechende MR"), BuildaHQ.translate("Artefaktbrechende Meisterrune"), 45));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Meisterrune d. Flugkraft"), BuildaHQ.translate("Meisterrune der Flugkraft"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Meisterrune d. Flinkheit"), BuildaHQ.translate("Meisterrune der Flinkheit"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Meisterrune von Kragg"), BuildaHQ.translate("Meisterrune von Kragg dem Grimmigen"), 20));
		add(oz4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		setHeadline(oz4, BuildaHQ.translate("Waffenrunen"));

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kraftrune"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Snorris Rune"), BuildaHQ.translate("Snorri Flitterhelms Rune"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Wutrune"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schmetterrune"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Grollrune"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rune der Geschickl."), BuildaHQ.translate("Rune der Geschicklichkeit"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schnelligkeitsrune"), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Feuerrune"), 5));
		add(oz1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
		cnt = randAbstand;

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Meisterr. des Stahls"), BuildaHQ.translate("Meisterrune des Stahls"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Adamant-Meisterrune"), 45));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gromril-Meisterrune"), 25));
		add(oz5 = new OptionsZaehlerGruppe(ID, randAbstand + 260, cnt, "", ogE, 1));
		setHeadline(oz5, BuildaHQ.translate("Rüstungsrunen"));

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ausdauerrune"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Pfeilbannrune"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Panzerrune"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Eisenrune"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("R. d. Unverwundbarkeit"), BuildaHQ.translate("Rune der Unverwundbarkeit"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Steinrune"), 5));
		add(oz2 = new OptionsZaehlerGruppe(ID, randAbstand + 260, cnt, "", ogE, 3));

		cnt = randAbstand;

		if(isKoenig && isKommandant) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Königliche Meisterrune"), 100));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Meisterrune der Balance"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("MR d. Magieerdung"), BuildaHQ.translate("Meisterrune der Magieerdung"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Meisterrune d. Trotzes"), BuildaHQ.translate("Meisterrune des Trotzes"), 45));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("MR d. Herausforderung"), BuildaHQ.translate("Meisterrune der Herausforderung"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Meisterrune d. Furcht"), BuildaHQ.translate("Meisterrune der Furcht"), 25));
		add(oz6 = new OptionsZaehlerGruppe(ID, randAbstand + 520, cnt, "", ogE, 1));
		setHeadline(oz6, BuildaHQ.translate("Talismanrunen"));

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schicksalsrune"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Magievernichtende Rune"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Magiebannende Rune"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rune d. Bruderschaft"), BuildaHQ.translate("Rune der Bruderschaft"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Glücksrune"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zauberschutzrune"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schmiedefeuerrune"), 5));
		add(oz3 = new OptionsZaehlerGruppe(ID, randAbstand + 520, cnt, "", ogE, 3));
		setUeberschrift(BuildaHQ.translate("Runen"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		oz2.setAktiv(!isSlayer);
		oz5.setAktiv(!isSlayer);
		oz3.setAktiv(!isSlayer);
		oz6.setAktiv(!isSlayer);

		oz3.setAktiv(BuildaHQ.translate("Magievernichtende Rune"), isRune);
		oz3.setAktiv(BuildaHQ.translate("Magiebannende Rune"), isRune);

		oz1.setMaxAnzahl(oz4.isSelected() ? 2 : 3 );
		oz2.setMaxAnzahl(oz5.isSelected() ? 2 : 3 );
		oz3.setMaxAnzahl(oz6.isSelected() ? 2 : 3 );

		oz4.setMaxAnzahl(oz1.getAnzahl() == 3 ? 0 : 1);
		oz5.setMaxAnzahl(oz2.getAnzahl() == 3 ? 0 : 1);
		oz6.setMaxAnzahl(oz3.getAnzahl() == 3 ? 0 : 1);

		double totalCosts = oz1.getKosten() + oz2.getKosten() + oz3.getKosten() + oz4.getKosten() + oz5.getKosten() + oz6.getKosten() /*+ oz7.getKosten()*/;
		if(totalCosts > maxCosts) {
			showErrorMessage("Max. " + entferneNullNachkomma(maxCosts) + " " + BuildaHQ.translate("Punkte"));
			setButtonState(false);
		} else {
			showErrorMessage( entferneNullNachkomma(totalCosts) + " / " + maxCosts + " " + BuildaHQ.translate("Punkte"));
			setButtonState(true);
		}

		// Unique entry: Skalf Schwarzhammers Meisterrune
		boolean SkalfGlobal = (BuildaHQ.getCountFromInformationVector("ZWSkalf") > 0 ? true : false );
		if(SkalfGlobal && !SkalfSelected) oz4.setAktiv(BuildaHQ.translate("Skalf Schwarzhammers Meisterrune"), false);
		else oz4.setAktiv(BuildaHQ.translate("Skalf Schwarzhammers Meisterrune"), true);

		if(oz4.isSelected(BuildaHQ.translate("Skalf Schwarzhammers Meisterrune"))) {
			SkalfSelected = true;
			BuildaHQ.setInformationVectorValue("ZWSkalf", 1);
		} else {
			if(SkalfSelected) {
				SkalfSelected = false;
				BuildaHQ.setInformationVectorValue("ZWSkalf", 0);
			}
		}

		// Unique entry: Meisterrune des Schadens
		boolean SchadensruneGlobal = (BuildaHQ.getCountFromInformationVector("ZWSchadensrune") > 0 ? true : false );
		if(SchadensruneGlobal && !SchadensruneSelected) oz4.setAktiv(BuildaHQ.translate("Meisterrune des Schadens"), false);
		else oz4.setAktiv(BuildaHQ.translate("Meisterrune des Schadens"), true);

		if(oz4.isSelected(BuildaHQ.translate("Meisterrune des Schadens"))) {
			SchadensruneSelected = true;
			BuildaHQ.setInformationVectorValue("ZWSchadensrune", 1);
		} else {
			if(SchadensruneSelected) {
				SchadensruneSelected = false;
				BuildaHQ.setInformationVectorValue("ZWSchadensrune", 0);
			}
		}

		// Unique entry: Alaric Wirrkopfs Meisterrune
		boolean AlaricGlobal = (BuildaHQ.getCountFromInformationVector("ZWAlaric") > 0 ? true : false );
		if(AlaricGlobal && !AlaricSelected) oz4.setAktiv(BuildaHQ.translate("Alaric Wirrkopfs Meisterrune"), false);
		else oz4.setAktiv(BuildaHQ.translate("Alaric Wirrkopfs Meisterrune"), true);

		if(oz4.isSelected(BuildaHQ.translate("Alaric Wirrkopfs Meisterrune"))) {
			AlaricSelected = true;
			BuildaHQ.setInformationVectorValue("ZWAlaric", 1);
		} else {
			if(AlaricSelected) {
				AlaricSelected = false;
				BuildaHQ.setInformationVectorValue("ZWAlaric", 0);
			}
		}

		// Unique entry: Artefaktbrechende Meisterrune
		boolean ArtefaktGlobal = (BuildaHQ.getCountFromInformationVector("ZWArtefakt") > 0 ? true : false );
		if(ArtefaktGlobal && !ArtefaktSelected) oz4.setAktiv(BuildaHQ.translate("Artefaktbrechende Meisterrune"), false);
		else oz4.setAktiv(BuildaHQ.translate("Artefaktbrechende Meisterrune"), true);

		if(oz4.isSelected(BuildaHQ.translate("Artefaktbrechende Meisterrune"))) {
			ArtefaktSelected = true;
			BuildaHQ.setInformationVectorValue("ZWArtefakt", 1);
		} else {
			if(ArtefaktSelected) {
				ArtefaktSelected = false;
				BuildaHQ.setInformationVectorValue("ZWArtefakt", 0);
			}
		}

		// Unique entry: Meisterrune der Flugkraft
		boolean FlugGlobal = (BuildaHQ.getCountFromInformationVector("ZWFlug") > 0 ? true : false );
		if(FlugGlobal && !FlugSelected) oz4.setAktiv(BuildaHQ.translate("Meisterrune der Flugkraft"), false);
		else oz4.setAktiv(BuildaHQ.translate("Meisterrune der Flugkraft"), !isSlayer);

		if(oz4.isSelected(BuildaHQ.translate("Meisterrune der Flugkraft"))) {
			FlugSelected = true;
			BuildaHQ.setInformationVectorValue("ZWFlug", 1);
		} else {
			if(FlugSelected) {
				FlugSelected = false;
				BuildaHQ.setInformationVectorValue("ZWFlug", 0);
			}
		}

		// Unique entry: Meisterrune der Flinkheit
		boolean FlinkGlobal = (BuildaHQ.getCountFromInformationVector("ZWFlink") > 0 ? true : false );
		if(FlinkGlobal && !FlinkSelected) oz4.setAktiv(BuildaHQ.translate("Meisterrune der Flinkheit"), false);
		else oz4.setAktiv(BuildaHQ.translate("Meisterrune der Flinkheit"), true);

		if(oz4.isSelected(BuildaHQ.translate("Meisterrune der Flinkheit"))) {
			FlinkSelected = true;
			BuildaHQ.setInformationVectorValue("ZWFlink", 1);
		} else {
			if(FlinkSelected) {
				FlinkSelected = false;
				BuildaHQ.setInformationVectorValue("ZWFlink", 0);
			}
		}

		// Unique entry: Meisterrune von Kragg dem Grimmigen
		boolean KraggGlobal = (BuildaHQ.getCountFromInformationVector("ZWKragg") > 0 ? true : false );
		if(KraggGlobal && !KraggSelected) oz4.setAktiv(BuildaHQ.translate("Meisterrune von Kragg dem Grimmigen"), false);
		else oz4.setAktiv(BuildaHQ.translate("Meisterrune von Kragg dem Grimmigen"), true);

		if(oz4.isSelected(BuildaHQ.translate("Meisterrune von Kragg dem Grimmigen"))) {
			KraggSelected = true;
			BuildaHQ.setInformationVectorValue("ZWKragg", 1);
		} else {
			if(KraggSelected) {
				KraggSelected = false;
				BuildaHQ.setInformationVectorValue("ZWKragg", 0);
			}
		}


		// Unique entry: Meisterrune des Stahls
		boolean StahlGlobal = (BuildaHQ.getCountFromInformationVector("ZWStahl") > 0 ? true : false );
		if(StahlGlobal && !StahlSelected) oz5.setAktiv(BuildaHQ.translate("Meisterrune des Stahls"), false);
		else oz5.setAktiv(BuildaHQ.translate("Meisterrune des Stahls"), !isSlayer);

		if(oz5.isSelected(BuildaHQ.translate("Meisterrune des Stahls"))) {
			StahlSelected = true;
			BuildaHQ.setInformationVectorValue("ZWStahl", 1);
		} else {
			if(StahlSelected) {
				StahlSelected = false;
				BuildaHQ.setInformationVectorValue("ZWStahl", 0);
			}
		}

		// Unique entry: Adamant-Meisterrune
		boolean AdamantGlobal = (BuildaHQ.getCountFromInformationVector("ZWAdamant") > 0 ? true : false );
		if(AdamantGlobal && !AdamantSelected) oz5.setAktiv(BuildaHQ.translate("Adamant-Meisterrune"), false);
		else oz5.setAktiv(BuildaHQ.translate("Adamant-Meisterrune"), !isSlayer);

		if(oz5.isSelected(BuildaHQ.translate("Adamant-Meisterrune"))) {
			AdamantSelected = true;
			BuildaHQ.setInformationVectorValue("ZWAdamant", 1);
		} else {
			if(AdamantSelected) {
				AdamantSelected = false;
				BuildaHQ.setInformationVectorValue("ZWAdamant", 0);
			}
		}

		// Unique entry: Gromril-Meisterrune
		boolean GromrilGlobal = (BuildaHQ.getCountFromInformationVector("ZWGromril") > 0 ? true : false );
		if(GromrilGlobal && !GromrilSelected) oz5.setAktiv(BuildaHQ.translate("Gromril-Meisterrune"), false);
		else oz5.setAktiv(BuildaHQ.translate("Gromril-Meisterrune"), !isSlayer);

		if(oz5.isSelected(BuildaHQ.translate("Gromril-Meisterrune"))) {
			GromrilSelected = true;
			BuildaHQ.setInformationVectorValue("ZWGromril", 1);
		} else {
			if(GromrilSelected) {
				GromrilSelected = false;
				BuildaHQ.setInformationVectorValue("ZWGromril", 0);
			}
		}

		// Unique entry: Meisterrune der Balance
		boolean BalanceGlobal = (BuildaHQ.getCountFromInformationVector("ZWBalance") > 0 ? true : false );
		if(BalanceGlobal && !BalanceSelected) oz6.setAktiv(BuildaHQ.translate("Meisterrune der Balance"), false);
		else oz6.setAktiv(BuildaHQ.translate("Meisterrune der Balance"), isRune);

		if(oz6.isSelected(BuildaHQ.translate("Meisterrune der Balance"))) {
			BalanceSelected = true;
			BuildaHQ.setInformationVectorValue("ZWBalance", 1);
		} else {
			if(BalanceSelected) {
				BalanceSelected = false;
				BuildaHQ.setInformationVectorValue("ZWBalance", 0);
			}
		}

		// Unique entry: Meisterrune der Magieerdung
		boolean MagieerdungGlobal = (BuildaHQ.getCountFromInformationVector("ZWMagieerdung") > 0 ? true : false );
		if(MagieerdungGlobal && !MagieerdungSelected) oz6.setAktiv(BuildaHQ.translate("Meisterrune der Magieerdung"), false);
		else oz6.setAktiv(BuildaHQ.translate("Meisterrune der Magieerdung"), isRune);

		if(oz6.isSelected(BuildaHQ.translate("Meisterrune der Magieerdung"))) {
			MagieerdungSelected = true;
			BuildaHQ.setInformationVectorValue("ZWMagieerdung", 1);
		} else {
			if(MagieerdungSelected) {
				MagieerdungSelected = false;
				BuildaHQ.setInformationVectorValue("ZWMagieerdung", 0);
			}
		}

		// Unique entry: Meisterrune des Trotzes
		boolean TrotzGlobal = (BuildaHQ.getCountFromInformationVector("ZWTrotz") > 0 ? true : false );
		if(TrotzGlobal && !TrotzSelected) oz6.setAktiv(BuildaHQ.translate("Meisterrune des Trotzes"), false);
		else oz6.setAktiv(BuildaHQ.translate("Meisterrune des Trotzes"), !isSlayer);

		if(oz6.isSelected(BuildaHQ.translate("Meisterrune des Trotzes"))) {
			TrotzSelected = true;
			BuildaHQ.setInformationVectorValue("ZWTrotz", 1);
		} else {
			if(TrotzSelected) {
				TrotzSelected = false;
				BuildaHQ.setInformationVectorValue("ZWTrotz", 0);
			}
		}

		// Unique entry: Meisterrune der Herausforderung
		boolean HerausforderungGlobal = (BuildaHQ.getCountFromInformationVector("ZWHerausforderung") > 0 ? true : false );
		if(HerausforderungGlobal && !HerausforderungSelected) oz6.setAktiv(BuildaHQ.translate("Meisterrune der Herausforderung"), false);
		else oz4.setAktiv(BuildaHQ.translate("Meisterrune der Herausforderung"), !isSlayer);

		if(oz4.isSelected(BuildaHQ.translate("Meisterrune der Herausforderung"))) {
			HerausforderungSelected = true;
			BuildaHQ.setInformationVectorValue("ZWHerausforderung", 1);
		} else {
			if(HerausforderungSelected) {
				HerausforderungSelected = false;
				BuildaHQ.setInformationVectorValue("ZWHerausforderung", 0);
			}
		}

		// Unique entry: Meisterrune der Furcht
		boolean FurchtGlobal = (BuildaHQ.getCountFromInformationVector("ZWFurcht") > 0 ? true : false );
		if(FurchtGlobal && !FurchtSelected) oz6.setAktiv(BuildaHQ.translate("Meisterrune der Furcht"), false);
		else oz6.setAktiv(BuildaHQ.translate("Meisterrune der Furcht"), !isSlayer);

		if(oz6.isSelected(BuildaHQ.translate("Meisterrune der Furcht"))) {
			FurchtSelected = true;
			BuildaHQ.setInformationVectorValue("ZWFurcht", 1);
		} else {
			if(FurchtSelected) {
				FurchtSelected = false;
				BuildaHQ.setInformationVectorValue("ZWFurcht", 0);
			}
		}

		// Unique entry: Königliche Meisterrune
		boolean KönigGlobal = (BuildaHQ.getCountFromInformationVector("ZWKönig") > 0 ? true : false );
		if(KönigGlobal && !KönigSelected) oz6.setAktiv(BuildaHQ.translate("Königliche Meisterrune"), false);
		else oz6.setAktiv(BuildaHQ.translate("Königliche Meisterrune"), true);

		if(oz6.isSelected(BuildaHQ.translate("Königliche Meisterrune"))) {
			KönigSelected = true;
			BuildaHQ.setInformationVectorValue("ZWKönig", 1);
		} else {
			if(KönigSelected) {
				KönigSelected = false;
				BuildaHQ.setInformationVectorValue("ZWKönig", 0);
			}
		}

		BuildaHQ.refreshEntries(1);
		BuildaHQ.refreshEntries(2);
	}

	@Override
	public void deleteYourself() {
		if(SkalfSelected) BuildaHQ.setInformationVectorValue("ZWSkalf", 0);
		if(AlaricSelected) BuildaHQ.setInformationVectorValue("ZWAlaric", 0);
		if(SchadensruneSelected) BuildaHQ.setInformationVectorValue("ZWSchadensrune", 0);
		if(ArtefaktSelected) BuildaHQ.setInformationVectorValue("ZWArtefakt", 0);
		if(FlugSelected) BuildaHQ.setInformationVectorValue("ZWFlug", 0);
		if(FlinkSelected) BuildaHQ.setInformationVectorValue("ZWFlink", 0);
		if(KraggSelected) BuildaHQ.setInformationVectorValue("ZWKragg", 0);

		if(StahlSelected) BuildaHQ.setInformationVectorValue("ZWStahl", 0);
		if(AdamantSelected) BuildaHQ.setInformationVectorValue("ZWAdamant", 0);
		if(GromrilSelected) BuildaHQ.setInformationVectorValue("ZWGromril", 0);

		if(BalanceSelected) BuildaHQ.setInformationVectorValue("ZWBalance", 0);
		if(MagieerdungSelected) BuildaHQ.setInformationVectorValue("ZWMagieerdung", 0);
		if(TrotzSelected) BuildaHQ.setInformationVectorValue("ZWTrotz", 0);
		if(HerausforderungSelected) BuildaHQ.setInformationVectorValue("ZWHerausforderung", 0);
		if(FurchtSelected) BuildaHQ.setInformationVectorValue("ZWFurcht", 0);
		if(KönigSelected) BuildaHQ.setInformationVectorValue("ZWKönig", 0);

		super.deleteYourself();
	}

}
