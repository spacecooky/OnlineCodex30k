package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CM2007AuserkoreneChaosSpaceMarines extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelZaehler o2;

	public CM2007AuserkoreneChaosSpaceMarines() {
		name = "Auserkorene Chaos Space Marines";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Auserkorene CSM", 5, 10, 18, "Auserkorene Chaos Space Marines");
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChosenChaosSpaceMarines.gif"));

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

		seperator();
		seperator();

		t = new RuestkammerStarter(ID, randAbstand, cnt, "CMTransporter", "Transporter");
		t.initKammer();
                t.setButtonText("Transporter");
		add(t);

		complete();
	}

	RuestkammerStarter t;

	@Override
	public void refreshen() {
		o2.setMaxAnzahl(squad.getModelle());
	}

}
