package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORKillakoptaz extends Eintrag {

	AnzahlPanel Killakoptaz;
	OptionsZaehlerGruppe KillakoptazFK;
	OptionsEinzelZaehler Bombä;
	OptionsEinzelZaehler Turbosäge;
	OptionsEinzelUpgrade madDokCybork;

	public ORKillakoptaz() {

		kategorie = 4;



		grundkosten = 0;





		Killakoptaz = new AnzahlPanel(ID, randAbstand, cnt, "Killakopta", "Killakoptaz", 1, 5, 35);

		add(Killakoptaz);





		add(ico = new oc.Picture("oc/wh40k/images/Killakoptaz.gif"));



		seperator();



		ogE.addElement(new OptionsGruppeEintrag("Sync. Bazzukka", 10));

		ogE.addElement(new OptionsGruppeEintrag("Megablasta", 5));



		KillakoptazFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);

		add(KillakoptazFK);



		seperator();







		Bombä = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Bombä", 1, 15);

		add(Bombä);

		Turbosäge = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Turbosäge", 1, 25);

		add(Turbosäge);


		seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", Killakoptaz.getModelle()*5));



		complete();

	}

	//@OVERRIDE
	public void refreshen() {



		KillakoptazFK.setMaxAnzahl(Killakoptaz.getModelle());

		Turbosäge.setMaxAnzahl(Killakoptaz.getModelle());

		Bombä.setMaxAnzahl(Killakoptaz.getModelle());


		if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
		
		madDokCybork.setPreis(Killakoptaz.getModelle()*5);




	}
}
