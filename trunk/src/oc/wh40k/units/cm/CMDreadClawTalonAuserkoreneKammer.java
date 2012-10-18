package oc.wh40k.units.cm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class CMDreadClawTalonAuserkoreneKammer extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
	OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
	OptionsEinzelUpgrade plasmapistole;
	OptionsUpgradeGruppe mal;
	OptionsUpgradeGruppe ikone;
	OptionsUpgradeGruppe vdlk;
	OptionsZaehlerGruppe o7a;
	OptionsZaehlerGruppe o7aStart;
	OptionsZaehlerGruppe o7b;
	OptionsZaehlerGruppe o7bStart;
	OptionsZaehlerGruppe o7c;
	OptionsZaehlerGruppe o7d;
	OptionsZaehlerGruppe o7dStart;
	OptionsUpgradeGruppe o8;
    RuestkammerStarter champion;
    
	public CMDreadClawTalonAuserkoreneKammer() {}
	
	
	public void initButtons(boolean... defaults) {
		//name = "Auserkorene Chaos Space Marines\n";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Auserkorene", 5, 10, 18);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));	
		
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
		ogE.addElement(new OptionsGruppeEintrag("Ikone der Ausschweifung", 35));
		ogE.addElement(new OptionsGruppeEintrag("Ikone der Vergeltung", 25));
		add(ikone = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Veteranen", "Veteranen des Langen Krieges", 2));
		add(vdlk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
		add(o7aStart = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		add(o7a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));
		
		ogE.addElement(new OptionsGruppeEintrag("Handwaffe", 0));
		add(o7bStart = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiewaffe"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieschwert"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energieaxt"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energielanze"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Energiestreitkolben"), 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		add(o7b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));
		
		ogE.addElement(new OptionsGruppeEintrag("Energieklauenpaar", 30));
		add(o7c = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));
		
		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		add(o7dStart = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
		ogE.addElement(new OptionsGruppeEintrag("Kombibolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(o7d = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));
		
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

		champion = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Champion der Auserkorenen",1);
		// Besessen, Hexer, Slaanesh, Champion, Nurgle, Khorne
		champion.initKammer(false,false,false, true, false, false);
		champion.setUeberschriftTrotzNullKostenAusgeben(true);
		add(champion);
		champion.setAbwaehlbar(false);

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
		int count = squad.getModelle();
		mal.setPreis("Mal des Khorne", 2 * count);
		mal.setPreis("Mal des Tzeentch", 2 * count);
		mal.setPreis("Mal des Nurgle", 3 * count);
		mal.setPreis("Mal des Slaanesh", 2 * count);
		
		vdlk.setPreis("Veteranen des Langen Krieges", 2 * count);
		
        if(!champion.isSelected()) champion.setSelected(true);
		
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
		
		
		o7a.setMaxAnzahl(4-o7c.getAnzahl());
		o7b.setMaxAnzahl(4-o7c.getAnzahl());
		
		int bolterSubractor=(o8.isSelected()&&count==5?1:0);
		o7d.setMaxAnzahl(4-bolterSubractor-o7c.getAnzahl());
		
		o7c.setMaxAnzahl(4-bolterSubractor-o7a.getAnzahl()-o7b.getAnzahl()-o7d.getAnzahl());
		
		o7aStart.setMaxAnzahl(count-1-o7a.getAnzahl()-o7c.getAnzahl());
		o7bStart.setMaxAnzahl(count-1-o7b.getAnzahl()-o7c.getAnzahl());
		o7dStart.setMaxAnzahl(count-1-o7d.getAnzahl()-o7c.getAnzahl()-o8.getAnzahl());
		o7aStart.setAnzahl(0,o7aStart.getMaxAnzahl());
		o7bStart.setAnzahl(0,o7bStart.getMaxAnzahl());
		o7dStart.setAnzahl(0,o7dStart.getMaxAnzahl());
	}
}
