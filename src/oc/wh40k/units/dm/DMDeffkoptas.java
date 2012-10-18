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
	OptionsEinzelZaehler Bomb�;
	OptionsEinzelZaehler Turbos�ge;

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







		Bomb� = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "BigBomm", 1, 15);

		add(Bomb�);

		Turbos�ge = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Buzzsaw", 1, 10);

		add(Turbos�ge);





		complete();

	}

	//@OVERRIDE
	public void refreshen() {



		KillakoptazFK.setMaxAnzahl(Killakoptaz.getModelle());

		Turbos�ge.setMaxAnzahl(Killakoptaz.getModelle());

		Bomb�.setMaxAnzahl(Killakoptaz.getModelle());







	}
}
