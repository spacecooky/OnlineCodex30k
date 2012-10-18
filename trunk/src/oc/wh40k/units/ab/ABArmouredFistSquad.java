package oc.wh40k.units.ab;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ABArmouredFistSquad extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    OptionsEinzelUpgrade oe3;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkTransport;

    public ABArmouredFistSquad() {
        name = "Armoured Fist Squad";
        grundkosten = 50;

        add(ico = new oc.Picture("oc/wh40k/images/ABArmouredFistSquad.jpg"));
        

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Voxcaster", 5));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mortar", 5));
        ogE.addElement(new OptionsGruppeEintrag("Autocannon", 10));
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 15));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", 20));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", 5));
        ogE.addElement(new OptionsGruppeEintrag("Melta gun", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Krak grenades", 10));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ABSquadSergeant", "Sergeant");
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
        rkTransport.getPanel().setLocation(
            (int) rkTransport.getPanel().getLocation().getX(),
            (int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height
        );
    }
}
