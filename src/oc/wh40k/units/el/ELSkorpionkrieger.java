package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.UncertainEldarCorsairAllies;

public class ELSkorpionkrieger extends UncertainEldarCorsairAllies {

    AnzahlPanel squad;
    OptionsEinzelUpgrade boss;
    OptionsEinzelUpgrade o1;
    OptionsEinzelUpgrade o2;
    OptionsEinzelUpgrade o3;
    OptionsEinzelUpgrade o4;
    OptionsEinzelUpgrade o5;
    RuestkammerStarter rkTransport;

    public ELSkorpionkrieger() {
        name = "Skorpionkrieger";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Skorpionkrieger", 5, 10, 16);
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/Skorpionkrieger.gif"));

        add(boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Exarch", 12));

        seperator();

        add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Skorpionschere", 15));
        add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Reiﬂende Klinge", 5));
        add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Skorpions‰bel", 5));

        seperator();

        add(o4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schleicher", 5));
        add(o5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schattenwandler", 20));

        seperator();

        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "ELSerpentKammer", "Serpent");
        rkTransport.initKammer();
        add(rkTransport);

        complete();
    }

    @Override
    public void refreshen() {
        super.refreshen();
        
        if (boss.isSelected()) {
            o1.setAktiv(!o3.isSelected());
            o2.setAktiv(!o3.isSelected());
            o3.setAktiv(!o1.isSelected() && !o2.isSelected());
            o4.setAktiv(true);
            o5.setAktiv(true);
        } else {
            o1.setAktiv(false);
            o2.setAktiv(false);
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
