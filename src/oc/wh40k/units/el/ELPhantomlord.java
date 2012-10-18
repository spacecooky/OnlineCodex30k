package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ELPhantomlord extends Eintrag {

    OptionsZaehlerGruppe o3;
    OptionsZaehlerGruppe o3x;
    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

    public ELPhantomlord() {
        name = "Phantomlord";
        grundkosten = 90;

        add(ico = new oc.Picture("oc/wh40k/images/ELPhantomlord.jpg"));
        

        ogE.addElement(new OptionsGruppeEintrag("Shurikenkatapult", 0));
        add(o3x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 0));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator(15);

        ogE.addElement(new OptionsGruppeEintrag("Shurikenkanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Impulslaser", 20));
        ogE.addElement(new OptionsGruppeEintrag("Eldar-Raketenwerfer", 25));
        ogE.addElement(new OptionsGruppeEintrag("Sternenkanone", 30));
        ogE.addElement(new OptionsGruppeEintrag("Laserlanze", 40));
        ogE.addElement(new OptionsGruppeEintrag("Phantomklinge", 10));
        o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(o1);

        seperator(15);

        ogE.addElement(new OptionsGruppeEintrag("Shurikenkanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Impulslaser", 20));
        ogE.addElement(new OptionsGruppeEintrag("Eldar-Raketenwerfer", 25));
        ogE.addElement(new OptionsGruppeEintrag("Sternenkanone", 30));
        ogE.addElement(new OptionsGruppeEintrag("Laserlanze", 40));

        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o3x.setAnzahl(0, o3x.getMaxAnzahl() - o3.getAnzahl());

        o1.alwaysSelected();
    }
    
}
