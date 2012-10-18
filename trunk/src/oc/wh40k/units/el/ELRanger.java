package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.OptionsEinzelUpgrade;
import oc.wh40k.units.UncertainEldarCorsairAllies;

public class ELRanger extends UncertainEldarCorsairAllies {

    AnzahlPanel squad;
    OptionsEinzelUpgrade boss;

    public ELRanger() {
        name = "Ranger";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Ranger", 5, 10, 19);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/Ranger.gif"));

        seperator();

        add(boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Weltenwanderer", 5, squad.getModelle()));

        complete();
    }

    @Override
    public void refreshen() {
        super.refreshen();
        
        boss.setModelle(squad.getModelle());
    }
    
    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }
    
}
