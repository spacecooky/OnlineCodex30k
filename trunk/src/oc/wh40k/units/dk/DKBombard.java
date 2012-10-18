package oc.wh40k.units.dk;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DKBombard extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

    public DKBombard() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGHellhound.jpg"));

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bombard", 145));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", 10));
        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missile", 10));
        ogE.addElement(new OptionsGruppeEintrag("Dozer blade", 10));
        ogE.addElement(new OptionsGruppeEintrag("Extra armour", 15));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 5));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Trojan and Trailer", 0));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!oe1.isSelected()) oe1.setSelected(true);

        o1.setAktiv(0, !o1.isSelected(1));
        o1.setAktiv(1, !o1.isSelected(0));
    }
}
