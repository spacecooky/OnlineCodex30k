package oc.whfb.units.vf;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class VFFlederbestie extends Eintrag {

	public VFFlederbestie() {
		name = BuildaHQ.translate("Flederbestie");
		grundkosten = 225;

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Fledermausbefall"), 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Fauliger Rachen"), 15));
                
		complete();
	}

	@Override
	public void refreshen() {
		try {
			setUnikat(true, Integer.valueOf(budget.getText()).intValue() >= 3000 ? 4 : 2);
		} catch (Exception e){
			setUnikat(true, 2);
		}
	}
}
