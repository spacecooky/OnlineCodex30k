package oc.wh40k.units.el;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ELWraithseer extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

    public ELWraithseer() {
        this.setCountToMinimum(false);

        name = "Wraithseer";
        grundkosten = 185;

        add(ico = new oc.Picture("oc/wh40k/images/ELWraithseer.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bright Lance", 30));
        ogE.addElement(new OptionsGruppeEintrag("Scatter Laser", 10));
        ogE.addElement(new OptionsGruppeEintrag("Eldar Missile Launcher", 15));
        ogE.addElement(new OptionsGruppeEintrag("Star Cannon", 20));
        ogE.addElement(new OptionsGruppeEintrag("D-Cannon", 40));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
    }
}
