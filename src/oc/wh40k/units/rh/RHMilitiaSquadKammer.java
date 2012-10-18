package oc.wh40k.units.rh;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class RHMilitiaSquadKammer extends RuestkammerVater {

	OptionsUpgradeGruppe champ;
	OptionsUpgradeGruppe champFK;
	OptionsUpgradeGruppe champNK;
	OptionsEinzelUpgrade mb;
	OptionsEinzelUpgrade rf;
	
	OptionsEinzelZaehler veterans;
	OptionsEinzelZaehler vox;
	OptionsEinzelZaehler chaos;
	OptionsZaehlerGruppe specWeapon;
	OptionsZaehlerGruppe weaponTeam;
	OptionsZaehlerGruppe weapon;

	public RHMilitiaSquadKammer() {
		grundkosten = 50;
	}

  @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/RHMilitiaSquadKammer.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Veteran", 6));
		add(champ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Lasgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Autogun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Laspistol", 0));
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		add(champFK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();
		
		add(mb = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta bombs", 5));

		seperator();

		add(vox = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "vox-caster", "Renegade with vox-caster", 1, 5));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flamer", "Renegade with flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Renegade with grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", "Renegade with melta gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Renegade with plasma gun", 15));
		add(specWeapon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Heavy stubber team", 5));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter team", 10));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon team", 10));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher team", 15));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon team", 20));
		add(weaponTeam = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Lasgun", "Renegade with lasgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Autogun", "Renegade with autogun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Laspistol and CCW", "Renegade with laspistol and close combat weapon", 0));
		add(weapon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Krak grenades", 10));

		sizeSetzen();
	}

  @Override
	public void refreshen() {
	  	champFK.setAktiv(champ.isSelected());
		if(!champFK.isSelected()) champFK.setSelected(0,true);
		mb.setAktiv(champ.isSelected());
		
		weapon.setMaxAnzahl(10-specWeapon.getAnzahl()-weaponTeam.getAnzahl()*2-(champ.isSelected()?1:0));
		weapon.setLegal(weapon.getAnzahl() == weapon.getMaxAnzahl());
  }

}
