package oc.wh40k.units.sm;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsPanelSwitcher;
import oc.OptionsSeperator;
import oc.OptionsUpgradeGruppe;
import oc.OptionsVater;
import oc.RuestkammerVater;

public class SMDropPodKammer extends RuestkammerVater {

    OptionsUpgradeGruppe typ;
    OptionsPanelSwitcher switcher;
    OptionsUpgradeGruppe podWeapon;
    
    boolean offerLucius = false;
    boolean free = false;

    public SMDropPodKammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        if (defaults.length > 0) {
            this.offerLucius = defaults[0];
        }
        if (defaults.length > 1) {
            this.free = defaults[1];
        }

        add(ico = new oc.Picture("oc/wh40k/images/SMDropPod.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Landungskapsel", free ? 0 : 35));
        if (this.offerLucius) {
            ogE.addElement(new OptionsGruppeEintrag("[Apocalypse] Lucius-Pod", "Lucius Pattern Drop Pod [Apocalypse-Regeln]", 65));
        }
        add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Deathwind-System", 20));

        OptionsVater[] pod = new OptionsVater[]{
            podWeapon = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE),
            new OptionsSeperator(5),
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Peilsender", 10)
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
