package oc.wh40k.units.bt;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsPanelSwitcher;
import oc.OptionsUpgradeGruppe;
import oc.OptionsVater;
import oc.RuestkammerVater;

public class BTDropPodKammer extends RuestkammerVater {

    OptionsUpgradeGruppe typ;
    OptionsPanelSwitcher switcher;
    boolean offerLucius = false;

    public BTDropPodKammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        if (defaults.length > 0) {
            this.offerLucius = defaults[0];
        }

        add(ico = new oc.Picture("oc/wh40k/images/BTDropPod.jpg"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Landungskapsel", 30));
        if (this.offerLucius) {
            ogE.addElement(new OptionsGruppeEintrag("[Apocalypse] Lucius-Pod", "Lucius Pattern Drop Pod [Apocalypse-Regeln]", 65));
        }
        add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        OptionsVater[] pod = new OptionsVater[]{
            new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deathwind-System", 20)
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
    }
    
}
