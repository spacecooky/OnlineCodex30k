package oc.wh40k.units.bt;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class BTArmoury extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;
	OptionsZaehlerGruppe oz1;
	OptionsZaehlerGruppe oz2;

	boolean isChar = false;
	boolean isTerminator = false;
	boolean hasTermiHonours = false;
	boolean terminatorPreselected = false;

//	boolean IronHaloSelected = false;
//	boolean AdamantineSelected = false;
	boolean UnikateSelected = false;

	int maxCosts = 0;

	public BTArmoury() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		isChar = defaults[0];
		isTerminator = defaults[1];
		hasTermiHonours = defaults[2];
		terminatorPreselected = isTerminator;

		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 1));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe", 1));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", ( isChar ? 25 : 15 ), 30));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", ( isChar ? 25 : 15 ) ));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", ( terminatorPreselected ? 0 : ( isChar ? 15 : 10 ) ) ));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust", 30));
		add(oz1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));
		setHeadline(oz1, "Einhandwaffen");

		if(terminatorPreselected) oz1.setAnzahl(5, 1);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolter", 1));
		ogE.addElement(new OptionsGruppeEintrag("Kombimelter", ( isChar ? 15 : 10 )));
		ogE.addElement(new OptionsGruppeEintrag("Kombiplasmawerfer", ( isChar ? 15 : 10 )));
		ogE.addElement(new OptionsGruppeEintrag("Kombiflammenwerfer", ( isChar ? 10 : 5 )));
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", ( terminatorPreselected ? 0 : 5 ) ));
		add(oz2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));
		setHeadline(oz2, "Zweihandwaffen");
		
		if(terminatorPreselected) oz2.setAnzahl(4, 1);

		cnt = randAbstand;

		ogE.addElement(new OptionsGruppeEintrag("Auspex", 2));
		ogE.addElement(new OptionsGruppeEintrag("Bionics", 5));
		ogE.addElement(new OptionsGruppeEintrag("Teleport-Peilsender", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafte Waffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Terminatorrüstung", 25));
		ogE.addElement(new OptionsGruppeEintrag("Crux Terminatus", 15));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafte Rüstung", 20));
		ogE.addElement(new OptionsGruppeEintrag("Sprungmodul", 20));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine Bike", 30));
		ogE.addElement(new OptionsGruppeEintrag("Fragmentgranaten", 1));
		ogE.addElement(new OptionsGruppeEintrag("Sprenggranaten", 2));
		ogE.addElement(new OptionsGruppeEintrag("Melterbomben", 5));
		ogE.addElement(new OptionsGruppeEintrag("Parierschild", ( isChar ? 10 : 5 )));
		ogE.addElement(new OptionsGruppeEintrag("Heiliges Licht von Antioch", 10));
		ogE.addElement(new OptionsGruppeEintrag("Stählerner Stern", 25));
		ogE.addElement(new OptionsGruppeEintrag("Adamantumhang", 35));
		add(o1 = new OptionsUpgradeGruppe(0, randAbstand + 280, cnt, "", ogE, 100));
		setHeadline(o1, "Ausrüstung");

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(!terminatorPreselected) isTerminator = o1.isSelected("Terminatorrüstung");

		o1.setAktiv("Meisterhafte Rüstung", !isTerminator);
		o1.setAktiv("Fragmentgranaten", !isTerminator);
		o1.setAktiv("Sprenggranaten", !isTerminator);
		o1.setAktiv("Melterbomben", !isTerminator);
		o1.setAktiv("Cenobyte Servitor", !isTerminator);
		o1.setAktiv("Parierschild", !isTerminator);
		o1.setAktiv("Heiliges Licht von Antioch", !isTerminator && isChar);
		o1.setAktiv("Sprungmodul", !isTerminator && isChar);
		o1.setAktiv("Space Marine Bike", !isTerminator && isChar);
		o1.setAktiv("Crux Terminatus", !(hasTermiHonours || isTerminator));
		o1.setAktiv("Terminatorrüstung", isChar);

		oz1.setAktiv("Kettenfaust", isTerminator);

		oz1.setAktiv("Boltpistole", !isTerminator);
		oz1.setAktiv("Nahkampfwaffe", !isTerminator);
		oz1.setAktiv("Plasmapistole", !isTerminator);

		oz2.setAktiv("Bolter", !isTerminator);

		if(o1.getKosten() > 100) {
			showErrorMessage("Maximal 100 Punkte!");
			setButtonState(false);
		} else {
			hideErrorMessage();
			setButtonState(true);
		}

		oz1.setMaxAnzahl( oz2.isSelected() ? 1 : 2 );
		oz2.setMaxAnzahl( oz1.getAnzahl() == 2 ? 0 : 1 );

//		// Unique entry: Stählerner Stern
//		boolean IronHaloGlobal = (BuildaHQ.getCountFromInformationVector("BTStählernerStern") > 0 ? true : false );
//		if(IronHaloGlobal && !IronHaloSelected) o1.setAktiv("Stählerner Stern", false);
//		else o1.setAktiv("Stählerner Stern", !isTerminator);

//		if(o1.isSelected("Stählerner Stern")) {
//			IronHaloSelected = true;
//			BuildaHQ.setInformationVectorValue("BTStählernerStern", 1);
//		} else {
//			if(IronHaloSelected) {
//				IronHaloSelected = false;
//				BuildaHQ.setInformationVectorValue("BTStählernerStern", 0);
//			}
//		}
//
//		// Unique entry: Adamantumhang
//		boolean AdamantineGlobal = (BuildaHQ.getCountFromInformationVector("BTAdamantumhang") > 0 ? true : false );
//		if(AdamantineGlobal && !AdamantineSelected) o1.setAktiv("Adamantumhang", false);
//		else o1.setAktiv("Adamantumhang", true);
//
//		if(o1.isSelected("Adamantumhang")) {
//			AdamantineSelected = true;
//			BuildaHQ.setInformationVectorValue("BTAdamantumhang", 1);
//		} else {
//			if(AdamantineSelected) {
//				AdamantineSelected = false;
//				BuildaHQ.setInformationVectorValue("BTAdamantumhang", 0);
//			}
//		}

		// Unique entry: Unikate
		boolean UnikateGlobal = (BuildaHQ.getCountFromInformationVector("BTUnikate") > 0 ? true : false );
		if(UnikateGlobal && !UnikateSelected) {
			o1.setAktiv("Adamantumhang", false);
			o1.setAktiv("Stählerner Stern", false);
		} else {
			o1.setAktiv("Adamantumhang", true);
			o1.setAktiv("Stählerner Stern", !isTerminator);
		} 

		if(o1.isSelected("Adamantumhang") || o1.isSelected("Stählerner Stern")) {
			UnikateSelected = true;
			BuildaHQ.setInformationVectorValue("BTUnikate", 1);
		} else {
			if(UnikateSelected) {
				UnikateSelected = false;
				BuildaHQ.setInformationVectorValue("BTUnikate", 0);
			}
		}
	}

	@ Override
	public void deleteYourself() {
//		if(IronHaloSelected) BuildaHQ.setInformationVectorValue("BTStählernerStern", 0);
//		if(AdamantineSelected) BuildaHQ.setInformationVectorValue("BTAdamantumhang", 0);
		if(UnikateSelected) BuildaHQ.setInformationVectorValue("BTUnikate", 0);

		super.deleteYourself();
	}

}
