package oc.wh40k.units.ed;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class EDVeteranSquad extends Eintrag {

	OptionsEinzelUpgrade o1;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o4;
	OptionsZaehlerGruppe o5;
	RuestkammerStarter rkTransport;

	public EDVeteranSquad() {
		name = "Elysian Veteran Squad";
		grundkosten = 80;

		add(ico = new oc.Picture("oc/wh40k/images/IGVeteranSquad.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Grenadiers", 30));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Forward Observers", 30));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Demolitions", 30));

		seperator();

		add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Vox-caster", 1, 5));
		add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Lascutter", 1, 10));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mortar-team", "Veteran Weapons Team with Mortar", 5));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter-team", "Veteran Weapons Team with Heavy bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher-team", "Veteran Weapons Team with Missile launcher", 15));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Shotgun", "Veteran with Shotgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Auxiliary grenade launcher", "Veteran with Lasgun and Auxiliary grenade launcher", 3));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 9));
		ogE.addElement(new OptionsGruppeEintrag("Flamer", "Veteran with Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Veteran with Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Sniper Rifle", "Veteran with Sniper Rifle", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melta gun", "Veteran with Melta gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Veteran with Plasma gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", "Veteran with Heavy Flamer", 20));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Veteran Sergeant", 0));

        seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Shotgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "EDValkyrie", "Valkyrie Airborne Assault Carrier");
		rkTransport.initKammer(true);
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        o1.setSelected(true);

		o4.setMaxAnzahl(9 - o3.getAnzahl() * 2 - o5.getAnzahl());
        o5.setMaxAnzahl(9 - o3.getAnzahl() * 2 - o4.getAnzahl() > 3 ? 3 : 9 - o3.getAnzahl() * 2 - o4.getAnzahl());
        o3.setMaxAnzahl(9 - o4.getAnzahl() - o5.getAnzahl() >= 2 ? 1 : 0);

        o5.setButtonMaxAnzahl("Veteran with Heavy Flamer", 1);
	}

}
