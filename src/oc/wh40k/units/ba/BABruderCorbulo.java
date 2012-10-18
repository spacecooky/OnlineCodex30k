package oc.wh40k.units.ba;

import java.util.Vector;

import oc.BuildaHQ;
import oc.Chooser;
import oc.Eintrag;

public class BABruderCorbulo extends Eintrag {

	public BABruderCorbulo() {
		name = "Bruder Corbulo";
		grundkosten = 105;

		BuildaHQ.addToInformationVector("BACorbulo", 1);

		add(ico = new oc.Picture("oc/wh40k/images/BABruderCorbulo.jpg"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
		setEintragsCNT(this.calculateEntryCount());

		setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

	/**
	 * eintragsCNT berechnen
	 * @return eintragsCNT
	 */
	private double calculateEntryCount() {
		double count = 0.0;
		Vector<Chooser> allChooser = BuildaHQ.getChooserGruppe(2).getmC();
		for(Chooser chooser : allChooser) {
			if(chooser.getEintrag() instanceof BASanguiniuspriester || chooser.getEintrag() instanceof BABruderCorbulo) {
				count += 1;
			}
		}

		// merhfache von 3 beachten
		double adder = 1.0;
		double checkCount = count;
		while(checkCount > 3) {
			checkCount = checkCount - 3.0;
			adder++;
		}

		return adder / (count == 0.0 ? 1.0 : count);
	}
}
