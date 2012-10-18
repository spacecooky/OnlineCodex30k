package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORKillabot extends Eintrag {

	AnzahlPanel Killabot;
	OptionsZaehlerGruppe KillabotFK;
	OptionsEinzelZaehler Grothälfaz;
	OptionsEinzelZaehler Panzaplattenz;

	public ORKillabot() {

		kategorie = 5;
		grundkosten = 0;
		Killabot = new AnzahlPanel(ID, randAbstand, cnt, "Killabot", "Killabots", 1, 3, 35);
		add(Killabot);

		add(ico = new oc.Picture("oc/wh40k/images/Killabot.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Fette Wumme", 5));
		ogE.addElement(new OptionsGruppeEintrag("Bazzukka", 15));
		ogE.addElement(new OptionsGruppeEintrag("Megablasta", 20));
		ogE.addElement(new OptionsGruppeEintrag("Gitbrenna", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grotzukka", 10));
		KillabotFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
		add(KillabotFK);

		seperator(15);

		Grothälfaz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grothälfaz", Killabot.getModelle(), 5);
		add(Grothälfaz);

		Panzaplattenz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Panzaplattenz", Killabot.getModelle(), 10);
		add(Panzaplattenz);

		complete();

	}

	//@OVERRIDE
	public void refreshen() {

		KillabotFK.setMaxAnzahl(Killabot.getModelle());

		Grothälfaz.setMaxAnzahl(Killabot.getModelle());

		Panzaplattenz.setMaxAnzahl(Killabot.getModelle());

		KillabotFK.setLegal(Killabot.getModelle() == KillabotFK.getAnzahl());

		if(BuildaHQ.getCountFromInformationVector("ORZhadsnark") > 0) {
			setFehlermeldung("Zhadsnark: Keine Bots!");
		} else {
			setFehlermeldung("");
		}
	}
}
