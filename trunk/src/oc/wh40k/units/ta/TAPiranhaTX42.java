package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TAPiranhaTX42 extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1x;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe2;
	OptionsEinzelZaehler oe3;
	OptionsEinzelZaehler oe4;
	OptionsEinzelZaehler oe5;
	OptionsEinzelZaehler oe6;

	public TAPiranhaTX42() {
		name = "Piranha TX-42 Team";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Piranha TX-42", 1, 5, 70);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TAPiranhaTX42.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sync. FuBla","Synchronisierter Fusionsblaster", 0));
		o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0);
		add(o1x);

		ogE.addElement(new OptionsGruppeEintrag("Sync. RakMag", "Synchronisiertes Raketenmagazin", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Plasma", "Synchronisierter Plasmabeschleuniger", 10));
		ogE.addElement(new OptionsGruppeEintrag("Sync. MB-Gewehr", "Synchronisiertes Massebeschleuniger-Gewehr", 10));
		o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0);
		add(o1);

		seperator();

		add(oe1 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Fahrzeugsensorik", 1, 10));
		add(oe2 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Nachtsichtgerät", 1, 5));
		add(oe3 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Flechettewerfer", 1, 10));
		add(oe4 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Ködersystem", 1, 5));
        add(oe5 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Störsystem", 1, 5));
		add(oe6 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Lenkraketen", 2, 10));

		complete();
	}

	@Override
	public void refreshen() {
		int count = squad.getModelle();
		o1.setMaxAnzahl(count);
		o1x.setMaxAnzahl(count);
		o1x.setAnzahl(0, count - o1.getAnzahl());

		oe1.setMaxAnzahl(count);
		oe2.setMaxAnzahl(count);
		oe3.setMaxAnzahl(count);
		oe4.setMaxAnzahl(count);
		oe5.setMaxAnzahl(count);
		oe6.setMaxAnzahl(count * 2);
	}

}
