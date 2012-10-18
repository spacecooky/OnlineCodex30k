package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ELFalcon extends Eintrag {

    OptionsUpgradeGruppe o1;

    public ELFalcon() {

        name = "Falcon";
        grundkosten = 115;

        add(ico = new oc.Picture("oc/wh40k/images/Falcon.gif"));
        

        ogE.addElement(new OptionsGruppeEintrag("Shurikenkanone", 5));
        ogE.addElement(new OptionsGruppeEintrag("Impulslaser", 15));
        ogE.addElement(new OptionsGruppeEintrag("Eldar-Raketenwerfer", 20));
        ogE.addElement(new OptionsGruppeEintrag("Sternenkanone", 25));
        ogE.addElement(new OptionsGruppeEintrag("Laserlanze", 30));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator(15);

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Shurikenkanone", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vektorschubdüsen", 20));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusatztriebwerke", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Holofeld", 35));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Seelenstein", 10));

        complete();

    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }
    
}
