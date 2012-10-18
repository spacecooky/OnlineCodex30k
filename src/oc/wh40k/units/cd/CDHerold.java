package oc.wh40k.units.cd;

import java.util.List;

import oc.BuildaHQ;
import oc.Chooser;
import oc.Eintrag;

public class CDHerold extends Eintrag {

	public CDHerold() {
	}

	@Override
	public void refreshen() {
        setEintragsCNT(this.calculateEntryCount());
	}

	/**
	 * eintragsCNT berechnen
	 * @return eintragsCNT
	 */
	protected double calculateEntryCount() {
		double count = 0.0;
		List<Chooser> allChooser = BuildaHQ.getChooserGruppe(1).getmC();
		for(Chooser chooser : allChooser) {
			if(chooser.getEintrag() instanceof CDHerold) {
				count += 1;
			}
		}

		// merhfache von 2 beachten
		double adder = 1.0;
		double checkCount = count;
		while(checkCount > 2) {
			checkCount = checkCount - 2.0;
			adder++;
		}

		return adder / (count == 0.0 ? 1.0 : count);
	}

}
