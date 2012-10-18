package oc.wh40k.units.dm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class DMDeffkoptas extends Eintrag {

	AnzahlPanel Killakoptaz;
	OptionsZaehlerGruppe KillakoptazFK;
	OptionsEinzelZaehler Bombä;
	OptionsEinzelZaehler Turbosäge;

	public DMDeffkoptas() {

		kategorie = 4;



		grundkosten = 0;





		Killakoptaz = new AnzahlPanel(ID, randAbstand, cnt, "Deffkopta", "Deffkoptaz", 1, 5, 35);

		add(Killakoptaz);





		add(ico = new oc.Picture("oc/wh40k/images/Killakoptaz.gif"));



		seperator();



		ogE.addElement(new OptionsGruppeEintrag("twin Rokkit Launcha", 10));

		ogE.addElement(new OptionsGruppeEintrag("Kustom Mega Blasta", 5));



		KillakoptazFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);

		add(KillakoptazFK);



		seperator();







		Bombä = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "BigBomm", 1, 15);

		add(Bombä);

		Turbosäge = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Buzzsaw", 1, 10);

		add(Turbosäge);





		complete();

	}

	//@OVERRIDE
	public void refreshen() {



		KillakoptazFK.setMaxAnzahl(Killakoptaz.getModelle());

		Turbosäge.setMaxAnzahl(Killakoptaz.getModelle());

		Bombä.setMaxAnzahl(Killakoptaz.getModelle());







	}
}
