package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.UncertainEldarCorsairAllies;

public class ELPhantomdroiden extends UncertainEldarCorsairAllies {

    AnzahlPanel squad;
    OptionsEinzelUpgrade boss;
    RuestkammerStarter rkLeser;
    RuestkammerStarter rkSerpent;

    public ELPhantomdroiden() {
        name = "Phantomdroiden";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Phantomdroiden", 3, 10, 35);
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/Phantomdroiden.gif"));


        rkLeser = new RuestkammerStarter(ID, randAbstand, cnt, "ELRunenleserKammer", "Runenleser");
        rkLeser.initKammer(false, false);
        add(rkLeser);

        seperator(10);

        rkSerpent = new RuestkammerStarter(ID, randAbstand, cnt, "ELSerpentKammer", "Serpent");
        rkSerpent.initKammer();

        add(rkSerpent);

        complete();
    }

    @Override
    public void refreshen() {
        super.refreshen();
        
        rkSerpent.setAktiv(squad.getModelle() < 6);
        rkSerpent.getPanel().setLocation((int) rkSerpent.getPanel().getLocation().getX(), (int) rkLeser.getPanel().getLocation().getY() + rkLeser.getPanel().getSize().height + 8);
    }
    
    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }
    
}
