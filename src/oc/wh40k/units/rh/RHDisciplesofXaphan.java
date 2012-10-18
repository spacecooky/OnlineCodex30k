package oc.wh40k.units.rh;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class RHDisciplesofXaphan extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade champ;
	OptionsUpgradeGruppe champNK;
	OptionsUpgradeGruppe champFK;
	OptionsZaehlerGruppe specWeapon;
	OptionsZaehlerGruppe weapon;
	OptionsZaehlerGruppe weaponTeam;
	
	OptionsEinzelUpgrade krak;
	
	RuestkammerStarter rkTransport;
	
	boolean lastState = false;

	public RHDisciplesofXaphan() {
		name = "Disciples of Xaphan";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Disciples", 4, 9, 8);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGRatlingSquad.jpg"));
		
		ogE.addElement(new OptionsGruppeEintrag("Flamer", "Disciple with flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Disciple with grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", "Disciple with melta gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Disciple with plasma gun", 15));
		add(specWeapon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
		seperator();
		
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

		add(krak= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Krak grenades", 5));

		seperator();
		
		add( champ= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Champion", 8));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Lasgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Autogun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Laspistol", 0));
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", 5));
		add(champFK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Close Combat Weapon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Power Weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Powerfist", 15));
		add(champNK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta bombs", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Carapace armour", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Demolition charge", 20));
		
		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "RHChimera", "Chimera");
		rkTransport.initKammer(true);
		add(rkTransport);
		
		complete();
	}

	@Override
	public void refreshen() {
		if(!champ.isSelected()) champ.setSelected(true);
		if(!champFK.isSelected()) champFK.setSelected(0,true);

		champNK.setAktiv(!champFK.isSelected("Lasgun") && !champFK.isSelected("Autogun"));
		if(!champNK.isSelected()) champNK.setSelected(0,true);
	
		if((squad.getModelle()-weaponTeam.getAnzahl()*2)<3){
			specWeapon.setMaxAnzahl(squad.getModelle()-weaponTeam.getAnzahl()*2);
		}else {
			specWeapon.setMaxAnzahl(3);
		}
	
		weaponTeam.setAktiv(squad.getModelle()-specWeapon.getAnzahl()>1);
		weapon.setMaxAnzahl(squad.getModelle()-specWeapon.getAnzahl()-weaponTeam.getAnzahl()*2);
		weapon.setLegal(weapon.getAnzahl() == weapon.getMaxAnzahl());
		
		krak.setPreis(squad.getModelle()+1);
		
	}

}
