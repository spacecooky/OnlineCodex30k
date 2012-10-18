package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ELShadowSpectres extends Eintrag {

    AnzahlPanel squad;
    OptionsEinzelUpgrade boss;
    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

    public ELShadowSpectres() {
        name = "Shadow Spectres";
        grundkosten = 0;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Shadow Spectres", 3, 6, 35));
        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/ELShadowSpectres.jpg"));
        

        add(boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Upgrade to Exarch", 12));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Prism Lanc", 10));
        ogE.addElement(new OptionsGruppeEintrag("Haywire Launcher", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Cynosure", 15));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Withdraw", 15));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setAktiv(boss.isSelected());
        oe1.setAktiv(boss.isSelected());
        oe2.setAktiv(boss.isSelected());
    }

}
