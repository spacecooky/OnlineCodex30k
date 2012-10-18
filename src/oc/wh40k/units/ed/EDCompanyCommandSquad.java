package oc.wh40k.units.ed;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class EDCompanyCommandSquad extends Eintrag {

	OptionsEinzelUpgrade o1;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o4;
	OptionsZaehlerGruppe o5;
	OptionsZaehlerGruppe o5x;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe2;
	OptionsEinzelZaehler oe3;
	RuestkammerStarter rkTransport;

	boolean creedSelected = false;
	boolean strakenSelected = false;
	boolean kellSelected = false;
	boolean deddogSelected = false;

	public EDCompanyCommandSquad() {
		name = "Elysian Company Command Squad";
		grundkosten = 55;

		add(ico = new oc.Picture("oc/wh40k/images/IGCompanyCommandSquad.jpg"));

		seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Company Commander", 0));

        seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));
		
		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "Melta bombs", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "homing beacon", 10));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Lasgun", "Veteran with Lasgun", 0));
		add(o5x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Laspistol", "Veteran with Laspistol", 0));
		ogE.addElement(new OptionsGruppeEintrag("Auxiliary grenade launcher", "Veteran with Lasgun with auxiliary grenade launcher", 3));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Flamer", "Veteran with Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Veteran with Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", "Veteran with Sniper rifle", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melta gun", "Veteran with Melta gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Veteran with Plasma gun", 15));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mortar-team", "Veteran Heavy Waepons Team with Mortar", 5));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter-team", "Veteran Heavy Waepons Team with Heavy bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher-team", "Veteran Heavy Waepons Team with Missile launcher", 15));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(oe1 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Medi-pack", 1, 30));
		add(oe2 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Regimental standard", 1, 15));
		add(oe3 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Vox caster", 1, 5));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Krak grenades", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Carapace armour", 20));

		seperator();

		add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Officer of the Fleet", 1, 30));
		add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Bodyguard", 2, 15));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "EDValkyrie", "Valkyrie Airborne Assault Carrier");
		rkTransport.initKammer(true);
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        o1.setSelected(true);

		int selectedVeterans = o4.getAnzahl() + o3.getAnzahl() * 2 + o5.getAnzahl();

        o4.setAktiv(selectedVeterans + 1 <= 4 + o4.getAnzahl());
        o3.setAktiv(selectedVeterans + 2 <= 4 + o3.getAnzahl() * 2);

        o5.setAktiv(selectedVeterans + 1 <= 4 + o5.getAnzahl());

        o5.setMaxAnzahl(4 - o4.getAnzahl() - o3.getAnzahl() * 2);
        o5x.setMaxAnzahl(4 - o4.getAnzahl() - o3.getAnzahl() * 2);
        o5x.setAnzahl(0, 4 - o4.getAnzahl() - o3.getAnzahl() * 2 - o5.getAnzahl());

	}


}
