package oc.wh40k.units.dm;


import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DMBurnaBoyz extends Eintrag {

	AnzahlPanel Brennaboyz;
	OptionsEinzelZaehler Mekz;
	OptionsZaehlerGruppe MekzFK;
	OptionsEinzelZaehler Schmiergrot;
	RuestkammerStarter ScrapTrukk;

	public DMBurnaBoyz() {

		kategorie = 2;



		grundkosten = 0;



		Brennaboyz = new AnzahlPanel(ID, randAbstand, cnt, "Burna Boyz", 5, 15, 15);

		add(Brennaboyz);



		seperator();



		add(ico = new oc.Picture("oc/wh40k/images/Brennaboyz.gif"));



		Mekz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Mekz", 3, 0);

		add(Mekz);



		seperator();



		ogE.addElement(new OptionsGruppeEintrag("Slugga & Choppa", 0));

		ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 0));

		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 5));



		MekzFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, Mekz.getAnzahl());

		add(MekzFK);



		seperator();



		Schmiergrot = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Grot Oiler", Mekz.getAnzahl(), 5);

		add(Schmiergrot);





		ScrapTrukk = new RuestkammerStarter(ID, randAbstand, cnt, "DMScrapTrukkKammer", "Scrap Trukk");

		ScrapTrukk.initKammer();

		add(ScrapTrukk);





		complete();

	}

	//@OVERRIDE
	public void refreshen() {



		MekzFK.setMaxAnzahl(Mekz.getAnzahl());

		Schmiergrot.setMaxAnzahl(Mekz.getAnzahl());
		
		ScrapTrukk.setAktiv(Brennaboyz.getModelle() <= 12);

	}
}
