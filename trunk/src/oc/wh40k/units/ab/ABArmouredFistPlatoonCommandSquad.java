package oc.wh40k.units.ab;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ABArmouredFistPlatoonCommandSquad extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    OptionsEinzelUpgrade oe3;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkTransport;

	public ABArmouredFistPlatoonCommandSquad() {
		name = "Armoured Fist Platoon Command Squad";
		grundkosten = 80;

		add(ico = new oc.Picture("oc/wh40k/images/ABArmouredFistPlatoonCommandSquad.jpg"));
		

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Voxcaster", 5));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Platoon Standard", 15));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mortar", 5));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 15));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon", 20));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy flamer", 20));

		ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melta gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Krak grenades", 5));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ABPlatoonCommanderKammer", "Platoon Commander");
		rkBoss.initKammer();
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
		add(rkBoss);

        seperator();

        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "ABChimeraKammer", "Chimera Transport");
		rkTransport.initKammer();
        rkTransport.setAbwaehlbar(false);
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        int specialists = 0;
        if(oe1.isSelected()) specialists++;
        if(oe2.isSelected()) specialists++;
        if(oe3.isSelected()) specialists++;
        o1.setAktiv(specialists < 3);

        if(o1.isSelected() && o1.isAktiv()) specialists+=2;
        
        o2.setMaxAnzahl(4 - specialists);
        
        rkTransport.getPanel().setLocation(
            (int) rkTransport.getPanel().getLocation().getX(),
            (int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height
        );
	}

}
