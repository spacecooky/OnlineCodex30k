package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class TYDieNemesisvonMalanTai extends Eintrag {

	RuestkammerStarter pod;

	public TYDieNemesisvonMalanTai() {
		name = "Die Nemesis von Malan'Tai";
		grundkosten = 90;

		add(ico = new oc.Picture("oc/wh40k/images/TYDieNemesisvonMalanTai.jpg"));
		

		pod = new RuestkammerStarter(ID, randAbstand, cnt, "TYLandungsspore", "Landungsspore");
		pod.initKammer();
		add(pod);

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
