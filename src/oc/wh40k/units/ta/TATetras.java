package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;

public class TATetras extends Eintrag {

	AnzahlPanel Tetras;
	OptionsEinzelZaehler o2;
	OptionsEinzelZaehler o3;
	OptionsEinzelZaehler o4;
	OptionsEinzelZaehler o6;
	OptionsEinzelZaehler o7;

	public TATetras() {
		name = "Tetras";
		grundkosten = 0;

		Tetras = new AnzahlPanel(ID, randAbstand, cnt, "Tetra", "Tetras", 1, 4, 50);
		add(Tetras);
		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/Tetras.jpg"));
		

		add(o2 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Fahrzeugsensorik", 1, 10));
		add(o3 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Verb. Zielerfassung", "Verbesserte Zielerfassung", 1, 5));
		add(o4 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Nachtsichtgerät", 1, 5));
		add(o6 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Ködersystem", 1, 5));
		add(o7 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Multiple Zielerfassung", 1, 5));

		complete();

	}

	//@OVERRIDE
	public void refreshen() {
		o2.setMaxAnzahl(Tetras.getModelle());
		o3.setMaxAnzahl(Tetras.getModelle());
		o4.setMaxAnzahl(Tetras.getModelle());
		o6.setMaxAnzahl(Tetras.getModelle());
		o7.setMaxAnzahl(Tetras.getModelle());
	}
}
