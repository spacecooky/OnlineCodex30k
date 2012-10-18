package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.wh40k.units.UncertainEldarCorsairAllies;

public class ELKriegsfalken extends UncertainEldarCorsairAllies {

    AnzahlPanel squad;
    OptionsEinzelUpgrade boss;
    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade o4;
    OptionsEinzelUpgrade o5;

    public ELKriegsfalken() {
        name = "Kriegsfalken";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Kriegsfalken", 5, 10, 21);
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/Kriegsfalken.gif"));

        add(boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Exarch", 12));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
        ogE.addElement(new OptionsGruppeEintrag("Falkenklaue", 10));
        ogE.addElement(new OptionsGruppeEintrag("Sonnenstrahler", 15));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(o4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hochfliegen", 15));
        add(o5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Abfangen", 5));

        complete();
    }

    @Override
    public void refreshen() {
        super.refreshen();
        
        if (boss.isSelected()) {
            o1.setAktiv(true);
            o4.setAktiv(true);
            o5.setAktiv(true);
        } else {
            o1.setAktiv(false);
            o4.setAktiv(false);
            o5.setAktiv(false);
        }
    }
    
    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }
    
}
