package oc.wh40k.units.dk;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class DKPlatoonCommandSquad extends RuestkammerVater {

	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o22;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o4;
	OptionsZaehlerGruppe o4x;
    OptionsEinzelZaehler oe2;
    OptionsEinzelZaehler oe3;
    OptionsEinzelUpgrade mb;
	OptionsEinzelUpgrade commissar;
	OptionsEinzelUpgrade commander;
	RuestkammerStarter rkTransport;

	public DKPlatoonCommandSquad() {
		grundkosten = 40;
	}

  @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGCommandSquad.jpg"));
		

		seperator();

		add(commander = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Platoon Commander", 0));

        seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator(5);

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "melta-bombs", 5));

		seperator();

		add(commissar = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Commissar", 35));

		seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(o22 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		cnt = randAbstand;

		add(oe2 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Platoon standard", 1, 15));
		add(oe3 = new OptionsEinzelZaehler(0, randAbstand + 280, cnt, "", "Vox-caster", 1, 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Lasgun", "Guardsman with Lasgun", 0));
		add(o4x = new OptionsZaehlerGruppe(ID, randAbstand + 280, cnt, "", ogE, 2));
		ogE.addElement(new OptionsGruppeEintrag("Flamer", "Guardsman with Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Guardsman with Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melta gun", "Guardsman with Melta gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Guardsman with Plasma gun", 15));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand + 280, cnt, "", ogE, 2));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "option", "Krak grenades", 5));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand + 280, cnt, "DKCentaur", "Centaur");
		rkTransport.initKammer();
		add(rkTransport);

		sizeSetzen();
	}

  @Override
	public void refreshen() {
        commander.setSelected(true);

		o22.setAktiv(commissar.isSelected());

        o4x.setMaxAnzahl(4 - o4.getAnzahl());
        o4x.setAnzahl(0, 4 - o4.getAnzahl());
	}

}
