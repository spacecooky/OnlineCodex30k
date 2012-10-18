package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;

public class ORPanzaknakkaz extends Eintrag {

	AnzahlPanel Panzaknakkaz;
	OptionsEinzelZaehler Sprengsquiks;
	OptionsEinzelZaehler Panzakloppa;
	OptionsEinzelUpgrade Boss;
	OptionsEinzelUpgrade Ekrallä;
	OptionsEinzelUpgrade Panzarüstung;
	OptionsEinzelUpgrade Trophäenstange;
	OptionsEinzelUpgrade madDokCybork;

	public ORPanzaknakkaz() {

		kategorie = 2;



		grundkosten = 0;



		Panzaknakkaz = new AnzahlPanel(ID, randAbstand, cnt, "Panzaknakkaz", 5, 15, 15);

		add(Panzaknakkaz);





		add(ico = new oc.Picture("oc/wh40k/images/Panzaknakkaz.gif"));





		seperator();





		Sprengsquiks = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Sprengsquiks", 3, 5);

		add(Sprengsquiks);

		Panzakloppa = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Panzakloppa", 2, 0);

		add(Panzakloppa);





		seperator();





		Boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boss", 10);

		add(Boss);



		seperator(5);



		Ekrallä = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Energiekrallä", 15);

		add(Ekrallä);

		Panzarüstung = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Panzarüstung", 5);

		add(Panzarüstung);

		Trophäenstange = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Trophäenstange", 5);

		add(Trophäenstange);



		seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", Panzaknakkaz.getModelle()*5));












		complete();



	}

	//@OVERRIDE
	public void refreshen() {

		if (!Boss.isSelected()) {

			Ekrallä.setAktiv(false);

			Panzarüstung.setAktiv(false);

			Trophäenstange.setAktiv(false);
		} else {

			Ekrallä.setAktiv(true);

			Panzarüstung.setAktiv(true);

			Trophäenstange.setAktiv(true);
		}
		
		if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
		
		madDokCybork.setPreis(Panzaknakkaz.getModelle()*5);



	}
}
