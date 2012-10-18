package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DACybot extends Eintrag {

    OptionsEinzelUpgrade venerable;
    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    RuestkammerStarter techmarine;
    RuestkammerStarter rkPod;
    RuestkammerStarter rkLuciusPod;

    public DACybot() {
        name = "Cybot";
        grundkosten = 125;

        add(ico = new oc.Picture("oc/wh40k/images/DADreadnought.gif"));
        

        seperator();

        add(venerable = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ehrwürdig", "Upgrade zum Ehrwürdigen Cybot", 20));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Cybot-Nahkampfwaffe", 0));
        ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schwerer Flammenwerfer", 5));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 0));
        ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sync. MaschKa", "Synchronisierte Maschinenkanone", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 20));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

        seperator();

        rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "DADropPodKammer", "");
        rkPod.initKammer(true);
        rkPod.setButtonText("Landungskapsel");
        add(rkPod);

        seperator();

        techmarine = new RuestkammerStarter(ID, randAbstand, cnt, "DATechmarineKammer", "Techmarine");
        techmarine.initKammer();
        add(techmarine);

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) {
            o1.setSelected(0, true);
        }
        if (!o2.isSelected()) {
            o2.setSelected(0, true);
        }
        if (!o3.isSelected()) {
            o3.setSelected(0, true);
        }

        o2.setAktiv(o1.isSelected("Cybot-Nahkampfwaffe"));
    }

}
