package oc.wh40k.units.dk;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DKCompanyCommandSquad extends Eintrag {

	OptionsEinzelUpgrade o1;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o4;
	OptionsZaehlerGruppe o5;
	OptionsZaehlerGruppe o5x;
	OptionsEinzelZaehler oe2;
	OptionsEinzelZaehler oe3;
	OptionsEinzelZaehler oe4;
	OptionsEinzelZaehler oe5;
	OptionsEinzelZaehler oe6;
	OptionsEinzelZaehler oe7;
	RuestkammerStarter rkTransport;

	boolean creedSelected = false;
	boolean strakenSelected = false;
	boolean kellSelected = false;
	boolean deddogSelected = false;

	public DKCompanyCommandSquad() {
		name = "Company Command Squad";
		grundkosten = 60;

		add(ico = new oc.Picture("oc/wh40k/images/IGCompanyCommandSquad.jpg"));

		seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Company Commander", 0));

        seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Boltgun", 2));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

        seperator(5);

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Lasgun", "Veteran with Lasgun", 0));
		add(o5x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Laspistol", "Veteran with Laspistol", 0));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Flamer", "Veteran with Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Veteran with Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melta gun", "Veteran with Melta gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Veteran with Plasma gun", 15));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Autocannon-team", "Veteran Heavy Weapons Team with Autocannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter-team", "Veteran Heavy Weapons Team with Heavy bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy stubber-team", "Veteran Heavy Weapons Team with twin-linked Heavy stubbers", 15));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(oe2 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Regimental standard", 1, 15));
		add(oe3 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Vox caster", 1, 5));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Krak grenades", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Carapace armour", 20));

		seperator();

		add(oe4 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Astropath", 1, 30));
		add(oe5 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Master of Ordnance", 1, 30));
		add(oe6 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Officer of the Fleet", 1, 30));
		add(oe7 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Bodyguard", 2, 15));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DKCentaur", "Centaur");
		rkTransport.initKammer();
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        o1.setSelected(true);

		int selectedVeterans = o4.getAnzahl() + o3.getAnzahl() * 2 + oe2.getAnzahl() + oe3.getAnzahl();

        o4.setAktiv(selectedVeterans + 1 + o5.getAnzahl() <= 4 + o4.getAnzahl());
        o3.setAktiv(selectedVeterans + 2 + o5.getAnzahl() <= 4 + o3.getAnzahl() * 2);
        oe2.setAktiv(selectedVeterans + 1 <= 4 + oe2.getAnzahl());
        oe3.setAktiv(selectedVeterans + 1 <= 4 + oe3.getAnzahl());

        o5.setMaxAnzahl(4 - o4.getAnzahl() - o3.getAnzahl() * 2);
        o5x.setMaxAnzahl(4 - o4.getAnzahl() - o3.getAnzahl() * 2);
        o5x.setAnzahl(0, 4 - o4.getAnzahl() - o3.getAnzahl() * 2 - o5.getAnzahl());

        rkTransport.setAktiv(!(oe4.isSelected() || oe5.isSelected() || oe6.isSelected() || oe7.isSelected()));
	}


}
