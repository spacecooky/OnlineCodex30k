package oc.wh40k.units.ec;

import oc.Eintrag;

public class ECNightwingInterceptor extends Eintrag {

    public ECNightwingInterceptor() {
        name = "Nightwing Interceptor";
        grundkosten = 145;

        add(ico = new oc.Picture("oc/wh40k/images/ECNightwingInterceptor.jpg"));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
    }
    
}
