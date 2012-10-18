package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class CMZhufor extends Eintrag {
    
    RuestkammerStarter rkTermis;

	public CMZhufor() {
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
