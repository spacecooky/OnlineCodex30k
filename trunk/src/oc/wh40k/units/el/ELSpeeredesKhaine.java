package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.wh40k.units.UncertainEldarCorsairAllies;

public class ELSpeeredesKhaine extends UncertainEldarCorsairAllies {

    AnzahlPanel squad;
    OptionsEinzelUpgrade boss;
    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade o3;
    OptionsEinzelUpgrade o4;
    OptionsEinzelUpgrade o5;

    public ELSpeeredesKhaine() {
        name = "SpeeredesKhaine";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Speere des Khaine", 3, 5, 35);
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/SpeeredesKhaine.gif"));

        add(boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Exarch", 12));

        seperator();

        add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Shurikenkanone", 15));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sternenlanze", 15));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(o4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Erfahrener Pilot", 10));
        add(o5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rückzug", 25));

        complete();
    }

    @Override
    public void refreshen() {
        super.refreshen();
        
        if (boss.isSelected()) {
            o1.setAktiv(true);
            o3.setAktiv(true);
            o4.setAktiv(true);
            o5.setAktiv(true);
        } else {
            o1.setAktiv(false);
            o3.setAktiv(false);
            o4.setAktiv(false);
            o5.setAktiv(false);
        }
    }
    
    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }
    
}
