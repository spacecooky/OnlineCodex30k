package oc.wh40k.units.ig;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IGArvusLighter extends Eintrag {

	RuestkammerStarter rkArvus1;
	RuestkammerStarter rkArvus2;
	RuestkammerStarter rkArvus3;

    public IGArvusLighter() {
        name = "Arvus Lighter Squadron";
        grundkosten = 0;

        rkArvus1= new RuestkammerStarter(ID, randAbstand, cnt, "IGArvusLighterKammer", "Arvus Lighter");
        rkArvus1.initKammer(true);
		add(rkArvus1);
		
		rkArvus2= new RuestkammerStarter(ID, randAbstand, cnt, "IGArvusLighterKammer", "Arvus Lighter");
        rkArvus2.initKammer(true);
		add(rkArvus2);
		
		rkArvus3= new RuestkammerStarter(ID, randAbstand, cnt, "IGArvusLighterKammer", "Arvus Lighter");
        rkArvus3.initKammer(true);
		add(rkArvus3);
		
        complete();
    }

    @Override
    public void refreshen() {
    }
    
}
