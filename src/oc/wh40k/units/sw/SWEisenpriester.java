package oc.wh40k.units.sw;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class SWEisenpriester extends Eintrag {

	AnzahlPanel servitors;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1x;

	public SWEisenpriester() {
		name = "Eisenpriester";
		grundkosten = 50;

		add(ico = new oc.Picture("oc/wh40k/images/SWEisenpriester.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Donnerwolf", 45));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine Bike", 35));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Saga des Eisenwolfes", 15));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wolfszahnkette", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wolfsschwanz Talisman", 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Cyberwolf", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator(20);

		servitors = new AnzahlPanel(ID, randAbstand, cnt, "Servitor", "Servitoren", 0, 3, 10);
		servitors.setZeilenumbruchZuvor(true);
		add(servitors);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Servo-Arm", 0));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 20));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setAktiv(servitors.getModelle() > 0);
		o1x.setAktiv(servitors.getModelle() > 0);
		o1.setMaxAnzahl(servitors.getModelle() >= 3 ? 2 : servitors.getModelle());
		o1x.setMaxAnzahl(servitors.getModelle());
		o1x.setAnzahl(0, servitors.getModelle() - o1.getAnzahl());
	}

}
