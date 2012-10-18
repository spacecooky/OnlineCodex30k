package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.UncertainEldarCorsairAllies;

public class ELBanshees extends UncertainEldarCorsairAllies {

    AnzahlPanel squad;
    OptionsEinzelUpgrade boss;
    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade o2;
    OptionsEinzelUpgrade o3;
    RuestkammerStarter rkTransport;

    public ELBanshees() {
        name = "Banshees";
        grundkosten = 0;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Banshees", 5, 10, 16));

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/ELBanshees.gif"));

        add(boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Exarchin", 12));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Triskele", 5));
        ogE.addElement(new OptionsGruppeEintrag("Todesklinge", 10));
        ogE.addElement(new OptionsGruppeEintrag("Spiegelklingen", 10));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kampfschrei", 5));

        add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kampfsprung", 5));

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
            o2.setAktiv(true);
            o3.setAktiv(true);
        } else {
            o1.setAktiv(false);
            o2.setAktiv(false);
            o3.setAktiv(false);
        }
    }
    
    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }
    
}
