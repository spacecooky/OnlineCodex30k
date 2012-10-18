package oc.wh40k.units.cm;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CMChaosbiker extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;
	OptionsUpgradeGruppe mal;
	OptionsUpgradeGruppe ikone;
	OptionsUpgradeGruppe vdlk;
	
	public CMChaosbiker() {
		//name = "Chaosbiker\n";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Biker", 3, 10, 20, "Chaosbiker");
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosBikers.gif"));

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
		
		ogE.addElement(new OptionsGruppeEintrag("Veteranen", "Veteranen des Langen Krieges", 1));
		add(vdlk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Champion der Chaosbiker",1);
		// Besessen, Hexer, Slaanesh, Champion, Nurgle, Khorne
		rkBoss.initKammer(false,false,false, false, false, true);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		rkBoss.setGrundkosten(10);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
		
		int count = squad.getModelle();
		mal.setPreis("Mal des Khorne", 2 * count);
		mal.setPreis("Mal des Tzeentch", 3 * count);
		mal.setPreis("Mal des Nurgle", 6 * count);
		mal.setPreis("Mal des Slaanesh", 2 * count);
		
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
		
		vdlk.setPreis("Veteranen des Langen Krieges", 1 * count);
	}

}
