package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ORBotmobKammerGargbot extends RuestkammerVater {

	AnzahlPanel Gargbot;
	OptionsZaehlerGruppe GargbotFK;
	//OptionsEinzelUpgrade Grothälfaz;// Da Botmobs allen Bots Grothelfer geben.
	OptionsEinzelUpgrade Panzaplattenz;

	public ORBotmobKammerGargbot() {
		
	}

	public void initButtons(boolean... defaults) {
		name = "Gargbot";

		grundkosten = 75;

		add(ico = new oc.Picture("oc/wh40k/images/Gargbot.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Fette Wumme", 5));
		ogE.addElement(new OptionsGruppeEintrag("Bazzukka", 10));
		ogE.addElement(new OptionsGruppeEintrag("Megablasta", 15));
		ogE.addElement(new OptionsGruppeEintrag("Gitbrenna", 5));
		ogE.addElement(new OptionsGruppeEintrag("Cybotnahkampfwaffe", 15));

		GargbotFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2);
		add(GargbotFK);
		
		seperator(15);

		//Grothälfaz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grothälfaz", 5);// Da Botmobs allen Bots Grothelfer geben.
		//add(Grothälfaz);// Da Botmobs allen Bots Grothelfer geben.
		
		Panzaplattenz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzaplattenz", 10);
		add(Panzaplattenz);

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
		GargbotFK.setLegal(GargbotFK.getAnzahl() == 2);
	}

}
