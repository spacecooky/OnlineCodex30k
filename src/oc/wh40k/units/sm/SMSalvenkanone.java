package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.RuestkammerStarter;

public class SMSalvenkanone extends Eintrag {

	RuestkammerStarter rkPod;
        
        boolean siegeForce;

	public SMSalvenkanone() {
		name = "Salvenkanone";
		grundkosten = 100;
                
                siegeForce = OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class);
        
                BuildaHQ.addToInformationVector("SMTechmarineOderMeister", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SMSalvenkanone.jpg"));
                
                if(!siegeForce) {

                    seperator();

                    rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "SMDropPodKammer", "Landungskapsel");
                    rkPod.initKammer(false);
                    rkPod.setButtonText("Landungskapsel");
                    rkPod.setSeperator(0);
                    add(rkPod);

                }

		complete();
	}

	@Override
	public void refreshen() {
	}
    
        @Override
        public void deleteYourself() {
            super.deleteYourself();
            BuildaHQ.addToInformationVector("SMTechmarineOderMeister", -1);
    }

}
