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
	OptionsEinzelUpgrade Ekrall�;
	OptionsEinzelUpgrade Panzar�stung;
	OptionsEinzelUpgrade Troph�enstange;
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



		Ekrall� = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Energiekrall�", 15);

		add(Ekrall�);

		Panzar�stung = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Panzar�stung", 5);

		add(Panzar�stung);

		Troph�enstange = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Troph�enstange", 5);

		add(Troph�enstange);



		seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-K�rpa", Panzaknakkaz.getModelle()*5));












		complete();



	}

	//@OVERRIDE
	public void refreshen() {

		if (!Boss.isSelected()) {

			Ekrall�.setAktiv(false);

			Panzar�stung.setAktiv(false);

			Troph�enstange.setAktiv(false);
		} else {

			Ekrall�.setAktiv(true);

			Panzar�stung.setAktiv(true);

			Troph�enstange.setAktiv(true);
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
