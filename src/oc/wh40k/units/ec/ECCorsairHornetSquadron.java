package oc.wh40k.units.ec;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class ECCorsairHornetSquadron extends Eintrag {

    RuestkammerStarter h1;
    RuestkammerStarter h2;
    RuestkammerStarter h3;

    public ECCorsairHornetSquadron() {
        name = "Corsair Hornet Squadron";
        grundkosten = 0;
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/ECCorsairHornetSquadron.jpg"));

        seperator();
        
        h1 = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairHornetKammer", "Hornet");
        h1.initKammer();
        add(h1);

        h2 = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairHornetKammer", "Hornet");
        h2.initKammer();
        add(h2);

        h3 = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairHornetKammer", "Hornet");
        h3.initKammer();
        add(h3);

        complete();

    }

    @Override
    public void refreshen() {
    }

}
