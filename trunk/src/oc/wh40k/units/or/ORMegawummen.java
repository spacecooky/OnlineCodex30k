package oc.wh40k.units.or;

import javax.swing.ImageIcon;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORMegawummen extends Eintrag {

	AnzahlPanel wummen;
	OptionsUpgradeGruppe FK;
	OptionsEinzelZaehler Munigrotz;
	OptionsEinzelZaehler CrewGrotz;
	OptionsEinzelUpgrade Treiba;
	OptionsEinzelUpgrade Grotschubsa;
	OptionsEinzelUpgrade madDokCybork;

	public ORMegawummen() {
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/MegawummeKanonae.gif"));
		

        add(wummen = new AnzahlPanel(ID, randAbstand, cnt, "Wummen", 1, 3, 20));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kanonä", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schleuda", 5));
		ogE.addElement(new OptionsGruppeEintrag("Zzapwumme", 10));
		add(FK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(Munigrotz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Munigrotz", 3, 3));
		add(CrewGrotz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "CrewGrotz", 6, 3));

		seperator(8);

		add(Treiba = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Treiba", 10));

		seperator(2);

		add(Grotschubsa = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Grotschubsa", 5));

		
		seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", wummen.getModelle()*10));

		
		complete();

	}
	int aktivesBild = 0;

	//@OVERRIDE
	public void refreshen() {

		FK.setModelle(wummen.getModelle());

		if (Grotschubsa.isAktiv() != Treiba.isSelected()) {
			Grotschubsa.setAktiv(Treiba.isSelected());
		}

		FK.alwaysSelected();

		if (FK.getCurrentName().equals("Zzapwumme")) {
			if (aktivesBild != 1) {
				String icon = "oc/wh40k/images/MegawummeZzappwaffe.gif";
				ico.setIcon(icon);

				try {
					ico.updateSize();
				} catch (Exception e) { }

				aktivesBild = 1;

			}
		} else if (FK.getCurrentName().equals("Schleuda")) {
			if (aktivesBild != 2) {
				String icon = "oc/wh40k/images/MegawummeSchleuda.gif";
				ico.setIcon(icon);

				try {
					ico.updateSize();
				} catch (Exception e) {}

				aktivesBild = 2;

			}
		} else {
			if (aktivesBild != 0) {
				String icon = "oc/wh40k/images/MegawummeKanonae.gif";
				ico.setIcon(icon);
				try {
					ico.updateSize();
				} catch (Exception e) {	}
				aktivesBild = 0;

			}
		}
		
		if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
		
		madDokCybork.setPreis(wummen.getModelle()*10+CrewGrotz.getAnzahl()*5+(Treiba.isSelected() ? 5 : 0));

		if(BuildaHQ.getCountFromInformationVector("ORZhadsnark") > 0) {
			setFehlermeldung("Zhad.: Keine Megaw.!");
		} else {
			setFehlermeldung("");
		}
		
	}
}
