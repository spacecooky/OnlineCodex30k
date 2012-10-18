package oc.wh40k.units.de;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class DEBestienmeister extends Eintrag {

//	RuestkammerStarter rkBM1;
//	RuestkammerStarter rkBM2;
//	RuestkammerStarter rkBM3;
//	RuestkammerStarter rkBM4;
//	RuestkammerStarter rkBM5;

    RuestkammerStarter[] rkBM = new RuestkammerStarter[5];

	public DEBestienmeister() {
		name = "Bestien-Rotten";
		grundkosten = 0;
        überschriftSetzen = true;

		rkBM[0] = new RuestkammerStarter(ID, randAbstand, cnt, "DEBestienmeisterKammer", "Bestienmeister");
		rkBM[0].initKammer();
		add(rkBM[0]);

		rkBM[1] = new RuestkammerStarter(ID, randAbstand, cnt, "DEBestienmeisterKammer", "Bestienmeister");
		rkBM[1].initKammer();
		add(rkBM[1]);

		rkBM[2] = new RuestkammerStarter(ID, randAbstand, cnt, "DEBestienmeisterKammer", "Bestienmeister");
		rkBM[2].initKammer();
		add(rkBM[2]);

		rkBM[3] = new RuestkammerStarter(ID, randAbstand, cnt, "DEBestienmeisterKammer", "Bestienmeister");
		rkBM[3].initKammer();
		add(rkBM[3]);

		rkBM[4] = new RuestkammerStarter(ID, randAbstand, cnt, "DEBestienmeisterKammer", "Bestienmeister");
		rkBM[4].initKammer();
		add(rkBM[4]);

		complete();
	}

	@Override
	public void refreshen() {
        int count = 0;
        for(int i=0; i<rkBM.length; i++) {
            if(rkBM[i].isSelected()) {
                count += 1;
            } else {
                rkBM[i].getKammer().switchEntry("CLEAR", true);
            }
        }

        this.setName(count == 1 ? "Bestien-Rotte" : "Bestien-Rotten");
        boolean anyoneHasWeapon = false;
        for(int i=0; i<rkBM.length; i++) {
            if(rkBM[i].getKammer().getSpecialValue() == Boolean.TRUE) {
                anyoneHasWeapon = true;
                break;
            }
        }
        
        for(int i=0; i<rkBM.length; i++) {
            if(rkBM[i].getKammer().getSpecialValue() == Boolean.TRUE || !anyoneHasWeapon) {
                rkBM[i].getKammer().switchEntry("WEAPON", true);
            } else {
                rkBM[i].getKammer().switchEntry("WEAPON", false);
            }
        }
	}

}
