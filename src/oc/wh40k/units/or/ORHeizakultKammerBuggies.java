package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ORHeizakultKammerBuggies extends RuestkammerVater {

	AnzahlPanel Buggies;
	OptionsZaehlerGruppe BuggiesFK;
	OptionsEinzelZaehler Rot‰Farb‰;
	OptionsEinzelZaehler Groth‰lfaz;
	OptionsEinzelZaehler Panzaplattenz;
	OptionsEinzelZaehler Panzabike;

	public ORHeizakultKammerBuggies() {
		
	}

	public void initButtons(boolean... defaults) {
		grundkosten = 0;

		Buggies = new AnzahlPanel(ID, randAbstand, cnt, "Buggie", "Buggies", 1, 3, 30);
		add(Buggies);

		add(ico = new oc.Picture("oc/wh40k/images/Buggie.gif"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sync. Bazzuka", 5));
		ogE.addElement(new OptionsGruppeEintrag("Gitbrenna", 10));

		BuggiesFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
		add(BuggiesFK);

		seperator(15);

		Rot‰Farb‰ = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Rot‰ Farb‰", 3, 5);
		add(Rot‰Farb‰);

		Groth‰lfaz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Groth‰lfaz", 3, 5);
		add(Groth‰lfaz);

		Panzaplattenz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Panzaplattenz", 3, 10);
		add(Panzaplattenz);

		Panzabike = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Panzabike", 3, 5);
		add(Panzabike);


		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
		BuggiesFK.setMaxAnzahl(Buggies.getModelle());
		Rot‰Farb‰.setMaxAnzahl(Buggies.getModelle());
		Groth‰lfaz.setMaxAnzahl(Buggies.getModelle());
		Panzaplattenz.setMaxAnzahl(Buggies.getModelle());
		Panzabike.setMaxAnzahl(Buggies.getModelle());
	}

}
