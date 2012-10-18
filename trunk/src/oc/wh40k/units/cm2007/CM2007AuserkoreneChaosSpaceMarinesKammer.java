package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class CM2007AuserkoreneChaosSpaceMarinesKammer extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsEinzelZaehler o2;

	public CM2007AuserkoreneChaosSpaceMarinesKammer() {
		
		grundkosten = 0;
		
	}

	public void initButtons(boolean... defaults) {
		
		add(ico = new oc.Picture("oc/wh40k/images/ChosenChaosSpaceMarines.gif"));
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Auserkorene CSM", 5, 10, 18, "Auserkorene Chaos Space Marines");
		add(squad);

		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Ikone d. Glorreichen Chaos", "Ikone des Glorreichen Chaos", 10));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Slaanesh", 20));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Khorne", 30));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Nurgle", 50));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Tzeentch", 40));

		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator(8);

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Aufstrebender Champion", "Upgrade zum Aufstrebenden Champion", 10));

		seperator(5);

		add(o2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Melterbomben", squad.getModelle(), 5));

		seperator(8);

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 20));
		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanone", 20));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 35));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));

		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energieklauenpaar", 20));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Synchronisierter Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));

		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		sizeSetzen();
	}

	RuestkammerStarter t;

	@Override
	public void refreshen() {
		o2.setMaxAnzahl(squad.getModelle());
	}

}
