package oc.wh40k.units.or;

import javax.swing.ImageIcon;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class ORBoyz extends Eintrag {

	AnzahlPanel boyz;
	OptionsEinzelUpgrade stikkbombz;
	OptionsEinzelUpgrade wummen;
	OptionsZaehlerGruppe boyzFK;
	OptionsEinzelUpgrade panzaboys;
	OptionsEinzelUpgrade boss;
	OptionsUpgradeGruppe bossCC;
	OptionsEinzelUpgrade trophäenstange;
	OptionsEinzelUpgrade panzarüstung;
	OptionsEinzelUpgrade madDokCybork;
	RuestkammerStarter PikkUp;

	public ORBoyz() {

		kategorie = 1;

		name = "Boyz";







		grundkosten = 0;



		boyz = new AnzahlPanel(ID, randAbstand, cnt, "Boyz", 10, 30, 6);

		add(boyz);





		add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

		seperator();





		wummen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wummen", 0, boyz.getModelle());

		add(wummen);

		seperator(5);



		panzaboys = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzaboyz", 4, boyz.getModelle());

		add(panzaboys);



		stikkbombz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbombz", 1, boyz.getModelle());

		add(stikkbombz);

		seperator(5);



		ogE.addElement(new OptionsGruppeEintrag("Fette Wumme", 5));

		ogE.addElement(new OptionsGruppeEintrag("Bazzukka", 10));



		boyzFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);

		add(boyzFK);

		seperator();









		boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boss", 10);

		add(boss);



		seperator(5);



		ogE.addElement(new OptionsGruppeEintrag("Fette Spalta", 5));

		ogE.addElement(new OptionsGruppeEintrag("Energiekrallä", 25));



		bossCC = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE);

		add(bossCC);

		seperator(5);





		add(trophäenstange = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Trophä'enstangä", 5));

		add(panzarüstung = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Panzarüstung", 5));

		seperator();

		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", boyz.getModelle()*5));

		seperator();
		
		PikkUp = new RuestkammerStarter(ID, randAbstand, cnt, "ORPikkUpKammer", "Pikk Up");

		PikkUp.initKammer();

		add(PikkUp);





		complete();



	}

	public void deleteYourself() {  // WICHTIG: wird nicht beim Volkwechseln ausgeführt. Dafr wird BuildaHQ.leereChooserGruppenArray(); aufgerufen, was das ersetzt

		if (panzaboyz) {
			BuildaHQ.addToInformationVector("Panzaboyz", -1);
		}

		super.deleteYourself();

	}
	boolean wummenBild = false;
	boolean panzaboyz;

	@Override
	public void refreshen() {



		bossCC.setAktiv(boss.isSelected());

		trophäenstange.setAktiv(boss.isSelected());

		panzarüstung.setAktiv(boss.isSelected());





		boyzFK.setMaxAnzahl(boyz.getModelle() / 10);

		stikkbombz.setModelle(boyz.getModelle());

		panzaboys.setModelle(boyz.getModelle());



		if (panzaboys.isSelected() && panzarüstung.isSelected()) {

			panzarüstung.setSelected(false);
		}



		PikkUp.setAktiv(boyz.getModelle() <= 12);



		if (wummen.isSelected() == true && wummenBild == false) {

			String icon = "oc/wh40k/images/Ballaboy.gif";

			ico.setIcon(icon);

			try {
				ico.updateSize();
			} catch (Exception e) {
			}

			wummenBild = true;
		}



		if (wummen.isSelected() == false && wummenBild == true) {

			String icon = "oc/wh40k/images/Moschaboy.gif";

			ico.setIcon(icon);

			try {
				ico.updateSize();
			} catch (Exception e) {
			}

			wummenBild = false;
		}





		if (panzaboyz != panzaboys.isSelected()) {

			panzaboyz = !panzaboyz;

			if (panzaboyz) {

				BuildaHQ.addToInformationVector("Panzaboyz", 1);
			} else {

				BuildaHQ.addToInformationVector("Panzaboyz", -1);
			}

			RefreshListener.fireRefresh();

		}



		panzaboys.setLegal(BuildaHQ.getCountFromInformationVector("Panzaboyz") < 2 || !panzaboys.isSelected());


		if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
		
		madDokCybork.setPreis(boyz.getModelle()*5);

	}
}
