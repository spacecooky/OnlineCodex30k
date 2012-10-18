package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.wh40k.units.UncertainEldarCorsairAllies;

public class ELWarpspinnen extends UncertainEldarCorsairAllies {

    AnzahlPanel squad;
    OptionsEinzelUpgrade boss;
    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade o6;
    OptionsEinzelUpgrade o4;
    OptionsEinzelUpgrade o5;

    public ELWarpspinnen() {
        name = "Warpspinnen";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Warpspinnen", 5, 10, 22);
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/Warpspinnen.gif"));

        boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Exarch", 12);
        add(boss);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Zus. Monofilamentschleuder", "Zusätzliche Monofilamentschleuder", 5));
        ogE.addElement(new OptionsGruppeEintrag("Monofilamentblaster", 5));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(o6 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Energieklingen", 10));

        seperator();

        add(o4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Überraschungsangriff", 10));
        add(o5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rückzug", 15));

        complete();
    }

    @Override
    public void refreshen() {
        super.refreshen();
        
        if (boss.isSelected()) {
            o1.setAktiv(true);
            o4.setAktiv(true);
            o5.setAktiv(true);
            o6.setAktiv(true);
        } else {
            o1.setAktiv(false);
            o4.setAktiv(false);
            o5.setAktiv(false);
            o6.setAktiv(false);
        }
    }
    
    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }
    
}
