package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;

public class CM2007AetaosraukeresSlayerofSouls extends Eintrag {

	public CM2007AetaosraukeresSlayerofSouls() {
		name = "Aetaos'rau'keres - Slayer of Souls";
		grundkosten = 999;

		add(ico = new oc.Picture("oc/wh40k/images/AetaosraukeresSlayerofSouls.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        if(OnlineCodex.getInstance().getKosten() < 2000 && OnlineCodex.getInstance().getCurrentArmy().equals("Chaosdaemonen")) {
            this.setFehlermeldung("Armee < 2000 Punkte");
        } else {
            this.setFehlermeldung("");
        }
	}

}
