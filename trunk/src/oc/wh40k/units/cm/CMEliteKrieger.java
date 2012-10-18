package oc.wh40k.units.cm;

import oc.BuildaHQ;
import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class CMEliteKrieger extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
	OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
	OptionsEinzelUpgrade plasmapistole;
	OptionsUpgradeGruppe mal;
	OptionsUpgradeGruppe ikone;
	OptionsUpgradeGruppe vdlk;
	OptionsUpgradeGruppe o7;
	OptionsUpgradeGruppe o8;
    RuestkammerStarter champion;
    RuestkammerStarter chaosTransport;
    OptionsZaehlerGruppe nahkampfwaffe1;
    OptionsZaehlerGruppe nahkampfwaffe2;
    boolean spezialAuswahl = false;
    
	public CMEliteKrieger() {
		//name = "Elite-Krieger\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Elite-Krieger", 5, 15, 13);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe", "Nahkampfwaffe", 2));
		add(nahkampfwaffe1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe", "Nahkampfwaffe", 0));
		add(nahkampfwaffe2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 2));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 2));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 3));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 2));
		add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
	
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Zorns", 20));
		ogE.addElement(new OptionsGruppeEintrag("Ikone der Flammen", 15));
		ogE.addElement(new OptionsGruppeEintrag("Ikone der Verzweiflung", 10));
		ogE.addElement(new OptionsGruppeEintrag("Ikone der Ausschweifung", 30));
		ogE.addElement(new OptionsGruppeEintrag("Ikone der Vergeltung", 25));
		add(ikone = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		add(plasmapistole = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Plasmapistole", "1 x Plasmapistole", 15));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 20));
		add(o8 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Veteranen des Langen Krieges", 1));
		add(vdlk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		champion = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Aufstrebender Champion");
		champion.initKammer();
		champion.setUeberschriftTrotzNullKostenAusgeben(true);
		add(champion);
		champion.setAbwaehlbar(false);
		
		seperator(5);
		
		chaosTransport = new RuestkammerStarter(ID, randAbstand, cnt, "CMTransporter", "Transporter");
		chaosTransport.initKammer(true, false);
		chaosTransport.setButtonText("Transporter");
		add(chaosTransport);
		
		complete();
	}
	
	@Override
	public void deleteYourself() {
		if ( spezialAuswahl){
			BuildaHQ.addToInformationVector("CMEliteKrieger", -1);
		}
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
		
		int count = squad.getModelle();
		mal.setPreis("Mal des Khorne", 2 * count);
		mal.setPreis("Mal des Tzeentch", 2 * count);
		mal.setPreis("Mal des Nurgle", 3 * count);
		mal.setPreis("Mal des Slaanesh", 2 * count);
		
		vdlk.setPreis("Veteranen des Langen Krieges", 1 * count);
		
        if(!champion.isSelected()) champion.setSelected(true);

		o8.setAktiv(squad.getModelle() > 9);
		
		if(mal.isSelected("Mal des Khorne")) {
			ikone.setAktiv("Ikone des Zorns", true);
		} else {
			ikone.setAktiv("Ikone des Zorns", false);
		}
		
		if(mal.isSelected("Mal des Tzeentch")) {
			ikone.setAktiv("Ikone der Flammen", true);
		} else {
			ikone.setAktiv("Ikone der Flammen", false);
		}
		
		if(mal.isSelected("Mal des Nurgle")) {
			ikone.setAktiv("Ikone der Verzweiflung", true);
		} else {
			ikone.setAktiv("Ikone der Verzweiflung", false);
		}
		
		if(mal.isSelected("Mal des Slaanesh")) {
			ikone.setAktiv("Ikone der Ausschweifung", true);
		} else {
			ikone.setAktiv("Ikone der Ausschweifung", false);
		}
		
		int subtractor = 1; // boss
		if(o7.isSelected()) { subtractor++; }
		if(o8.isSelected()) { subtractor++; }
		
		nahkampfwaffe1.setMaxAnzahl(squad.getModelle() - 1);
		nahkampfwaffe2.setMaxAnzahl(squad.getModelle() - subtractor);
		
		// Kein Bolter mehr zum eintauschen
		if(nahkampfwaffe2.getAnzahl() == (squad.getModelle() - 1)) { 
			o7.setAktiv(false);
			o8.setAktiv(false);
		}
		
		// Kein Bolter mehr zum eintauschen
		if(nahkampfwaffe2.getAnzahl() == (squad.getModelle() - 2)) {
			o8.setAktiv(false);
		}
		
		if(plasmapistole.isSelected()) {
			o7.setAktiv(false);
		} 
		
		if(!plasmapistole.isSelected() && nahkampfwaffe2.getAnzahl() != (squad.getModelle() - 1)) {
			o7.setAktiv(true);
		}

		if ( !spezialAuswahl && kategorie == 3){
			spezialAuswahl=true;
			BuildaHQ.addToInformationVector("CMEliteKrieger", 1);
			RefreshListener.fireRefresh();
		}
		
		int maxEliteKrieger = BuildaHQ.getCountFromInformationVector("CMFabiusGallus");

		if(BuildaHQ.getCountFromInformationVector("CMEliteKrieger") > maxEliteKrieger && kategorie == 3) {
			setFehlermeldung("Max. " + maxEliteKrieger + " Elite-Krieger");
		} else {
			setFehlermeldung("");
		}
	}
}
