package oc.wh40k.units.el;

import oc.Eintrag;

public class ELNightwingInterceptor extends Eintrag {

    public ELNightwingInterceptor() {
        name = "Nightwing Interceptor";
        grundkosten = 145;

        add(ico = new oc.Picture("oc/wh40k/images/ELNightwingInterceptor.jpg"));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
    }
    
}
