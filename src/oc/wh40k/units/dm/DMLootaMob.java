package oc.wh40k.units.dm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DMLootaMob extends Eintrag {

	AnzahlPanel Pluenderaz;
	OptionsEinzelZaehler Mekz;
	OptionsZaehlerGruppe MekzFK;
	OptionsEinzelZaehler Schmiergrot;
	RuestkammerStarter LootedWagon;

	public DMLootaMob() {

		kategorie = 5;



		grundkosten = 0;



		Pluenderaz = new AnzahlPanel(ID, randAbstand, cnt, "Lootaz", 5, 15, 15);

		add(Pluenderaz);



		seperator();



		add(ico = new oc.Picture("oc/wh40k/images/Pluenderaz.gif"));



		Mekz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Meks", 3, 0);

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




		LootedWagon = new RuestkammerStarter(ID, randAbstand, cnt, "DMLootedWagonKammer", "Looted Wagon");

		LootedWagon.initKammer();

		add(LootedWagon);






		complete();

	}

	//@OVERRIDE
	public void refreshen() {

		LootedWagon.setAktiv(Pluenderaz.getModelle() <= 12);

		MekzFK.setMaxAnzahl(Mekz.getAnzahl());

		Schmiergrot.setMaxAnzahl(Mekz.getAnzahl());

	}
}
