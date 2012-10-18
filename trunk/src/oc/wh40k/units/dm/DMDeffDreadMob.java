package oc.wh40k.units.dm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class DMDeffDreadMob extends Eintrag {

	AnzahlPanel Gargbot;
	OptionsZaehlerGruppe GargbotFK;
	OptionsEinzelZaehler Grothälfaz;
	OptionsEinzelZaehler Panzaplattenz;

	public DMDeffDreadMob() {

		kategorie = 3;

		grundkosten = 0;

		Gargbot = new AnzahlPanel(ID, randAbstand, cnt, "Deff Dread", "Deff Dreads", 1, 3, 85);

		add(Gargbot);





		add(ico = new oc.Picture("oc/wh40k/images/Gargbot.gif"));



		seperator();







		ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 5));

		ogE.addElement(new OptionsGruppeEintrag("Skorcha", 5));

		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 5));

		ogE.addElement(new OptionsGruppeEintrag("Kustom Mega Blasta", 10));

		ogE.addElement(new OptionsGruppeEintrag("Dreadnaught CCW", 10));



		GargbotFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2);

		add(GargbotFK);



		seperator(15);



		Grothälfaz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grot Riggas", Gargbot.getModelle(), 5);

		add(Grothälfaz);

		Panzaplattenz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Armour Plates", Gargbot.getModelle(), 10);

		add(Panzaplattenz);







		complete();

	}

	//@OVERRIDE
	public void refreshen() {


		GargbotFK.setMaxAnzahl(Gargbot.getModelle()*2);



		Grothälfaz.setMaxAnzahl(Gargbot.getModelle());

		Panzaplattenz.setMaxAnzahl(Gargbot.getModelle());



		GargbotFK.setLegal(Gargbot.getModelle()*2 == GargbotFK.getAnzahl());


	}
}























