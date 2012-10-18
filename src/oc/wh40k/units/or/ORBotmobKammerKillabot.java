package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ORBotmobKammerKillabot extends RuestkammerVater {

	AnzahlPanel Killabot;
	OptionsZaehlerGruppe KillabotFK;
	//OptionsEinzelZaehler Grothälfaz;// Da Botmobs allen Bots Grothelfer geben.
	OptionsEinzelZaehler Panzaplattenz;

	public ORBotmobKammerKillabot() {
		
	}

	public void initButtons(boolean... defaults) {
		grundkosten = 0;

		Killabot = new AnzahlPanel(ID, randAbstand, cnt, "Killabot", "Killabots", 3, 3, 35);
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

		//Grothälfaz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grothälfaz", Killabot.getModelle(), 5);// Da Botmobs allen Bots Grothelfer geben.
		//add(Grothälfaz);// Da Botmobs allen Bots Grothelfer geben.
		Panzaplattenz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Panzaplattenz", Killabot.getModelle(), 10);
		add(Panzaplattenz);

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
		KillabotFK.setMaxAnzahl(Killabot.getModelle());
		//Grothälfaz.setMaxAnzahl(Killabot.getModelle()); // Da Botmobs allen Bots Grothelfer geben.
		Panzaplattenz.setMaxAnzahl(Killabot.getModelle());
		KillabotFK.setLegal(Killabot.getModelle() == KillabotFK.getAnzahl());
	}

}
