package oc.wh40k.units.rh;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class RHMilitiaCommandSquadKammer extends RuestkammerVater {

	OptionsUpgradeGruppe champ;
	OptionsUpgradeGruppe champFK;
	OptionsUpgradeGruppe champNK;
	OptionsEinzelUpgrade mb;
	OptionsEinzelUpgrade ca;
	OptionsEinzelUpgrade rf;
	
	OptionsEinzelZaehler veterans;
	OptionsEinzelZaehler vox;
	OptionsZaehlerGruppe specWeapon;
	OptionsZaehlerGruppe weaponTeam;
	OptionsZaehlerGruppe weapon;

	public RHMilitiaCommandSquadKammer() {
		grundkosten = 30;
	}

  @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/RHMilitiaCommandSquadKammer.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Champion", 0));
		add(champ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		champ.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Lasgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Autogun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Laspistol", 0));
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Shotgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		add(champFK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Close Combat Weapon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Power Weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Powerfist", 15));
		add(champNK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();
		
		add(mb = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta bombs", 5));
		add(ca = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Carapace armour", 5));
		add(rf = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Refractor field", 15));

		seperator();
		
		add(veterans = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Veterans",4, 6));
		
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

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Krak grenades", 5));

		sizeSetzen();
	}

  @Override
	public void refreshen() {
		if(!champ.isSelected()) champ.setSelected(0,true);
		if(!champFK.isSelected()) champFK.setSelected(0,true);

		champNK.setAktiv(!champFK.isSelected("Lasgun") && !champFK.isSelected("Autogun"));
		if(!champNK.isSelected()) champNK.setSelected(0,true);

		veterans.setMaxAnzahl(4-weaponTeam.getAnzahl()*2);
		
		vox.setAktiv(specWeapon.getAnzahl()+weaponTeam.getAnzahl()*2<4);
		specWeapon.setAktiv(vox.getAnzahl()+weaponTeam.getAnzahl()*2<4);
		weaponTeam.setAktiv(vox.getAnzahl()+specWeapon.getAnzahl()<3);
		weapon.setMaxAnzahl(4-specWeapon.getAnzahl()-weaponTeam.getAnzahl()*2);
		weapon.setLegal(weapon.getAnzahl() == weapon.getMaxAnzahl());
	}

}
