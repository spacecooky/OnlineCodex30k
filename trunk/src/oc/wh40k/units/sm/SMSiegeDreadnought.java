package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SMSiegeDreadnought extends Eintrag {

    OptionsEinzelUpgrade rkLuciusPod;

    public SMSiegeDreadnought() {
        name = "Siege Dreadnought";
        grundkosten = 120;

        add(ico = new oc.Picture("oc/wh40k/images/SMSiegeDreadnought.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

        seperator();

        add(rkLuciusPod = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "[Apocalypse] Lucius-Pod", "Lucius Pattern Drop Pod [Apocalypse-Regeln]", 65));

        complete();
    }

    @Override
    public void refreshen() {
    }
    
}
