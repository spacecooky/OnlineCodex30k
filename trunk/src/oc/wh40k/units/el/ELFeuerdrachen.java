package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.UncertainEldarCorsairAllies;

public class ELFeuerdrachen extends UncertainEldarCorsairAllies {

    AnzahlPanel squad;
    OptionsEinzelUpgrade boss;
    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade o4;
    OptionsEinzelUpgrade o5;
    RuestkammerStarter rkTransport;

    public ELFeuerdrachen() {
        name = "Feuerdrachen";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Feuerdrachen", 5, 10, 16);
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/ELFeuerdrachen.jpg"));

        add(boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Exarch", 12));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Drachenfeuer", 0));
        ogE.addElement(new OptionsGruppeEintrag("Feuerpike", 8));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(o4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Scharfschütze", 5));
        add(o5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Maschinenjäger", 15));

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
