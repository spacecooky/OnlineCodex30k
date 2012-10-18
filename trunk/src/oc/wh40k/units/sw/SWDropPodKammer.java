package oc.wh40k.units.sw;

import oc.OptionsGruppeEintrag;
import oc.OptionsPanelSwitcher;
import oc.OptionsUpgradeGruppe;
import oc.OptionsVater;
import oc.RuestkammerVater;

public class SWDropPodKammer extends RuestkammerVater {

    OptionsUpgradeGruppe typ;
    OptionsUpgradeGruppe podWeapon;
    OptionsPanelSwitcher switcher;
    boolean offerLucius = false;

    public SWDropPodKammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        if (defaults.length > 0) {
            this.offerLucius = defaults[0];
        }

        add(ico = new oc.Picture("oc/wh40k/images/SWDropPod.jpg"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Landungskapsel", 35));
        if (this.offerLucius) {
            ogE.addElement(new OptionsGruppeEintrag("[Apocalypse] Lucius-Pod", "Lucius Pattern Drop Pod [Apocalypse-Regeln]", 65));
        }
        add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Deathwind-System", 20));

        OptionsVater[] pod = new OptionsVater[]{
            podWeapon = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE)
        };

        OptionsVater[] empty = new OptionsVater[]{};

        add(switcher = new OptionsPanelSwitcher(randAbstand, cnt, pod, empty));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        switcher.switchPanel(typ.getSelectedIndex());

        if (!typ.isSelected()) {
            typ.setSelected(0, true);
        }

        if (!podWeapon.isSelected()) {
            podWeapon.setSelected(0, true);
        }
    }
    
}
