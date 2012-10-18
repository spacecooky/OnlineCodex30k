package oc.wh40k.units.dm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class DMKillaKanAttackMob extends Eintrag {

	AnzahlPanel Killabot;
	OptionsZaehlerGruppe KillabotFK;
	OptionsEinzelZaehler Grothälfaz;
	OptionsEinzelZaehler Panzaplattenz;

	public DMKillaKanAttackMob() {

		kategorie = 4;



		grundkosten = 0;



		Killabot = new AnzahlPanel(ID, randAbstand, cnt, "Killa Kan", "Killa Kans", 3, 5, 40);

		add(Killabot);





		add(ico = new oc.Picture("oc/wh40k/images/Killabot.gif"));



		seperator();







		ogE.addElement(new OptionsGruppeEintrag("Skorcha", 0));

		ogE.addElement(new OptionsGruppeEintrag("Grotzooka", 5));

		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 10));

		ogE.addElement(new OptionsGruppeEintrag("Kustom Mega Blasta", 15));




		KillabotFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);

		add(KillabotFK);



		seperator(15);





		Grothälfaz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grot Riggers", Killabot.getModelle(), 5);

		add(Grothälfaz);

		Panzaplattenz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Armour Plates", Killabot.getModelle(), 10);

		add(Panzaplattenz);







		complete();

	}

	//@OVERRIDE
	public void refreshen() {



		KillabotFK.setMaxAnzahl(Killabot.getModelle());



		Grothälfaz.setMaxAnzahl(Killabot.getModelle());

		Panzaplattenz.setMaxAnzahl(Killabot.getModelle());







	}
}
