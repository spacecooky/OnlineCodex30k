package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class CM2007Zhufor extends Eintrag {
    
    RuestkammerStarter rkTermis;

	public CM2007Zhufor() {
		name = "Zhufor";
		grundkosten = 185;

		add(ico = new oc.Picture("oc/wh40k/images/CMZhufor.jpg"));
		

        seperator();
        
        rkTermis = new RuestkammerStarter(ID, randAbstand, cnt, "CMZhuforGefolgeKammer", "");
        rkTermis.initKammer();
        rkTermis.setButtonText("Terminatoren-Gefolge");
        rkTermis.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rkTermis);
        
		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
