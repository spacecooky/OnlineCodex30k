package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RefreshListener;

public abstract class SM_CanHaveValthexHellfireRounds extends Eintrag {

    protected OptionsEinzelUpgrade hellfire;
    boolean hellfireAdded = false;
    
    public SM_CanHaveValthexHellfireRounds() {
        hellfire = new OptionsEinzelUpgrade(0, 0, 0, "", "");
    }

	protected void checkHellfireRounds() {
        hellfire.setAktiv(BuildaHQ.getCountFromInformationVector("SMArmenneusValthex") > 0);

		if (!hellfireAdded && hellfire.isSelected()) {
			BuildaHQ.addToInformationVector("SMArmenneusValthexHellfireRounds", 1);
			hellfireAdded = true;
			RefreshListener.fireRefresh();
		} else if (hellfireAdded && !hellfire.isSelected()) {
			BuildaHQ.addToInformationVector("SMArmenneusValthexHellfireRounds", -1);
			hellfireAdded = false;
			RefreshListener.fireRefresh();
		}

		hellfire.setLegal(BuildaHQ.getCountFromInformationVector("SMArmenneusValthexHellfireRounds") < 2);
	}

}
